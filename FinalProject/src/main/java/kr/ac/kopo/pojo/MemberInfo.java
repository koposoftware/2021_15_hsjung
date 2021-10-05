package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;



/**
 * The persistent class for the MEMBER_INF database table.
 * 
 */
@Entity
@DynamicUpdate
@Table(name="MEMBER_INFO")
public class MemberInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MEMBER_INFO_SQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MemberInfoSequenceGenerator")
	@SequenceGenerator(sequenceName = "MEMBER_INFO_SEQ", name = "MemberInfoSequenceGenerator", allocationSize = 1)
	private Long memberInfoSq;

	@Column(name="COUNT_CATEGORY")
	private Long countCategory;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_CATEGORY_SQ")
	private ProductCategory productCategory;

	public MemberInfo() {
	}

	public Long getMemberInfoSq() {
		return memberInfoSq;
	}

	public void setMemberInfoSq(Long memberInfoSq) {
		this.memberInfoSq = memberInfoSq;
	}

	public Long getCountCategory() {
		return countCategory;
	}

	public void setCountCategory(Long countCategory) {
		this.countCategory = countCategory;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategorySq) {
		this.productCategory = productCategorySq;
	}

	
	

}