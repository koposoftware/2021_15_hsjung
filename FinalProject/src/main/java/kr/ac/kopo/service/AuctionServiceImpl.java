package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamodeling.common.Pagination;
import com.javamodeling.common.ResultPojoList;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.dao.AccountDao;
import kr.ac.kopo.dao.AuctionDao;
import kr.ac.kopo.dao.MemberDao;
import kr.ac.kopo.dao.PhotoDao;
import kr.ac.kopo.dao.ProductDao;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.AuctionProductImg;
import kr.ac.kopo.pojo.AuctionTransaction;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransaction;
import kr.ac.kopo.pojo.AuctionProduct;

@Service
public class AuctionServiceImpl extends ServiceSupport implements AuctionService {

	@Autowired
	AuctionDao auctionDao;
	
	@Autowired
	private MemberDao memberdao;
	
	@Override
	public ResultPojoList searchAuctionList(Pagination pagination) {

		ResultPojoList auctionList = new ResultPojoList();
		
		auctionList.setList(auctionDao.searchAuctionList(pagination));
		
		pagination.setTotalCount(auctionDao.countAuctionList(pagination));
		
		auctionList.setPagination(pagination);
		
		return auctionList;
	}
	
	@Override
	public ResultPojoList searchAuctionListByCategory(Pagination pagination, ProductCategory productCategory, Member member) {

		ResultPojoList auctionList = new ResultPojoList();
		MemberInfo memberInfResult = new MemberInfo();
		
		memberdao.beginTransaction();
		
		memberInfResult = memberdao.obtainMemberInfoByMember(member,productCategory);
		memberInfResult.setCountCategory(memberInfResult.getCountCategory() + 1L);//LINE :: 상품 카운팅
		
		productCategory = auctionDao.obtainEntityByPk(productCategory);
		auctionList.setList(auctionDao.searchAuctionListByCategory(pagination,productCategory));
		
		pagination.setTotalCount(auctionDao.countAuctionListByCategory(pagination,productCategory));
		auctionList.setPagination(pagination);
		
		memberdao.flush();
		memberdao.commitTransaction();
		
		return auctionList;
	}

	
	
	@Override
	public AuctionProduct obtainAuctionProductByPk(AuctionProduct usedAuctionProduct) {

		AuctionProduct usedProductResult = new AuctionProduct();
		
		auctionDao.beginTransaction();
		
		usedProductResult = auctionDao.obtainAuctionProductByPk(usedAuctionProduct);
		
		usedProductResult.setViewCnt(usedProductResult.getViewCnt() + 1L);
		
		auctionDao.flush();
		auctionDao.commitTransaction();
		
		return usedProductResult;
	}

	
	@Override
	public AuctionProduct addAuctionProduct(List<HanaFile> hanaFileResultList, AuctionProduct auctionProduct) {
		
		AuctionProduct auctionProductResult = new AuctionProduct();
		HanaFile hanaFileResult = new HanaFile();
		AuctionProductImg auctionProductImg = null;
		
		try {
			auctionDao.beginTransaction();
			auctionProductResult = auctionDao.addEntity(auctionProduct);
			
			for(int i=0;i<hanaFileResultList.size();i++) {
				
				auctionProductImg = new AuctionProductImg();
				
				auctionProductImg.setAuctionProduct(auctionProductResult);
				
				hanaFileResult = auctionDao.addEntity(hanaFileResultList.get(i));
				
				auctionProductImg.setFileSq(hanaFileResult.getFileSq());
				
				auctionProductImg = auctionDao.addEntity(auctionProductImg);
				auctionProductResult.setResultCodePlus();
			
			}
		}catch (Exception e){
			e.printStackTrace();
			auctionDao.rollbackTransaction();
			auctionProductResult.setResultCodeMinus();
		} finally {
			auctionDao.commitTransaction();
		}
		
		return auctionProductResult;
		
	}

