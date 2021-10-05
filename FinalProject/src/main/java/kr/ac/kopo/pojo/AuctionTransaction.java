package kr.ac.kopo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the PRODUCT_AUCTION_TRANSACTION database table.
 * 
 */
@Entity
@Table(name="AUCTION_TRANSACTION")
public class AuctionTransaction extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "AuctionTransactionSequenceGenerator")
	@SequenceGenerator(sequenceName = "AUCTION_TRANSACTION_SEQ", name = "AuctionTransactionSequenceGenerator", allocationSize = 1)
	@Column(name="AUCTION_TRANSACTION_SQ")
	private Long auctionTransactionSq;
	
	@Column(name="ADDRESS")
	private String address;

	@Column(name="AMOUNT")
	private Long amount;

	@Column(name="BUYER_MEMBER_SQ")
	private Long buyerMemberSq;

	@Column(name="PRICE")
	private Long price;

	@Column(name="PRODUCT_SQ")
	private Long productSq;

	@Column(name="SELLER_MEMBER_SQ")
	private Long sellerMemberSq;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="TRANSACTION_TYPE")
	private String transactionType;

	//bi-directional many-to-one association to UsedAuctionProduct
	@ManyToOne
	@JoinColumn(name="AUCTION_PRODUCT_SQ")
	private AuctionProduct auctionProduct;

	public AuctionTransaction() {
	}

	public Long getAuctionTransactionSq() {
		return this.auctionTransactionSq;
	}

	public void setProductTransactionSq(Long auctionTransactionSq) {
		this.auctionTransactionSq = auctionTransactionSq;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getBuyerMemberSq() {
		return this.buyerMemberSq;
	}

	public void setBuyerMemberSq(Long buyerMemberSq) {
		this.buyerMemberSq = buyerMemberSq;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getProductSq() {
		return this.productSq;
	}

	public void setProductSq(Long productSq) {
		this.productSq = productSq;
	}

	public Long getSellerMemberSq() {
		return this.sellerMemberSq;
	}

	public void setSellerMemberSq(Long sellerMemberSq) {
		this.sellerMemberSq = sellerMemberSq;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public AuctionProduct getAuctionProduct() {
		return this.auctionProduct;
	}

	public void setAuctionProduct(AuctionProduct auctionProduct) {
		this.auctionProduct = auctionProduct;
	}

}