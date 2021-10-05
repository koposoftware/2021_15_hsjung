package kr.ac.kopo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.javamodeling.common.Pagination;
import com.javamodeling.dao.JPADaoSupport;
import com.javamodeling.util.DateUtils;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.AuctionProduct;
import kr.ac.kopo.pojo.AuctionTransaction;

@Repository
public class AuctionDaoImpl extends JPADaoSupport implements AuctionDao {

	@Override
	public List<AuctionProduct> searchAuctionList(Pagination pagination) {
		
		String sql="SELECT a FROM AuctionProduct as a JOIN FETCH a.auctionProductImgs as b WHERE a.status = :defaultStatus ORDER BY a.inputDate DESC";

		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);
		
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	@Override
	public Long countAuctionList(Pagination pagination) {

		String sql = "SELECT COUNT(a) FROM AuctionProduct as a WHERE a.status = :defaultStatus";
		
		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		
		return query.getSingleResult();
	}
	
	@Override
	public List<AuctionProduct> searchAuctionListByCategory(Pagination pagination, ProductCategory productCategory) {

		String sql="SELECT a FROM AuctionProduct as a JOIN FETCH a.auctionProductImgs as b  "
				+ " WHERE a.status = :defaultStatus "
				+ " AND a.productCategory = :productCategory" 
				/* + " AND convert(a.endDate, date) >= convert(:todayDate, date) " */
				+ " ORDER BY a.inputDate DESC";
		
		String date = DateUtils.getCurrentTime();
				
		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);
		
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		query.setParameter("productCategory", productCategory);
		/* query.setParameter("todayDate", date); */
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	@Override
	public Long countAuctionListByCategory(Pagination pagination, ProductCategory productCategory) {

		String sql = "SELECT COUNT(a) FROM AuctionProduct as a"
				+ " WHERE a.productCategory = :productCategory AND a.status = :defaultStatus";
		
		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("productCategory", productCategory);
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		
		return query.getSingleResult();
	}

	

	@Override
	public AuctionProduct obtainAuctionProductByPk(AuctionProduct auctionProduct) {
		
		String sql="SELECT a FROM AuctionProduct as a JOIN FETCH a.auctionProductImgs as b "
				+ "WHERE a.auctionProductSq = :auctionProduct";

		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);
		
		query.setParameter("auctionProduct", auctionProduct.getAuctionProductSq());
		
		
		return query.getSingleResult();
	}

	/**
	 * 구매 진행 중인 상품
	 */
	@Override
	public List<AuctionTransaction> selectMemberAuctionList(Pagination pagination, Member member) {
		
		String sql="SELECT a FROM AuctionTransaction as a JOIN FETCH a.auctionProduct as b "
				+ "WHERE a.transactionType = :transactionType AND a.buyerMemberSq = :memberSq  ORDER BY a.inputDate DESC";

		TypedQuery<AuctionTransaction> query = entityManager.createQuery(sql, AuctionTransaction.class);
		
		query.setParameter("transactionType", COLUMN.PRODUCT_TRANSACTION.SAFE_START);
		query.setParameter("memberSq", member.getMemberSq());
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	/**
	 * 판매 중인 상품
	 */
	@Override
	public List<AuctionProduct> selectSellerMemberAuctionList(Pagination pagination, Member member) {
		
		String sql="SELECT a FROM AuctionProduct as a JOIN FETCH a.member as b "
				+ "WHERE a.status = :status AND b.memberSq = :memberSq  ORDER BY a.inputDate DESC";

		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);
		
		query.setParameter("status", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		query.setParameter("memberSq", member.getMemberSq());
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	/**
	 * 판매 완료 상품 조회
	 */
	@Override
	public List<AuctionTransaction> selectSelledAuctionList(Pagination pagination, Member member) {
		
		String sql="SELECT a FROM AuctionTransaction as a JOIN FETCH a.auctionProduct as b "
				+ "WHERE a.transactionType = :transactionType AND a.sellerMemberSq = :memberSq  ORDER BY a.inputDate DESC";

		TypedQuery<AuctionTransaction> query = entityManager.createQuery(sql, AuctionTransaction.class);
		
		query.setParameter("transactionType", COLUMN.PRODUCT_TRANSACTION.SAFE_END);
		query.setParameter("memberSq", member.getMemberSq());
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	/**
	 * 구매한 중고 상품 조회
	 */
	@Override
	public List<AuctionTransaction> selectBuyedAuctionList(Pagination pagination, Member member) {
		String sql="SELECT a FROM AuctionTransaction as a JOIN FETCH a.auctionProduct as b "
				+ "WHERE a.transactionType = :transactionType AND a.buyerMemberSq = :memberSq  ORDER BY a.inputDate DESC";

		TypedQuery<AuctionTransaction> query = entityManager.createQuery(sql, AuctionTransaction.class);
		
		query.setParameter("transactionType", COLUMN.PRODUCT_TRANSACTION.SAFE_END);
		query.setParameter("memberSq", member.getMemberSq());
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	@Override
	public List<MemberInfo> obtainMaxAuctionCategoryFromMemberInfo(Member member) {
		
		String sql = "SELECT a FROM MemberInfo as a  WHERE a.member.memberSq = :memberSq AND a.productCategory.productCategorySq >= 10 ORDER BY a.countCategory DESC ";

		TypedQuery<MemberInfo> query = entityManager.createQuery(sql, MemberInfo.class);

		query.setParameter("memberSq", member.getMemberSq());

		return query.getResultList();

	}

	@Override
	public List<AuctionProduct> selectAuctionRecommendList(Member member, MemberInfo memberInfo) {
		
		String sql = "SELECT DISTINCT a FROM AuctionProduct as a JOIN FETCH a.auctionProductImgs as b WHERE a.status = :defaultStatus "
				+ "AND a.productCategory.productCategorySq = :memberInfoCategory ORDER BY a.viewCnt DESC";

		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);

		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		query.setParameter("memberInfoCategory", memberInfo.getProductCategory().getProductCategorySq());

		/*
		 * query.setFirstResult(0); query.setMaxResults(4);
		 */
		 query.setFirstResult(0); 
		 query.setMaxResults(8);
		 
		return query.getResultList();
	}

	@Override
	public Long countAuctionBuy(Member member) {
		
		String sql = "SELECT COUNT(a) FROM AuctionTransaction as a WHERE a.buyerMemberSq = :buyerMemberSq";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("buyerMemberSq", member.getMemberSq());

		return query.getSingleResult();
	}

	@Override
	public Long countAuctionSell(Member member) {
		
		String sql = "SELECT COUNT(a) FROM AuctionTransaction as a WHERE a.sellerMemberSq = :sellerMemberSq";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("sellerMemberSq", member.getMemberSq());

		return query.getSingleResult();
	}

	@Override
	public List<AuctionProduct> selectMemberAuctionBidList(Pagination pagination, Member member) {
		
		String sql="SELECT a FROM AuctionProduct as a WHERE a.status = :defaultStatus AND a.ibchalja = :ibchalja ORDER BY a.inputDate DESC";

		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);
		
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		query.setParameter("ibchalja",member.getMemberSq());
		
		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		
		return query.getResultList();
	}

	@Override
	public List<AuctionProduct> obtainSuccessBidAuction() {
		
		String sql="SELECT a FROM AuctionProduct as a WHERE a.status = :defaultStatus AND a.endDate = :todayDate ";

		TypedQuery<AuctionProduct> query = entityManager.createQuery(sql, AuctionProduct.class);
		
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLED);
		query.setParameter("ibchalja",DateUtils.getCurrentTime());
		
		return query.getResultList();
	}
	
}
