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
 * The persistent class for the PRODUCT_TRANSACTION_REVIEW database table.
 * 
 */
@Entity
@Table(name="PRODUCT_TRANSACTION_REVIEW")
public class ProductTransactionReview extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ProductTransactionReviewSequenceGenerator")
	@SequenceGenerator(sequenceName = "PRODUCT_TRANSACTION_REVIEW_SEQ", name = "ProductTransactionReviewSequenceGenerator", allocationSize = 1)
	@Column(name="PRODUCT_TRANSACTION_REVIEW_SQ")
	private Long productTransactionReviewSq;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="IS_AUCTION")
	private String isAuction;

	@Column(name="PRODUCT_SQ")
	private Long productSq;

	@Column(name="TRANSACTION_REVIEW_CONTENT")
	private String transactionReviewContent;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	public ProductTransactionReview() {
	}

	public Long getProductTransactionReviewSq() {
		return this.productTransactionReviewSq;
	}

	public void setProductTransactionReviewSq(Long productTransactionReviewSq) {
		this.productTransactionReviewSq = productTransactionReviewSq;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getIsAuction() {
		return this.isAuction;
	}

	public void setIsAuction(String isAuction) {
		this.isAuction = isAuction;
	}

	public Long getProductSq() {
		return this.productSq;
	}

	public void setProductSq(Long productSq) {
		this.productSq = productSq;
	}

	public String getTransactionReviewContent() {
		return this.transactionReviewContent;
	}

	public void setTransactionReviewContent(String transactionReviewContent) {
		this.transactionReviewContent = transactionReviewContent;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}