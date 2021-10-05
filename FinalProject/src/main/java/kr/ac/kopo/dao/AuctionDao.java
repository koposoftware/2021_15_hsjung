package kr.ac.kopo.dao;

import java.util.List;

import com.javamodeling.common.Pagination;
import com.javamodeling.component.DaoInterface;

import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.MemberInfo;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.AuctionProduct;
import kr.ac.kopo.pojo.AuctionTransaction;

public interface AuctionDao extends DaoInterface {

	List<AuctionProduct> searchAuctionList(Pagination pagination);

	Long countAuctionList(Pagination pagination);

	AuctionProduct obtainAuctionProductByPk(AuctionProduct auctionProduct);

	List<AuctionProduct> searchAuctionListByCategory(Pagination pagination, ProductCategory productCategory);

	Long countAuctionListByCategory(Pagination pagination, ProductCategory productCategory);

	List<AuctionTransaction> selectMemberAuctionList(Pagination pagination, Member member);

	List<AuctionProduct> selectSellerMemberAuctionList(Pagination pagination, Member member);

	List<AuctionTransaction> selectSelledAuctionList(Pagination pagination, Member member);

	List<AuctionTransaction> selectBuyedAuctionList(Pagination pagination, Member member);

	List<MemberInfo> obtainMaxAuctionCategoryFromMemberInfo(Member member);

	List<AuctionProduct> selectAuctionRecommendList(Member member, MemberInfo memberInfo);

	Long countAuctionBuy(Member member);

	Long countAuctionSell(Member member);

	List<?> selectMemberAuctionBidList(Pagination pagination, Member member);

	List<AuctionProduct> obtainSuccessBidAuction();



}
