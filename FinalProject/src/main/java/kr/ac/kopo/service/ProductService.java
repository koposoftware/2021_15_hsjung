package kr.ac.kopo.service;

import java.util.List;

import com.javamodeling.common.Pagination;
import com.javamodeling.common.ResultPojoList;

import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransaction;

public interface ProductService {
	
	ResultPojoList searchProductList(Pagination pagination);

	Product addProduct(List<HanaFile> hanaFileResultList,  Product product);

	ResultPojoList productListByCategory(Pagination pagination,ProductCategory productCategory,Member member);

	Product obtainProductByPk(Product product);

	Product addProductTransaction(ProductTransaction productTransaction, Product product, Account account,Member member, History history);

	ResultPojoList selectMemberProductListByStatus(Pagination pagination, Member member, ProductTransaction productTransaction);

	ResultPojoList selectSellerMemberProductListByStatus(Pagination pagination, Member member);

	ResultPojoList selectSelledProductList(Pagination pagination, Member member, ProductTransaction productTransaction);

	ResultPojoList selectBuyedProductList(Pagination pagination, Member member, ProductTransaction productTransaction);

	Product obtainProductWithTransactionByProduct(Product productResult,Member member);

	ResultPojoList selectSellingProductListByStatus(Pagination pagination, Member member, ProductTransaction productTransaction);

	ProductTransaction addUnsongJang(ProductTransaction productTransaction);

	Product obtainProductTransactionWithProductForSeller(Product product, Member member);

	ProductTransaction securePaymentClose(ProductTransaction productTransaction, History history);

	ResultPojoList selectProductRecommendList(Member member);

	ResultPojoList selectTodayRecommendList(Member memberChk);

	ResultPojoList searchProductTransactionRevice(Product product);

	ResultPojoList obtainProductRippleByProduct(Product product);




}