	@Override
	public AuctionProduct modifyAuctionProduct(AuctionProduct auctionProduct, Member member) {

		Member memberChk = new Member();
		Account accChk = new Account();
		memberChk = auctionDao.obtainEntityByPk(memberChk);
		
		accChk = auctionDao.obtainEntityByPk(memberChk.getAccounts().get(0));
		
		if(auctionProduct.getPriceNow() > accChk.getChange()) {
			
			auctionProduct.setResultMessage("금액이 부족합니다.");
			auctionProduct.setResultCodeMinus();//JSP에러 출력
			return auctionProduct;
			
		}else {
			
			auctionDao.beginTransaction();
			AuctionProduct auctionProductResult =  new AuctionProduct();
			Member oldMemberResult = new Member();
			Account newAccount = new Account();
			Account oldAccount = new Account();
			
			History history = new History();
			
			auctionProductResult = auctionDao.obtainEntityByPk(auctionProduct);
			auctionProductResult.setIbchalja(member.getMemberSq());
			
			auctionProductResult.setPriceNow(auctionProductResult.getPriceNow() + auctionProduct.getModifyPrice());
			
			newAccount = auctionDao.obtainEntityByPk(member.getAccounts().get(0));
			newAccount.setChange(newAccount.getChange() - auctionProduct.getPriceNow());//입찰자 돈 빼기
			
			history.setAccount(newAccount);
			history.setChange(newAccount.getChange());//LINE :: 현재 보유중인 잔액
			history.setModifyChange(auctionProductResult.getPriceNow() + auctionProduct.getModifyPrice());//LINE :: 입금금액
			history.setReceiverAccountNumber(0L);//LINE :: 받는 계좌 번호
			history.setReceiverBankCode(0L);//LINE :: 보내는 계좌 번호
			history.setTask("입금");
			
			history = auctionDao.addEntity(history);
			oldMemberResult.setMemberSq(auctionProduct.getIbchalja());
			oldMemberResult = auctionDao.obtainEntityByPk(oldMemberResult);
			
			oldAccount.setAccountSq(oldMemberResult.getMemberMainAccount());
			oldAccount = auctionDao.obtainEntityByPk(oldAccount);
			oldAccount.setChange(oldAccount.getChange() + auctionProduct.getPriceNow());//과거 입찰자 돈 더해주기
			
			history.setAccount(oldAccount);
			history.setChange(oldAccount.getChange());//LINE :: 현재 보유중인 잔액
			history.setModifyChange(auctionProductResult.getPriceNow() - auctionProduct.getModifyPrice());//LINE :: 입금금액
			history.setReceiverAccountNumber(0L);//LINE :: 받는 계좌 번호
			history.setReceiverBankCode(0L);//LINE :: 보내는 계좌 번호
			history.setTask("출금");
			
			history = auctionDao.addEntity(history);
			
			auctionDao.flush();
			auctionDao.commitTransaction();

			return auctionProductResult;
		}
	
	}

	@Override
	public AuctionProduct addAuctionMaxPriceTransaction(AuctionTransaction auctionTransaction, AuctionProduct auctionProduct, 
			Account account, Member member, History history) {
		
		AuctionTransaction auctionTransactionResult = new AuctionTransaction();
		AuctionProduct auctionProductResult = new AuctionProduct();
		Account buyerAccountResult = new Account();
		
		auctionDao.beginTransaction();
		
		buyerAccountResult = auctionDao.obtainEntityByPk(account); //LINE :: 계좌정보 조회 (구매자)
		auctionProductResult = auctionDao.obtainEntityByPk(auctionProduct); //LINE :: 상품정보 조회
		
		Long userChange = buyerAccountResult.getChange() - auctionProduct.getPriceMax() - auctionProduct.getMaxFee();
		//LINE :: 잔액에서 상품 가격과 수수료 제외
		
		buyerAccountResult.setChange(userChange);//LINE :: 사용자 계좌 정보 업데이트
		
		history.setAccount(buyerAccountResult);
		history.setChange(buyerAccountResult.getChange());//LINE :: 현재 보유중인 잔액
		history.setModifyChange(auctionProduct.getPriceMax()+auctionProduct.getMaxFee());//LINE :: 입금금액
		history.setReceiverAccountNumber(0L);//LINE :: 받는 계좌 번호
		history.setReceiverBankCode(0L);//LINE :: 보내는 계좌 번호
		history.setTask("출금");
		
		auctionTransaction.setAuctionProduct(auctionProductResult);
		auctionTransaction.setTransactionType(COLUMN.PRODUCT_TRANSACTION.SAFE_START);
		auctionTransaction.setPrice(auctionProduct.getPriceMax());
		
		auctionProductResult.setStatus(COLUMN.PRODUCT.PRODUCT_STATUS.SELLED);
		
		history =  auctionDao.addEntity(history);
		auctionTransactionResult = auctionDao.addEntity(auctionTransaction);
		
		
			
		auctionDao.flush();
		auctionDao.commitTransaction();
			
		return auctionProductResult;
	}

