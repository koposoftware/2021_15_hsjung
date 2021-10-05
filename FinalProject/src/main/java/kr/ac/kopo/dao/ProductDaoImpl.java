package kr.ac.kopo.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.javamodeling.common.Pagination;
import com.javamodeling.dao.JPADaoSupport;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductTransaction;
import kr.ac.kopo.pojo.ProductTransactionReview;

@Repository
public class ProductDaoImpl extends JPADaoSupport implements ProductDao {

	@Override
	public List<Product> searchProductList(Pagination pagination) {

		String sql = "SELECT a FROM Product as a JOIN FETCH a.productImgs as b WHERE a.status = :defaultStatus ORDER BY a.inputDate DESC";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());
		return query.getResultList();
	}

	@Override
	public Long countProductList(Pagination pagination) {

		String sql = "SELECT COUNT(a) FROM Product as a WHERE a.status = :defaultStatus";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);

		return query.getSingleResult();

	}

	@Override
	public List<Product> productListByCategory(Pagination pagination, ProductCategory productCategory) {

		String sql = "SELECT a FROM Product as a JOIN FETCH a.productImgs as b "
				+ "WHERE a.status = :defaultStatus AND a.productCategory = :productCategory ORDER BY a.inputDate DESC";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("productCategory", productCategory);
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());

		return query.getResultList();
	}

	@Override
	public Long countProductListByCategory(Pagination pagination, ProductCategory productCategory) {

		String sql = "SELECT COUNT(a) FROM Product as a "
				+ "WHERE a.productCategory = :productCategory AND a.status = :defaultStatus";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);

		query.setParameter("productCategory", productCategory);
		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);

		return query.getSingleResult();
	}

	@Override
	public Product obtainProductByPk(Product product) {

		String sql = "SELECT a FROM Product as a JOIN FETCH a.productImgs as b WHERE a.productSq = :productSq";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("productSq", product.getProductSq());

		return query.getSingleResult();
	}

	@Override
	public MemberInfo obtainMemberInfByPk(Member member) {

		String sql = "SELECT a FROM MemberInf as a WHERE a.member = :member";

		TypedQuery<MemberInfo> query = entityManager.createQuery(sql, MemberInfo.class);

		query.setParameter("member", member);

		return query.getSingleResult();
	}

	@Override
	public List<ProductTransaction> selectMemberProductListByStatus(Pagination pagination, Member member,
			ProductTransaction productTransaction) {

		String sql = "SELECT a FROM ProductTransaction as a JOIN FETCH a.product as b "
				+ "WHERE a.buyerMemberSq = :memberSq AND a.transactionType != :type  ORDER BY a.transactionDate DESC";

		TypedQuery<ProductTransaction> query = entityManager.createQuery(sql, ProductTransaction.class);

		query.setParameter("memberSq", member.getMemberSq());
		query.setParameter("type", productTransaction.getTransactionType());

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());

		return query.getResultList();
	}

	@Override
	public List<Product> selectSellerMemberProductListByStatus(Pagination pagination, Member member) {

		String sql = "SELECT a FROM Product as a JOIN FETCH a.member as b "
				+ "WHERE a.status = :status AND b.memberSq = :memberSq  ORDER BY a.inputDate DESC";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("status", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		query.setParameter("memberSq", member.getMemberSq());

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());

		return query.getResultList();
	}

	@Override
	public List<ProductTransaction> selectSelledProductList(Pagination pagination, Member member) {

		String sql = "SELECT a FROM ProductTransaction as a JOIN FETCH a.product as b "
				+ "WHERE a.sellerMemberSq = :memberSq AND a.transactionType = :type  ORDER BY a.transactionDate DESC";

		TypedQuery<ProductTransaction> query = entityManager.createQuery(sql, ProductTransaction.class);

		query.setParameter("memberSq", member.getMemberSq());
		query.setParameter("type", COLUMN.PRODUCT_TRANSACTION.SAFE_END);

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());

		return query.getResultList();
	}

	@Override
	public List<ProductTransaction> selectBuyedProductList(Pagination pagination, Member member) {

		String sql = "SELECT a FROM ProductTransaction as a JOIN FETCH a.product as b "
				+ "WHERE a.buyerMemberSq = :memberSq AND a.transactionType = :status  ORDER BY a.transactionDate DESC";

		TypedQuery<ProductTransaction> query = entityManager.createQuery(sql, ProductTransaction.class);

		query.setParameter("memberSq", member.getMemberSq());
		query.setParameter("status", COLUMN.PRODUCT_TRANSACTION.SAFE_END);

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());

		return query.getResultList();
	}

	@Override
	public Product obtainProductWithTransactionByProduct(Product productResult, Member member) {

		String sql = "SELECT a FROM Product as a JOIN FETCH a.productTransactions as b "
				+ "WHERE a.productSq = :productSq And b.buyerMemberSq = :buyerMemberSq";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("productSq", productResult.getProductSq());
		query.setParameter("buyerMemberSq", member.getMemberSq());

		return query.getSingleResult();
	}

	@Override
	public List<ProductTransaction> selectSellingProductListByStatus(Pagination pagination, Member member) {

		String sql = "SELECT a FROM ProductTransaction as a JOIN FETCH a.product as b "
				+ "WHERE a.sellerMemberSq = :memberSq AND a.transactionType != :status  ORDER BY a.transactionDate DESC";

		TypedQuery<ProductTransaction> query = entityManager.createQuery(sql, ProductTransaction.class);

		query.setParameter("memberSq", member.getMemberSq());
		query.setParameter("status", COLUMN.PRODUCT_TRANSACTION.SAFE_END);

		query.setFirstResult(pagination.getFirstNo());
		query.setMaxResults(pagination.getViewCount());

		return query.getResultList();
	}

	@Override
	public Product obtainProductTransactionWithProductForSeller(Product product, Member member) {

		String sql = "SELECT a FROM Product as a JOIN FETCH a.productTransactions as b WHERE a.productSq = :productSq AND b.sellerMemberSq = :sellerSq ";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("productSq", product.getProductSq());
		query.setParameter("sellerSq", member.getMemberSq());

		return query.getSingleResult();
	}

	@Override
	public List<MemberInfo> obtainMaxCategoryFromMemberInfo(Member member) {
		
		String sql = "SELECT a FROM MemberInfo as a  WHERE a.member.memberSq = :memberSq AND a.productCategory.productCategorySq <= 10 ORDER BY a.countCategory DESC ";

		TypedQuery<MemberInfo> query = entityManager.createQuery(sql, MemberInfo.class);

		query.setParameter("memberSq", member.getMemberSq());

		return query.getResultList();
	}

	@Override
	public List<Product> selectProductRecommendList(Member member, MemberInfo memberInfo) {
	
		String sql = "SELECT DISTINCT a FROM Product as a JOIN FETCH a.productImgs as b WHERE a.status = :defaultStatus "
				+ "AND a.productCategory.productCategorySq = :memberInfoCategory ORDER BY a.viewCnt DESC";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		query.setParameter("memberInfoCategory", memberInfo.getProductCategory().getProductCategorySq());

		/*
		 * query.setFirstResult(0); query.setMaxResults(4);
		 */
		 query.setFirstResult(0); 
		 query.setMaxResults(6);
		 
		return query.getResultList();
	}

	@Override
	public List<Product> selectTodayRecommendList() {
		
		String sql = "SELECT a FROM Product as a JOIN FETCH a.productImgs as b WHERE a.status = :defaultStatus ORDER BY a.viewCnt DESC";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("defaultStatus", COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);

		query.setFirstResult(0);
		query.setMaxResults(4);
		
		return query.getResultList();
	}

	@Override
	public Long countProductBuy(Member member) {
		
		String sql = "SELECT COUNT(a) FROM ProductTransaction as a WHERE a.buyerMemberSq = :buyerMemberSq ";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("buyerMemberSq", member.getMemberSq());

		return query.getSingleResult();
	}

	@Override
	public Long countProductSell(Member member) {
		
		String sql = "SELECT COUNT(a) FROM ProductTransaction as a WHERE a.sellerMemberSq = :sellerMemberSq ";

		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		
		query.setParameter("sellerMemberSq", member.getMemberSq());

		return query.getSingleResult();
	}

	@Override
	public List<ProductTransactionReview> searchProductTransactionRevice(Product product) {
		
		String sql = "SELECT a FROM ProductTransactionRevicw as a JOIN FETCH a.product as b "
				+ "WHERE b.productSq = :productSq ORDER BY a.transactionDate DESC";

		TypedQuery<ProductTransactionReview> query = entityManager.createQuery(sql, ProductTransactionReview.class);

		query.setParameter("productSq", product.getProductSq());

		return query.getResultList();
	}

	@Override
	public List<ProductTransactionReview> obtainProductRippleByProduct(Product product) {
		
		String sql = "SELECT a FROM ProductTransactionReview as a JOIN FETCH a.member as b "
				+ "WHERE b.productSq = :productSq ORDER BY a.inputDate DESC";

		TypedQuery<ProductTransactionReview> query = entityManager.createQuery(sql, ProductTransactionReview.class);

		query.setParameter("productSq", product.getProductSq());

		return query.getResultList();
	}




	


}
