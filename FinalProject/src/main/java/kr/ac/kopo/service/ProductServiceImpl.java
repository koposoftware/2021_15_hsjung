package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamodeling.common.Pagination;
import com.javamodeling.common.ResultPojoList;
import com.javamodeling.util.DateUtils;
import com.javamodeling.util.StringUtils;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.dao.AccountDao;
import kr.ac.kopo.dao.MemberDao;
import kr.ac.kopo.dao.ProductDao;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransaction;

@Service
public class ProductServiceImpl extends ServiceSupport implements ProductService {

	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private AccountDao accountdao;
	
	@Autowired
	private MemberDao memberdao;
	
	@Override
	public ResultPojoList searchProductList(Pagination pagination) {

		ResultPojoList productList = new ResultPojoList();
		
		productList.setList(productdao.searchProductList(pagination));
		
		pagination.setTotalCount(productdao.countProductList(pagination));
		
		productList.setPagination(pagination);
		
		return productList;
	}

	@Override
	public ResultPojoList selectMemberProductListByStatus(Pagination pagination, Member member, ProductTransaction productTransaction) {
	
		ResultPojoList productList = new ResultPojoList();
		
		productList.setList(productdao.selectMemberProductListByStatus(pagination, member, productTransaction));
		
		productList.setPagination(pagination);
		
		return productList;
	}


	@Override
	public ResultPojoList selectSellerMemberProductListByStatus(Pagination pagination, Member member) {

		ResultPojoList productList = new ResultPojoList();
		
		productList.setList(productdao.selectSellerMemberProductListByStatus(pagination, member));
		
		productList.setPagination(pagination);
		
		return productList;
	}

	@Override
	public ResultPojoList selectSelledProductList(Pagination pagination, Member member, ProductTransaction productTransaction) {
		
		ResultPojoList selledProductList = new ResultPojoList();
		
		selledProductList.setList(productdao.selectSelledProductList(pagination, member));
		
		selledProductList.setPagination(pagination);
		
		return selledProductList;
	}

	@Override
	public ResultPojoList selectBuyedProductList(Pagination pagination, Member member, ProductTransaction productTransaction) {
		
		ResultPojoList buyedProductList = new ResultPojoList();
		
		buyedProductList.setList(productdao.selectBuyedProductList(pagination, member));
		
		buyedProductList.setPagination(pagination);
		
		return buyedProductList;
	}
	
