package kr.ac.kopo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamodeling.common.ResultPojoList;
import com.javamodeling.util.DateUtils;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.dao.AuctionDao;
import kr.ac.kopo.dao.MemberDao;
import kr.ac.kopo.dao.ProductDao;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.AuctionProductImg;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.PostIt;
import kr.ac.kopo.pojo.Product;

@Service
public class MemberServiceImpl extends ServiceSupport implements MemberService {

	@Autowired
	private MemberDao memberdao;
	
	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private AuctionDao auctiondao;
	
	@Override
	@Transactional
	public Member obtainMemberByPk(Member member) {
		
		Member memberResult = new Member();
		memberResult = memberdao.obtainEntityByPk(member);
		
		return memberResult;
	}

	@Override
	public Member login(Member member) {
		
		Member memberLogin = new Member();
		
		memberLogin = memberdao.login(member);
		
		return memberLogin;
	}

	@Override
	public Member addMemberAccount(Member member, Account account) {

		Member memberResult = new Member();
		
		try {
			memberdao.beginTransaction();
			
			memberResult = memberdao.addMemberAccount(member,account);
			
		}catch (Exception e){
			e.printStackTrace();
			memberdao.rollbackTransaction();
			memberResult.setResultCodeMinus();
		} finally {
			memberdao.commitTransaction();
		}

		return memberResult;
		
	}

	@Override
	public PostIt sendPostIt(PostIt postIt, Product product) {
		
		PostIt postItResult = new PostIt();
		
		try {
			
			memberdao.beginTransaction();
			
			product = memberdao.obtainEntityByPk(product);
			postIt.setProduct(product);
			
			memberdao.addEntity(postIt);
			
		}catch (Exception e){
			e.printStackTrace();
			memberdao.rollbackTransaction();
			postItResult.setResultCodeMinus();
		} finally {
			memberdao.commitTransaction();
		}
		
		return postItResult;
	}

	@Override
	public ResultPojoList searchPostItForMember(Member member) {
	
		ResultPojoList postItList = new ResultPojoList();
		
		postItList.setList(memberdao.searchPostItForMember(member));
		
		return postItList;
	}

	@Override
	public PostIt sendPostIt(PostIt postIt) {

		PostIt postItResult = new PostIt();
		PostIt postItAdd = new PostIt();
		
		String msg="";
		
		try {
			
			memberdao.beginTransaction();
			postItResult = memberdao.obtainEntityByPk(postIt);
			msg = postItResult.getProduct().getProductName() + "상품의 판매자가 채팅방에 초대하였습니다";
			
			postItAdd.setProduct(postItResult.getProduct());
			postItAdd.setReceiverMemberPk(postItResult.getSenderMemberPk());
			postItAdd.setSenderMemberPk(postItResult.getReceiverMemberPk());
			postItAdd.setIsRead(COLUMN.POST_IT_STATUS.REPLY);
			postItAdd.setInputDate(DateUtils.getCurrentTime());
			postItAdd.setPostItContents(msg);
			
			memberdao.addEntity(postItAdd);
			
		}catch (Exception e){
			e.printStackTrace();
			memberdao.rollbackTransaction();
			postItAdd.setResultCodeMinus();
		} finally {
			memberdao.commitTransaction();
		}
		
		return postItAdd;
	}

	@Override
	public Long countPost(Member member) {
		
		Long countPost = memberdao.countNewPost(member);

		return countPost;
	}

	@Override
	public PostIt findRoomPkSwitch(PostIt postIt) {
		
		PostIt postItResult = new PostIt();

		try {
			
			memberdao.beginTransaction();
			postIt = memberdao.obtainEntityByPk(postIt);

			postItResult.setPostItPk(postIt.getPostItPk());
			
		}catch (Exception e){
			e.printStackTrace();
			memberdao.rollbackTransaction();
			postItResult.setResultCodeMinus();
		} finally {
			memberdao.commitTransaction();
		}
		
		return postItResult;
		
	}

	@Override
	public Long countBuy(Member member) {
		
		Long countBuy1 = productdao.countProductBuy(member);
		Long countBuy2 = auctiondao.countAuctionBuy(member);
		
		return countBuy1+countBuy2;
	}

	@Override
	public Long countSell(Member member) {
		
		Long countSell1 = productdao.countProductSell(member);
		Long countSell2 = auctiondao.countAuctionSell(member);
		
		return countSell1+countSell2;
	}

	@Override
	public void modifyPostItStatus(String roomNo) {

		PostIt postit = new PostIt();
		postit.setPostItPk(Long.parseLong(roomNo));
		
		memberdao.beginTransaction();
		
		
		
		productdao.flush();
		productdao.commitTransaction();
	}

	@Override
	public ResultPojoList searchProductRipple(Member member) {

		ResultPojoList memberRippleList = new ResultPojoList();
		
		memberRippleList.setList(memberdao.searchProductRipple(member));
		
		return memberRippleList;
	}

	@Override
	public ResultPojoList searchCartList(Member member) {

		ResultPojoList memberRippleList = new ResultPojoList();
		
		memberRippleList.setList(memberdao.searchCartList(member));
		
		return memberRippleList;
	}




}
