package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;
import com.javamodeling.util.DateUtils;

import kr.ac.kopo.common.COLUMN;


/**
 * The persistent class for the PRODUCT_TRANSACTION database table.
 * 
 */
@Entity
@Table(name="PRODUCT_TRANSACTION")
public class ProductTransaction extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ProductTransactionSequenceGenerator")
	@SequenceGenerator(sequenceName = "PRODUCT_TRANSACTION_SEQ", name = "ProductTransactionSequenceGenerator", allocationSize = 1)
	@Column(name="PRODUCT_TRANSACTION_SQ")
	private Long productTransactionSq;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="AMOUNT")
	private Long amount;

	@Column(name="BUYER_MEMBER_SQ")
	private Long buyerMemberSq;

	@Column(name="PRICE")
	private Long transactionPrice;

	@Column(name="SELLER_MEMBER_SQ")
	private Long sellerMemberSq;

	@Column(name="TRANSACTION_DATE")
	private String transactionDate;

	@Column(name="TRANSACTION_TYPE")
	private String transactionType;

	@Column(name="UNSONGJANG")
	private String unsongjang;
	
	//bi-directional many-to-one association to Product
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_SQ")
	private Product product;

	public ProductTransaction() {
	}

	public Long getProductTransactionSq() {
		return this.productTransactionSq;
	}

	public void setProductTransactionSq(Long productTransactionSq) {
		this.productTransactionSq = productTransactionSq;
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

	public Long getTransactionPrice() {
		return this.transactionPrice;
	}

	public void setTransactionPrice(Long price) {
		this.transactionPrice = price;
	}

	public Long getSellerMemberSq() {
		return this.sellerMemberSq;
	}

	public void setSellerMemberSq(Long sellerMemberSq) {
		this.sellerMemberSq = sellerMemberSq;
	}


	
	public String getTransactionDateWithComma() {
		return DateUtils.restoreDate(this.transactionDate);
	}

	public String getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	

	public String getTransactionTypeInKor() {
		if(this.transactionType.equals(COLUMN.PRODUCT_TRANSACTION.SAFE_START)) {
			return "안심거래 진행 중 (물건 준비 중)";
		} else if(this.transactionType.equals(COLUMN.PRODUCT_TRANSACTION.GET_DELIVERY)) {
			return "안심거래 진행 중 (배송 진행 중)";
		}else if(this.transactionType.equals(COLUMN.PRODUCT_TRANSACTION.SAFE_END)) {
			return "안심거래 완료";
		}else {
			return this.transactionType;
		}
		
	}
	
	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUnsongjang() {
		return unsongjang;
	}

	public void setUnsongjang(String unsongjang) {
		this.unsongjang = unsongjang;
	}

}