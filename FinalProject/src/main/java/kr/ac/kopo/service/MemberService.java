package kr.ac.kopo.service;

import com.javamodeling.common.ResultPojoList;

import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.PostIt;
import kr.ac.kopo.pojo.Product;

public interface MemberService {
	
	public Member obtainMemberByPk(Member member);

	public Member login(Member member);

	public Member addMemberAccount(Member member, Account account);

	public PostIt sendPostIt(PostIt postIt, Product product);

	public ResultPojoList searchPostItForMember(Member member);

	public PostIt sendPostIt(PostIt postIt);

	public Long countPost(Member member);

	public PostIt findRoomPkSwitch(PostIt postIt);

	public Long countBuy(Member member);

	public Long countSell(Member member);

	public void modifyPostItStatus(String roomNo);

	public ResultPojoList searchProductRipple(Member member);

	public ResultPojoList searchCartList(Member member);


}
