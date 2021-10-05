package kr.ac.kopo.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;

import org.hibernate.annotations.BatchSize;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.util.DateUtils;
import com.javamodeling.util.NumberUtils;

import kr.ac.kopo.common.COLUMN;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@Table(name="PRODUCT")
public class Product extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSequenceGenerator")
	@SequenceGenerator(sequenceName = "PRODUCT_SEQ", name = "ProductSequenceGenerator", allocationSize = 1)
	@Column(name="PRODUCT_SQ")
	private Long productSq;

	@Column(name="AMOUNT")
	private Long amount;

	@Column(name="BARGIN")
	private String bargin;

	@Column(name="EXCHANGE")
	private String exchange;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="NAME")
	private String productName;

	@Column(name="PRICE")
	private Long price;

	@Lob
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="REGION")
	private String region;

	@Column(name="SHIPPING")
	private String shipping;

	@Column(name="STATUS")
	private String status;

	@Column(name="TAG")
	private String tag;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="VIEW_CNT")
	private Long viewCnt;

	//bi-directional many-to-one association to Cart
	@OneToMany
	@JoinColumn(name="CART_SQ")
	private List<Cart> cart;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name="PRODUCT_CATEGORY_SQ")
	private ProductCategory productCategory;

	//bi-directional many-to-one association to ProductImg
	@BatchSize(size = 100)
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ProductImg> productImgs;

	//bi-directional many-to-one association to ProductTransaction
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ProductTransaction> productTransactions;

	@Transient
	private Long fee;

	@Transient
	private Long priceAfter;
	
	@Transient
	private String barginAfter;
	
	@Transient
	private Long feeAfter;
	
	
	public Product() {
	}

	public Long getFeeAfter() {
		return feeAfter;
	}

	public void setFeeAfter(Long feeAfter) {
		this.feeAfter = feeAfter;
	}

	public String getBarginAfter() {
		return barginAfter;
	}

	public void setBarginAfter(String barginAfter) {
		this.barginAfter = barginAfter;
	}

	public void setPriceAfter(Long priceAfter) {
		this.priceAfter = priceAfter;
	}

	public Long getPriceAfter() {
		return priceAfter;
	}
	
	public String getPriceAfterWithComma() {
		
		return NumberUtils.convertComma(this.priceAfter);
	}
	
	

	public Long getProductSq() {
		return this.productSq;
	}

	public void setProductSq(Long productSq) {
		this.productSq = productSq;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getBargin() {
		return this.bargin;
	}

	public void setBargin(String bargin) {
		this.bargin = bargin;
	}
	
	public String getExchange() {
		return this.exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	public String getInputDateWithComma() {
		return DateUtils.restoreDate(this.inputDate);
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	

	
	/**
	 * 가격에 콤바 붙여서 리턴
	 * @return
	 */
	public String getPriceWithComma() {
		
		return NumberUtils.convertComma(this.price);
	}
	
	/**
	 * 가격에서 수수료 붙여서 계산 (1%)
	 * @return
	 */
	public String getFeesByPrice() {
		
		this.fee = (long) Math.ceil(((Long) this.price * 0.01 )*100/100); 
		return NumberUtils.convertComma(fee);
	}
	
	public Long getFeesAfterByPrice() {
		
		this.feeAfter = (long) Math.ceil(((Long) this.priceAfter * 0.01 )*100/100); 
		return feeAfter;
	}
	
	public String getFeesAfterByPriceWithComma() {
		
		this.feeAfter = (long) Math.ceil(((Long) this.priceAfter * 0.01 )*100/100); 
		return NumberUtils.convertComma(feeAfter);
	}
	

	
	/**
	 * 금액의 총합
	 * @return
	 */
	public String getTotalPrice() {
		
		Long total = this.price + (long) Math.ceil(((Long) this.price * 0.01 )*100/100);
		
		return NumberUtils.convertComma(total);
	}
	

	
	public String getTotalPriceAfter() {
		
		Long total = this.priceAfter + (long) Math.ceil(((Long) this.priceAfter * 0.01 )*100/100);
		
		return NumberUtils.convertComma(total);
	}
	
	public String getCalPoint() {
		
		double point;
		
		point = (((double) this.price * 0.01));
		
		return Double.toString(point);
	}
	
	public String getCalPointAfter() {
		
		double point;
		
		point = (((double) this.priceAfter * 0.01));
		
		return Double.toString(point);
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getShipping() {
		return this.shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Long getViewCnt() {
		return this.viewCnt;
	}

	public void setViewCnt(Long viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	public String getShippingStatus() {
		
		if(this.shipping==null||this.shipping.equals(COLUMN.PRODUCT.PRODUCT_SHIPPING.SHIPPING_CUSTOMER)) {
			return "착불";
		}else {
			return "배송비 포함";
			
		}
	}

	public String getExchangeStatus() {
		
		if(this.exchange==null||!this.exchange.equals(COLUMN.PRODUCT.PRODUCT_EXCHANGE.CAN_EX)) {
			return "교환 불가능";
		}else {
			return "교환 가능";
			
		}
	}

	public String getBarginStatus() {
		
		if(this.bargin==null||this.bargin.equals(null)||this.bargin.equals(COLUMN.PRODUCT.PRODUCT_CAN.CANNOT)) {
			return "흥정 불가능";
		}else {
			return "흥정 가능";
			
		}
	}
	

	public String getBarginAfterStatus() {
		
		if(this.barginAfter==null||this.barginAfter.equals(null)||this.barginAfter.equals(COLUMN.PRODUCT.PRODUCT_CAN.CANNOT)) {
			return "흥정 불가능";
		}else {
			return "흥정 가능";
			
		}
	}
	
	
	public Long getFee() {
		return (long) Math.ceil(((Long) this.price * 0.02 )*100/100); 
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public List<Cart> getCart() {
		return this.cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
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

	public List<ProductImg> getProductImgs() {
		return this.productImgs;
	}

	public void setProductImgs(List<ProductImg> productImgs) {
		this.productImgs = productImgs;
	}

	public ProductImg addProductImg(ProductImg productImg) {
		getProductImgs().add(productImg);
		productImg.setProduct(this);

		return productImg;
	}

	public ProductImg removeProductImg(ProductImg productImg) {
		getProductImgs().remove(productImg);
		productImg.setProduct(null);

		return productImg;
	}

	public List<ProductTransaction> getProductTransactions() {
		return this.productTransactions;
	}

	public void setProductTransactions(List<ProductTransaction> productTransactions) {
		this.productTransactions = productTransactions;
	}

	public ProductTransaction addProductTransaction(ProductTransaction productTransaction) {
		getProductTransactions().add(productTransaction);
		productTransaction.setProduct(this);

		return productTransaction;
	}

	public ProductTransaction removeProductTransaction(ProductTransaction productTransaction) {
		getProductTransactions().remove(productTransaction);
		productTransaction.setProduct(null);

		return productTransaction;
	}

}