	@Override
	public ResultPojoList selectSellingProductListByStatus(Pagination pagination, Member member, ProductTransaction productTransaction) {

		ResultPojoList sellingProductList = new ResultPojoList();
		
		sellingProductList.setList(productdao.selectSellingProductListByStatus(pagination, member));
		
		sellingProductList.setPagination(pagination);
		
		return sellingProductList;
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public Product addProduct(List<HanaFile> hanaFileResultList, Product product) {
		
		Product productResult = new Product();
		HanaFile hanaFileResult = new HanaFile();
		ProductImg productImg = null;
		
		try {
			productdao.beginTransaction();
			productResult = productdao.addEntity(product);
			
			for(int i=0;i<hanaFileResultList.size();i++) {
				
				productImg = new ProductImg();
				
				productImg.setProduct(productResult);
				
				hanaFileResult = productdao.addEntity(hanaFileResultList.get(i));
				
				productImg.setFileSq(hanaFileResult.getFileSq());
				
				productImg = productdao.addEntity(productImg);
				productResult.setResultCodePlus();
			
			}
		}catch (Exception e){
			e.printStackTrace();
			productdao.rollbackTransaction();
			productResult.setResultCodeMinus();
		} finally {
			productdao.commitTransaction();
		}
		return productResult;
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public ResultPojoList productListByCategory(Pagination pagination,ProductCategory productCategory, Member member) {

		ResultPojoList productList = new ResultPojoList();
		MemberInfo memberInfResult = new MemberInfo();
		
		//memberdao.beginTransaction();
		
		memberInfResult = memberdao.obtainMemberInfoByMember(member,productCategory);
		memberInfResult.setCountCategory(memberInfResult.getCountCategory() + 1L);//LINE :: ?????? ?????????
		
		productCategory = productdao.obtainEntityByPk(productCategory);
		productList.setList(productdao.productListByCategory(pagination,productCategory));
		
		pagination.setTotalCount(productdao.countProductListByCategory(pagination,productCategory));
		productList.setPagination(pagination);
		
		//memberdao.flush();
		//memberdao.commitTransaction();
		
		return productList;
	}

	@Override
	@Transactional
	public Product obtainProductByPk(Product product) {

		Product productResult = new Product();
		
		productdao.beginTransaction();
		
		productResult = productdao.obtainProductByPk(product);
		
		productResult.setViewCnt(productResult.getViewCnt() + 1L);
		
		productdao.flush();
		productdao.commitTransaction();
		
		return productResult;
		
	}

	@Override
	public Product addProductTransaction(ProductTransaction productTransaction, Product product, Account account, Member member, History history) {
		
		ProductTransaction productTransactionResult = new ProductTransaction();
		Product productResult = new Product();
		Account buyerAccountResult = new Account();
		
		productdao.beginTransaction();
		
		buyerAccountResult = productdao.obtainEntityByPk(account); //LINE :: ???????????? ?????? (?????????)
		productResult = productdao.obtainEntityByPk(product); //LINE :: ???????????? ??????
		
		Long userChange = buyerAccountResult.getChange() - product.getPrice() - product.getFee();
		//LINE :: ???????????? ?????? ????????? ????????? ??????
		
		buyerAccountResult.setChange(userChange);//LINE :: ????????? ?????? ?????? ????????????
		
		history.setAccount(buyerAccountResult);
		history.setChange(buyerAccountResult.getChange());//LINE :: ?????? ???????????? ??????
		history.setModifyChange(product.getPrice()+product.getFee());//LINE :: ????????????
		history.setReceiverAccountNumber(0L);//LINE :: ?????? ?????? ??????
		history.setReceiverBankCode(0L);//LINE :: ????????? ?????? ??????
		history.setTask("??????");
		
		productTransaction.setProduct(productResult);
		productTransaction.setTransactionType(COLUMN.PRODUCT_TRANSACTION.SAFE_START);
		productTransaction.setTransactionPrice(product.getPrice());
		
		productResult.setStatus(COLUMN.PRODUCT.PRODUCT_STATUS.SELLED);
		
		history =  productdao.addEntity(history);
		productTransactionResult = productdao.addEntity(productTransaction);
		
			
		productdao.flush();
		productdao.commitTransaction();
			
		return productResult;
	}

	@Override
	public Product obtainProductWithTransactionByProduct(Product productResult, Member member) {

		Product productTransactionResult = new Product();
		
		productTransactionResult = productdao.obtainProductWithTransactionByProduct(productResult, member);
		
		return productTransactionResult;
	}

	@Override
	public ProductTransaction addUnsongJang(ProductTransaction productTransaction) {

		ProductTransaction productTransactionResult = new ProductTransaction();

		productdao.beginTransaction();
		
		productTransactionResult = productdao.obtainEntityByPk(productTransaction);
		
		productTransactionResult.setUnsongjang(productTransaction.getUnsongjang());
		productTransactionResult.setTransactionType(COLUMN.PRODUCT_TRANSACTION.GET_DELIVERY);
		
		productdao.flush();
		productdao.commitTransaction();
		
		return productTransactionResult;
	}

	@Override
	public Product obtainProductTransactionWithProductForSeller(Product product, Member member) {
		
		Product productResult = new Product();
		
		productResult = productdao.obtainProductTransactionWithProductForSeller(product,member);
		
		return productResult;
	}

	@Override
	public ProductTransaction securePaymentClose(ProductTransaction productTransaction, History history) {

		ProductTransaction productTransactionResult = new ProductTransaction();
		Product productResult = new Product();
		Member buyer = new Member();
		Account account = new Account();
		Account senderAccount = new Account();
		
		productdao.beginTransaction();
		
		productTransaction = productdao.obtainEntityByPk(productTransaction);//LINE :: ?????? ?????? ??????
		
		productResult.setProductSq(productTransaction.getProduct().getProductSq());
		
		productResult = productdao.obtainEntityByPk(productResult);
		
		productTransaction.setTransactionType(COLUMN.PRODUCT_TRANSACTION.SAFE_END);
		productTransaction.setTransactionPrice(productTransaction.getTransactionPrice() - productResult.getPrice());//?????? ???????????? ??????
		
		buyer.setMemberSq(productTransaction.getBuyerMemberSq());
		buyer = productdao.obtainEntityByPk(buyer);
		
		senderAccount.setAccountSq(productTransaction.getBuyerMemberSq());
		senderAccount = productdao.obtainEntityByPk(senderAccount);
		
		account.setAccountSq(buyer.getMemberMainAccount());
		account = productdao.obtainEntityByPk(account);
		account.setChange(account.getChange() + productResult.getPrice());
		
		history.setAccount(account);
		history.setChange(account.getChange());
		history.setModifyChange(productResult.getPrice());
		history.setReceiverAccountNumber(senderAccount.getAccountSq());
		
		productdao.addEntity(history);
		
		productdao.flush();
		productdao.commitTransaction();
		
		return productTransactionResult;
		
	}

	@Override
	public ResultPojoList selectProductRecommendList(Member member) {

		ResultPojoList productResult = new ResultPojoList();
		
		ResultPojoList memberInfoResult = new ResultPojoList();
		
		memberInfoResult.setList(productdao.obtainMaxCategoryFromMemberInfo(member));
		
		productResult.setList(productdao.selectProductRecommendList(member, (MemberInfo)memberInfoResult.getList().get(0))); 
		
		return productResult;
	}

	@Override
	public ResultPojoList selectTodayRecommendList(Member memberChk) {

		ResultPojoList productResult = new ResultPojoList();
		
		ResultPojoList memberInfoResult = new ResultPojoList();
		
		productResult.setList(productdao.selectTodayRecommendList()); 
		
		return productResult;
	}

	@Override
	public ResultPojoList searchProductTransactionRevice(Product product) {

		ResultPojoList productReviewResult = new ResultPojoList();
		
		productReviewResult.setList(productdao.searchProductTransactionRevice(product));
		
		return productReviewResult;
	}

	@Override
	public ResultPojoList obtainProductRippleByProduct(Product product) {

		ResultPojoList productRippleList = new ResultPojoList();
		
		productRippleList.setList(productdao.obtainProductRippleByProduct(product));
		
		return productRippleList;
	}







}
