package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;

import java.util.List;


/**
 * The persistent class for the CART database table.
 * 
 */
@Entity
@Table(name="CART")
public class Cart extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CartGenerator")
	@SequenceGenerator(sequenceName = "CART_SEQ", name = "CartGenerator", allocationSize = 1)
	@Column(name="CART_SQ")
	private Long cartSq;

	@Column(name="INPUT_DATE")
	private String inputDate;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	@ManyToOne
	@JoinColumn(name="PRODUCT_SQ")
	private Product product;
	
	public Cart() {
	}

	public Long getCartSq() {
		return this.cartSq;
	}

	public void setCartSq(Long cartSq) {
		this.cartSq = cartSq;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	


}