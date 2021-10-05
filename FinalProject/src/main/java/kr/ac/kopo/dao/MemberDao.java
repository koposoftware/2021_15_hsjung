package kr.ac.kopo.dao;

import java.util.List;

import com.javamodeling.common.Pagination;
import com.javamodeling.component.DaoInterface;

import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.Cart;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.PostIt;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransactionReview;

public interface MemberDao extends DaoInterface {

	Member login(Member member);

	MemberInfo obtainMemberInfoByMember(Member member, ProductCategory productCategory);

	Member addMemberAccount(Member member, Account account);

	List <PostIt> searchPostItForMember(Member member);

	Long countNewPost(Member member);

	Long countBuy(Member member);

	Long countSell(Member member);

	List<ProductTransactionReview> searchProductRipple(Member member);

	List<Cart> searchCartList(Member member);

}
