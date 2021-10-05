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


/**
 * The persistent class for the PRODUCT_IMG database table.
 * 
 */
@Entity
@Table(name="PRODUCT_IMG")
public class ProductImg extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductImgSequenceGenerator")
	@SequenceGenerator(sequenceName = "PRODUCT_IMG_SEQ", name = "ProductImgSequenceGenerator", allocationSize = 1)
	@Column(name="PRODUCT_IMG_SQ")
	private Long productImgSq;

	@Column(name="FILE_SQ")
	private Long fileSq;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_SQ")
	private Product product;

	public ProductImg() {
	}

	public Long getProductImgSq() {
		return this.productImgSq;
	}

	public void setProductImgSq(Long productImgSq) {
		this.productImgSq = productImgSq;
	}

	public Long getFileSq() {
		return this.fileSq;
	}

	public void setFileSq(Long fileSq) {
		this.fileSq = fileSq;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}