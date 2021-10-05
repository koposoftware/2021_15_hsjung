package kr.ac.kopo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;

import com.javamodeling.common.Pagination;
import com.javamodeling.component.DaoInterface;

import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransaction;
import kr.ac.kopo.pojo.ProductTransactionReview;

public interface ProductDao extends DaoInterface {

	List<Product> searchProductList(Pagination pagination);

	Long countProductList(Pagination pagination);

	List<Product> productListByCategory(Pagination pagination,ProductCategory productCategory);

	Long countProductListByCategory(Pagination pagination,ProductCategory productCategory);

	Product obtainProductByPk(Product product);

	MemberInfo obtainMemberInfByPk(Member member);

	List<ProductTransaction> selectMemberProductListByStatus(Pagination pagination, Member member, ProductTransaction productTransaction);

	List<Product> selectSellerMemberProductListByStatus(Pagination pagination, Member member);

	List<ProductTransaction> selectSelledProductList(Pagination pagination, Member member);

	List<ProductTransaction> selectBuyedProductList(Pagination pagination, Member member);

	Product obtainProductWithTransactionByProduct(Product productResult,Member member);

	List<ProductTransaction> selectSellingProductListByStatus(Pagination pagination, Member member);

	Product obtainProductTransactionWithProductForSeller(Product product, Member member);

	List<MemberInfo> obtainMaxCategoryFromMemberInfo(Member member);

	List<Product> selectProductRecommendList(Member member, MemberInfo memberInfo);

	List<Product> selectTodayRecommendList();

	Long countProductBuy(Member member);

	Long countProductSell(Member member);

	List<ProductTransactionReview> searchProductTransactionRevice(Product product);

	List<ProductTransactionReview> obtainProductRippleByProduct(Product product);




	

}
