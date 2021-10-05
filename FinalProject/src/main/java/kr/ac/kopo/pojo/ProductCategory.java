package kr.ac.kopo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.javamodeling.common.CommonPojo;


/**
 * The persistent class for the PRODUCT_CATEGORY database table.
 * 
 */
@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategorySequenceGenerator")
	@SequenceGenerator(sequenceName = "PRODUCT_CATEGORY_SEQ", name = "ProductCategorySequenceGenerator", allocationSize = 1)
	@Column(name="PRODUCT_CATEGORY_SQ")
	private Long productCategorySq;

	@Column(name="PRODUCT_CATEGORY")
	private String productCategory;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productCategory",cascade = CascadeType.ALL)
	private List<Product> products;

	//bi-directional many-to-one association to UsedAuctionProduct
	@OneToMany(mappedBy="productCategory",cascade = CascadeType.ALL)
	private List<AuctionProduct> usedAuctionProducts;

	public ProductCategory() {
	}

	public Long getProductCategorySq() {
		return this.productCategorySq;
	}

	public void setProductCategorySq(Long productCategorySq) {
		this.productCategorySq = productCategorySq;
	}

	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductCategory(null);

		return product;
	}

	public List<AuctionProduct> getUsedAuctionProducts() {
		return this.usedAuctionProducts;
	}

	public void setUsedAuctionProducts(List<AuctionProduct> usedAuctionProducts) {
		this.usedAuctionProducts = usedAuctionProducts;
	}

	public AuctionProduct addUsedAuctionProduct(AuctionProduct usedAuctionProduct) {
		getUsedAuctionProducts().add(usedAuctionProduct);
		usedAuctionProduct.setProductCategory(this);

		return usedAuctionProduct;
	}

	public AuctionProduct removeUsedAuctionProduct(AuctionProduct usedAuctionProduct) {
		getUsedAuctionProducts().remove(usedAuctionProduct);
		usedAuctionProduct.setProductCategory(null);

		return usedAuctionProduct;
	}

}