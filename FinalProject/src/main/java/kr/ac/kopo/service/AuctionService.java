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
import kr.ac.kopo.pojo.AuctionProduct;
import kr.ac.kopo.pojo.AuctionTransaction;

public interface AuctionService {

	AuctionProduct addAuctionProduct(List<HanaFile> hanaFileResultList, AuctionProduct usedAuctionProduct);

	ResultPojoList searchAuctionList(Pagination pagination);

	AuctionProduct obtainAuctionProductByPk(AuctionProduct usedAuctionProduct);

	AuctionProduct modifyAuctionProduct(AuctionProduct auctionProduct, Member member);

	AuctionProduct addAuctionMaxPriceTransaction(AuctionTransaction auctionTransaction, AuctionProduct product, Account account, Member member, History history);

	AuctionProduct addAuctionSuccessBidTransaction();

	ResultPojoList searchAuctionListByCategory(Pagination pagination, ProductCategory productCategory, Member member);

	ResultPojoList selectMemberAuctionList(Pagination pagination, Member member);

	ResultPojoList selectSellerMemberAuctionList(Pagination pagination, Member member);

	ResultPojoList selectSelledAuctionList(Pagination pagination, Member member);

	ResultPojoList selectBuyedAuctionList(Pagination pagination, Member member);
	
	ResultPojoList selectAuctionRecommendList(Member memberResult);

	ResultPojoList selectMemberAuctionBidList(Pagination pagination, Member member);
	
}
