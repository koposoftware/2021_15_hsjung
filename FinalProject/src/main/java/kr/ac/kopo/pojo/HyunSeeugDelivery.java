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
@Table(name="HYUN_SEEUG_DELIVERY")
public class HyunSeeugDelivery extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "HyunSeeugDeliveryGenerator")
	@SequenceGenerator(sequenceName = "HYUN_SEEUG_DILIVERY_SEQ", name = "HyunSeeugDeliveryGenerator", allocationSize = 1)
	@Column(name="HYUN_SEEUG_DELIVERY_SQ")
	private Long hyunSeeugDeilverySq;

	@Column(name="MEMBER_SQ")
	private String memberSq;
	
	@Column(name="PRODUCT_TYPE")
	private String productType;
	
	@Column(name="PRODUCT_SQ")
	private String productSq;
	
	@Column(name="PRODUCT_STATUS")
	private String productStatus;
	
	@Column(name="INPUT_DATE")
	private String inputDate;
	
	@Column(name="UPDATE_DATE")
	private String updateDate;
	
	public HyunSeeugDelivery() {
	}

	public Long getHyunSeeugDeilverySq() {
		return hyunSeeugDeilverySq;
	}

	public void setHyunSeeugDeilverySq(Long hyunSeeugDeilverySq) {
		this.hyunSeeugDeilverySq = hyunSeeugDeilverySq;
	}

	public String getMemberSq() {
		return memberSq;
	}

	public void setMemberSq(String memberSq) {
		this.memberSq = memberSq;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductSq() {
		return productSq;
	}

	public void setProductSq(String productSq) {
		this.productSq = productSq;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	

}