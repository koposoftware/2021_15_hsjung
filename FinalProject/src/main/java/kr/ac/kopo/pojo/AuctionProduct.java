package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.BatchSize;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;
import com.javamodeling.util.DateUtils;
import com.javamodeling.util.NumberUtils;

import kr.ac.kopo.common.COLUMN;

import java.util.List;


/**
 * The persistent class for the USED_AUCTION_PRODUCT database table.
 * 
 */
@Entity
@Table(name="AUCTION_PRODUCT")
public class AuctionProduct extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "auctionProductSequenceGenerator")
	@SequenceGenerator(sequenceName = "AUCTION_PRODUCT_SEQ", name = "auctionProductSequenceGenerator", allocationSize = 1)
	@Column(name="AUCTION_PRODUCT_SQ")
	private Long auctionProductSq;

	@Column(name="ADDRESS")
	private Long address;

	@Lob
	@Column(name="DETAIL")
	private String detail;

	@Column(name="AUCTION_PRODUCT_NAME")
	private String auctionProductName;
	
	@Column(name="END_DATE")
	private String endDate;

	@Column(name="EXCHANGE")
	private String exchange;
	
	@Column(name="PRICE_NOW")
	private Long priceNow;

	@Column(name="PRICE_MAX")
	private Long priceMax;

	@Column(name="PRICE_MIN")
	private Long priceMin;

	@Column(name="SHIPPING")
	private String shipping;

	@Column(name="START_DATE")
	private String startDate;

	@Column(name="TAG")
	private String tag;

	@Column(name="INPUT_DATE")
	private String inputDate;
	
	@Column(name="STATUS")
	private String status;

	@Column(name="VIEW_CNT")
	private Long viewCnt;
	
	@Column(name="IBCHALJA")
	private Long ibchalja;

	//bi-directional many-to-one association to AuctionProductImg
	@BatchSize(size = 100)
	@OneToMany(mappedBy="auctionProduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<AuctionProductImg> auctionProductImgs;

	//bi-directional many-to-one association to ProductAuctionTransaction
	@OneToMany(mappedBy="auctionProduct")
	private List<AuctionTransaction> auctionTransactions;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne 
	@JoinColumn(name="PRODUCT_CATEGORY_SQ")
	private ProductCategory productCategory;

	@Transient
	private Long ModifyPrice;
	
	@Transient
	private Long maxFee;
	

	public AuctionProduct() {
		
	}

	public Long getAuctionProductSq() {
		return this.auctionProductSq;
	}

	public void setAuctionProductSq(Long auctionProductSq) {
		this.auctionProductSq = auctionProductSq;
	}

	public Long getAddress() {
		return this.address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getEndDateWithComma() {
		
		return DateUtils.traceDatetime(this.endDate);
	}

	public String getEndDateByTraceDateTime() {
		
		return DateUtils.traceDatetime(this.endDate);
	}

	public String getExchange() {
		return this.exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public Long getPriceMax() {
		return this.priceMax;
	}

	public void setPriceMax(Long priceMax) {
		this.priceMax = priceMax;
	}

	/**
	 * 가격에 콤바 붙여서 리턴
	 * @return
	 */
	public String getPriceMaxWithComma() {
		
		return NumberUtils.convertComma(this.priceMax);
	}
	
	/**
	 * 가격에서 수수료 붙여서 계산 (2%)
	 * @return
	 */
	public String getFeesByMaxPrice() {
		
		this.maxFee = (long) Math.ceil(((Long) this.priceMax * 0.02 )*100/100); 
		return NumberUtils.convertComma(maxFee);
	}
	
	public Long getPriceMin() {
		return this.priceMin;
	}

	public void setPriceMin(Long priceMin) {
		this.priceMin = priceMin;
	}

	/**
	 * 가격에 콤바 붙여서 리턴
	 * @return
	 */
	public String getPriceMinWithComma() {
		
		return NumberUtils.convertComma(this.priceMin);
	}
	
	public String getShipping() {
		return this.shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	
	/**
	 * 금액의 총합
	 * @return
	 */
	public String getTotalMaxPrice() {
		
		Long total = this.priceMax + this.maxFee;
		
		return NumberUtils.convertComma(total);
	}
	
	public String getCalMaxPricePoint() {
		
		double point;
		
		point = (((double) this.priceMax * 0.01));
		
		return Double.toString(point);
	}

	public String getShippingStatus() {
		
		if(this.shipping != null||this.shipping.equals(COLUMN.PRODUCT.PRODUCT_SHIPPING.SHIPPING_CUSTOMER)) {
			return "착불";
		}else {
			return "배송비 포함";
			
		}
	}


	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartDateWithComma() {
			
			return DateUtils.traceDatetime(this.startDate);
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getAuctionProductName() {
		return auctionProductName;
	}

	public void setAuctionProductName(String auctionProductName) {
		this.auctionProductName = auctionProductName;
	}

	public Long getPriceNow() {
		return priceNow;
	}

	public void setPriceNow(Long priceNow) {
		this.priceNow = priceNow;
	}
	
	public String getPriceNowWithComma() {
		
		return NumberUtils.convertComma(this.priceNow);
	}
	
	public String getCalcPriceWithComma() {
		
		Long calcPrice = (this.getPriceMax() - this.getPriceMin())/100; 
		return NumberUtils.convertComma(calcPrice);
	}
	
	public String getCalcPriceMinWithComma() {
		
		Long calcPrice = ((this.getPriceMax() - this.getPriceMin())/60) - ((this.getPriceMax() - this.getPriceMin())/100); 
		return NumberUtils.convertComma(calcPrice);
	}

	public String getCalcPriceMaxWithComma() {
	
	Long calcPrice = (this.getPriceMax() - this.getPriceMin())/30 -((this.getPriceMax() - this.getPriceMin())/100); 
	return NumberUtils.convertComma(calcPrice);
}
	public Long getCalcPrice() {
		
		Long calcPrice = (this.getPriceMax() - this.getPriceMin())/100; 
		return calcPrice;
	}
	
	public Long getCalcPriceMin() {
		
		Long calcPrice = ((this.getPriceMax() - this.getPriceMin())/60) - ((this.getPriceMax() - this.getPriceMin())/100); 
		return calcPrice;
	}
	
	public Long getCalcPriceMax() {
		
		Long calcPrice = (this.getPriceMax() - this.getPriceMin())/30 -((this.getPriceMax() - this.getPriceMin())/100); 
		return calcPrice;
	}

	public Long getMaxFee() {
		return maxFee;
	}

	public void setMaxFee(Long maxFee) {
		this.maxFee = maxFee;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Long getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(Long defaultstate) {
		this.viewCnt = defaultstate;
	}


	public String getExchangeStatus() {
		
		if(this.exchange==null||!this.exchange.equals(COLUMN.PRODUCT.PRODUCT_EXCHANGE.CAN_EX)) {
			return "교환 불가능";
		}else {
			return "교환 가능";
			
		}
	}


	
	public Long getIbchalja() {
		return ibchalja;
	}

	public void setIbchalja(Long ibchalja) {
		this.ibchalja = ibchalja;
	}

	public Long getModifyPrice() {
		return ModifyPrice;
	}

	public void setModifyPrice(Long modifyPrice) {
		ModifyPrice = modifyPrice;
	}

	public List<AuctionProductImg> getAuctionProductImgs() {
		return this.auctionProductImgs;
	}

	public void setAuctionProductImgs(List<AuctionProductImg> auctionProductImgs) {
		this.auctionProductImgs = auctionProductImgs;
	}

	public AuctionProductImg addAuctionProductImg(AuctionProductImg auctionProductImg) {
		getAuctionProductImgs().add(auctionProductImg);
		auctionProductImg.setAuctionProduct(this);

		return auctionProductImg;
	}

	public AuctionProductImg removeAuctionProductImg(AuctionProductImg auctionProductImg) {
		getAuctionProductImgs().remove(auctionProductImg);
		auctionProductImg.setAuctionProduct(null);

		return auctionProductImg;
	}

	public List<AuctionTransaction> getAuctionTransactions() {
		return this.auctionTransactions;
	}

	public void setAuctionTransactions(List<AuctionTransaction> auctionTransactions) {
		this.auctionTransactions = auctionTransactions;
	}

	public AuctionTransaction addAuctionTransaction(AuctionTransaction auctionTransaction) {
		getAuctionTransactions().add(auctionTransaction);
		auctionTransaction.setAuctionProduct(this);

		return auctionTransaction;
	}

	public AuctionTransaction removeAuctionTransaction(AuctionTransaction auctionTransaction) {
		getAuctionTransactions().remove(auctionTransaction);
		auctionTransaction.setAuctionProduct(null);

		return auctionTransaction;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}