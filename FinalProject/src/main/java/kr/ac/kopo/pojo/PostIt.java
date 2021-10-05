package kr.ac.kopo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.javamodeling.common.CommonPojo;


/**
 * The persistent class for the PRODUCT_IMG database table.
 * 
 */
@Entity
@Table(name="POST_IT")
public class PostIt extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PostItSequenceGenerator")
	@SequenceGenerator(sequenceName = "POST_IT_SEQ", name = "PostItSequenceGenerator", allocationSize = 1)
	@Column(name="POST_IT_PK")
	private Long postItPk;

	@Column(name="POST_IT_CONTENTS")
	private String postItContents;
	
	@Column(name="RECEIVER_MEMBER_PK")
	private Long receiverMemberPk;
	
	@Column(name="SENDER_MEMBER_PK")
	private Long senderMemberPk;
	
	@Column(name="IS_READ")
	private String isRead;
	
	@Column(name="INPUT_DATE")
	private String inputDate;


	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_SQ")
	private Product product;

	public PostIt() {
	}

	public Long getPostItPk() {
		return postItPk;
	}

	public void setPostItPk(Long postItPk) {
		this.postItPk = postItPk;
	}

	public String getPostItContents() {
		return postItContents;
	}

	public void setPostItContents(String postItContents) {
		this.postItContents = postItContents;
	}

	public Long getReceiverMemberPk() {
		return receiverMemberPk;
	}

	public void setReceiverMemberPk(Long receiverMemberPk) {
		this.receiverMemberPk = receiverMemberPk;
	}

	public Long getSenderMemberPk() {
		return senderMemberPk;
	}

	public void setSenderMemberPk(Long senderMemberPk) {
		this.senderMemberPk = senderMemberPk;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

}