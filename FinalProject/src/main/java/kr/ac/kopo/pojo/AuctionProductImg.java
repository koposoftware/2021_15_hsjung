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
 * The persistent class for the AUCTION_PRODUCT_IMG database table.
 * 
 */
@Entity
@Table(name="AUCTION_PRODUCT_IMG")
public class AuctionProductImg extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "AuctionProductImgSequenceGenerator")
	@SequenceGenerator(sequenceName = "AUCTION_PRODUCT_IMG_SEQ", name = "AuctionProductImgSequenceGenerator", allocationSize = 1)
	@Column(name="AUCTION_PRODUCT_IMG_SQ")
	private Long auctionProductImgSq;

	@Column(name="FILE_SQ")
	private Long fileSq;

	//bi-directional many-to-one association to UsedAuctionProduct
	@ManyToOne
	@JoinColumn(name="AUCTION_PRODUCT_SQ")
	private AuctionProduct auctionProduct;

	public AuctionProductImg() {
	}

	public Long getAuctionProductImgSq() {
		return this.auctionProductImgSq;
	}

	public void setAuctionProductImgSq(Long auctionProductImgSq) {
		this.auctionProductImgSq = auctionProductImgSq;
	}

	public Long getFileSq() {
		return this.fileSq;
	}

	public void setFileSq(Long fileSq) {
		this.fileSq = fileSq;
	}

	public AuctionProduct getAuctionProduct() {
		return this.auctionProduct;
	}

	public void setAuctionProduct(AuctionProduct auctionProduct) {
		this.auctionProduct = auctionProduct;
	}

}