package kr.ac.kopo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;

import com.javamodeling.component.DaoInterface;
import com.javamodeling.dao.JPADaoSupport;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.Cart;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.PostIt;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransactionReview;

@Repository
public class MemberDaoImpl extends JPADaoSupport implements MemberDao {

	@Override
	public Member login(Member member) {

		Member memberResult = new Member();
		try {
			String strSQL ="SELECT a FROM Member as a WHERE a.id = :id AND a.pwd = :pwd";

			memberResult = entityManager.createQuery(strSQL, Member.class)			
			.setParameter("id", member.getId())
			.setParameter("pwd", member.getPwd())
			.getSingleResult();
			
			memberResult.setResultCode(1L);
		} catch (Exception e) {
			e.printStackTrace();
			memberResult.setResultCode(0L);
		} 
			return memberResult;
	}

	@Override
	public MemberInfo obtainMemberInfoByMember(Member member, ProductCategory productCategory) {
		
		String sql ="SELECT a FROM MemberInfo as a WHERE a.member.memberSq = :member AND a.productCategory.productCategorySq = :productCategory";

		TypedQuery<MemberInfo> query = entityManager.createQuery(sql, MemberInfo.class);
		
		query.setParameter("member", member.getMemberSq());
		query.setParameter("productCategory", productCategory.getProductCategorySq());
		
		return query.getSingleResult();
	}

	@Override
	public Member addMemberAccount(Member member, Account account) {

        StoredProcedureQuery spq =  entityManager.createNamedStoredProcedureQuery("ADD_MEMBER_BASIC_SETTING");
        spq.setParameter("MEMBER_PK", member.getMemberSq());
        spq.setParameter("MEMBER_MAIN_ACC", account.getAccountSq());
        spq.execute();

        return member;
	}

	@Override
	public List<PostIt> searchPostItForMember(Member member) {
		
		String sql = "SELECT a FROM PostIt as a JOIN FETCH a.product as b WHERE a.receiverMemberPk = :sellerMemberPk AND a.isRead != :readStatus  ORDER BY a.inputDate DESC";

		TypedQuery<PostIt> query = entityManager.createQuery(sql, PostIt.class);

		query.setParameter("sellerMemberPk", member.getMemberSq());
		query.setParameter("readStatus", COLUMN.POST_IT_STATUS.REPLY);

		return query.getResultList();
	}

	@Override
	public Long countNewPost(Member member) {
		
		String sql = "SELECT COUNT(a) FROM PostIt as a WHERE a.receiverMemberPk = :sellerMemberPk AND a.isRead != :readStatus  ORDER BY a.inputDate DESC";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("sellerMemberPk", member.getMemberSq());
		query.setParameter("readStatus", COLUMN.POST_IT_STATUS.READ);

		return query.getSingleResult();
	}

	@Override
	public Long countBuy(Member member) {
		
		String sql = "SELECT COUNT(a) FROM PostIt as a WHERE a.receiverMemberPk = :sellerMemberPk AND a.isRead != :readStatus  ORDER BY a.inputDate DESC";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("sellerMemberPk", member.getMemberSq());
		query.setParameter("readStatus", COLUMN.POST_IT_STATUS.READ);

		return query.getSingleResult();
	}

	@Override
	public Long countSell(Member member) {
		
		String sql = "SELECT COUNT(a) FROM PostIt as a WHERE a.receiverMemberPk = :sellerMemberPk AND a.isRead != :readStatus  ORDER BY a.inputDate DESC";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("sellerMemberPk", member.getMemberSq());
		query.setParameter("readStatus", COLUMN.POST_IT_STATUS.READ);

		return query.getSingleResult();
	}

	@Override
	public List<ProductTransactionReview> searchProductRipple(Member member) {
		
		String sql ="SELECT a FROM ProductTransactionRevice JOIN FETCH a.member as b WHERE a.member.memberSq = :member ";

		TypedQuery<ProductTransactionReview> query = entityManager.createQuery(sql, ProductTransactionReview.class);
		
		query.setParameter("member", member.getMemberSq());
		
		return query.getResultList();
	}

	@Override
	public List<Cart> searchCartList(Member member) {
		
		String sql ="SELECT a FROM Cart JOIN FETCH a.member as b WHERE a.member.memberSq = :member ";

		TypedQuery<Cart> query = entityManager.createQuery(sql, Cart.class);
		
		query.setParameter("member", member.getMemberSq());
		
		return query.getResultList();
	}

}