	@Override
	public ResultPojoList selectMemberAuctionList(Pagination pagination, Member member) {

		ResultPojoList selledProductList = new ResultPojoList();
		
		selledProductList.setList(auctionDao.selectMemberAuctionList(pagination, member));
		
		//pagination.setTotalCount(productdao.countMemberProductListByStatus(pagination, member, productTransaction));
		
		selledProductList.setPagination(pagination);
		
		return selledProductList;
	}

	@Override
	public ResultPojoList selectSellerMemberAuctionList(Pagination pagination, Member member) {

		ResultPojoList selledProductList = new ResultPojoList();
		
		selledProductList.setList(auctionDao.selectSellerMemberAuctionList(pagination, member));
		
		//pagination.setTotalCount(productdao.countMemberProductListByStatus(pagination, member, productTransaction));
		
		selledProductList.setPagination(pagination);
		
		return selledProductList;
	}

	@Override
	public ResultPojoList selectSelledAuctionList(Pagination pagination, Member member) {

		ResultPojoList selledProductList = new ResultPojoList();
		
		selledProductList.setList(auctionDao.selectSelledAuctionList(pagination, member));
		
		//pagination.setTotalCount(productdao.countMemberProductListByStatus(pagination, member, productTransaction));
		
		selledProductList.setPagination(pagination);
		
		return selledProductList;
	}

	@Override
	public ResultPojoList selectBuyedAuctionList(Pagination pagination, Member member) {

		ResultPojoList selledProductList = new ResultPojoList();
		
		selledProductList.setList(auctionDao.selectBuyedAuctionList(pagination, member));
		
		//pagination.setTotalCount(productdao.countMemberProductListByStatus(pagination, member, productTransaction));
		
		selledProductList.setPagination(pagination);
		
		return selledProductList;
	}

	@Override
	public ResultPojoList selectAuctionRecommendList(Member member) {

		ResultPojoList auctionResult = new ResultPojoList();
		
		ResultPojoList memberInfoResult = new ResultPojoList();
		
		memberInfoResult.setList(auctionDao.obtainMaxAuctionCategoryFromMemberInfo(member));
		
		auctionResult.setList(auctionDao.selectAuctionRecommendList(member, (MemberInfo)memberInfoResult.getList().get(0))); 
		
		return auctionResult;
	}

	@Override
	public ResultPojoList selectMemberAuctionBidList(Pagination pagination, Member member) {
		
		ResultPojoList biddedProductList = new ResultPojoList();
		
		biddedProductList.setList(auctionDao.selectMemberAuctionBidList(pagination, member));
		
		//pagination.setTotalCount(productdao.countMemberProductListByStatus(pagination, member, productTransaction));
		
		biddedProductList.setPagination(pagination);
		
		return biddedProductList;
	}

	@Override
	public AuctionProduct addAuctionSuccessBidTransaction() {
		
		AuctionTransaction auctionTransactionResult = new AuctionTransaction();
		AuctionProduct auctionProductResult = new AuctionProduct();
		Account buyerAccountResult = new Account();
		List<AuctionProduct> auctionProductResultList = new ArrayList<AuctionProduct>();
		auctionDao.beginTransaction();
		
		auctionProductResultList = auctionDao.obtainSuccessBidAuction(); //LINE :: 상품정보 조회
		
		for(int i=0;i<auctionProductResultList.size();i++) {
			
			History history = new History();
			AuctionTransaction auctionTransaction = new AuctionTransaction();
			
			auctionTransaction.setAuctionProduct(auctionProductResult);
			auctionTransaction.setTransactionType(COLUMN.PRODUCT_TRANSACTION.SAFE_START);
			auctionTransaction.setPrice(auctionProductResultList.get(i).getPriceNow());
			
			auctionProductResult.setStatus(COLUMN.PRODUCT.PRODUCT_STATUS.SELLED);
			
			history =  auctionDao.addEntity(history);
			auctionTransactionResult = auctionDao.addEntity(auctionTransaction);
		}

		auctionDao.flush();
		auctionDao.commitTransaction();
			
		return auctionProductResult;
	}



	

	


}
