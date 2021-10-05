package kr.ac.kopo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.javamodeling.common.CommonPojo;


/**
 * The persistent class for the MEMBER database table.
 * 
 */
@Entity
@Table(name="MEMBER")
@NamedStoredProcedureQuery(
        name="ADD_MEMBER_BASIC_SETTING",
        procedureName="ADD_MEMBER_BASIC_SETTING",
		/* resultClasses = { Member.class }, */
        parameters={
            @StoredProcedureParameter(name="MEMBER_PK", mode =ParameterMode.IN, type=Long.class),
            @StoredProcedureParameter(name="MEMBER_MAIN_ACC", mode =ParameterMode.IN, type=Long.class)
        }
)
public class Member extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MemberSequenceGenerator")
	@SequenceGenerator(sequenceName = "MEMBER_SEQ", name = "MemberSequenceGenerator", allocationSize = 1)
	@Column(name="MEMBER_SQ")
	private Long memberSq;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="BIRTH")
	private String birth;

	@Column(name="GENDER")
	private String gender;

	@Column(name="ID")
	private String id;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="JUMIN_NO")
	private Long juminNo;

	@Column(name="NAME")
	private String name;

	@Column(name="PHONE")
	private String phone;

	@Column(name="PWD")
	private String pwd;
	
	@Column(name="POINT")
	private String point;
	
	@Column(name="MEMBER_MAIN_ACCOUNT")
	private Long memberMainAccount;
	
	@Column(name="SCORE")
	private Long score;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="member")
	private List<Account> accounts;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="member")
	private List<Cart> carts;

	//bi-directional many-to-one association to ChatMessage
	@OneToMany(mappedBy="member")
	private List<ChatMessage> chatMessages;

	//bi-directional many-to-one association to ChatMessageRoomJoin
	@OneToMany(mappedBy="member")
	private List<ChatMessageRoomJoin> chatMessageRoomJoins;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="member",cascade = CascadeType.ALL)
	private List<Product> products;

	//bi-directional many-to-one association to ProductTransactionReview
	@OneToMany(mappedBy="member")
	private List<ProductTransactionReview> productTransactionReviews;

	//bi-directional many-to-one association to UsedAuctionProduct
	@OneToMany(mappedBy="member")
	private List<AuctionProduct> auctionProducts;
	
	//bi-directional one-to-one association to MemberInf
	@OneToMany(mappedBy="member")
	private List<MemberInfo> memberInf;

	@ManyToOne
	@JoinColumn(name="MEMBER_TIER_SQ")
	private MemberTier memberTier;
	
	@Transient
	private Long sellerMemberSq;
	
	@Transient
	private Long buyerMemberSq;
	
	public Member() {
	}

	public Long getMemberSq() {
		return this.memberSq;
	}

	public void setMemberSq(Long memberSq) {
		this.memberSq = memberSq;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Long getJuminNo() {
		return this.juminNo;
	}

	public void setJuminNo(Long juminNo) {
		this.juminNo = juminNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public List<MemberInfo> getMemberInf() {
		return memberInf;
	}

	public void setMemberInf(List<MemberInfo> memberInf) {
		this.memberInf = memberInf;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	public Long getMemberMainAccount() {
		return memberMainAccount;
	}

	public void setMemberMainAccount(Long memberMainAccount) {
		this.memberMainAccount = memberMainAccount;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setMember(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setMember(null);

		return account;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	public MemberTier getMemberTier() {
		return memberTier;
	}

	public void setMemberTier(MemberTier memberTier) {
		this.memberTier = memberTier;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setMember(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setMember(null);

		return cart;
	}

	public List<ChatMessage> getChatMessages() {
		return this.chatMessages;
	}

	public void setChatMessages(List<ChatMessage> chatMessages) {
		this.chatMessages = chatMessages;
	}

	public ChatMessage addChatMessage(ChatMessage chatMessage) {
		getChatMessages().add(chatMessage);
		chatMessage.setMember(this);

		return chatMessage;
	}

	public ChatMessage removeChatMessage(ChatMessage chatMessage) {
		getChatMessages().remove(chatMessage);
		chatMessage.setMember(null);

		return chatMessage;
	}

	public List<ChatMessageRoomJoin> getChatMessageRoomJoins() {
		return this.chatMessageRoomJoins;
	}

	public void setChatMessageRoomJoins(List<ChatMessageRoomJoin> chatMessageRoomJoins) {
		this.chatMessageRoomJoins = chatMessageRoomJoins;
	}

	public ChatMessageRoomJoin addChatMessageRoomJoin(ChatMessageRoomJoin chatMessageRoomJoin) {
		getChatMessageRoomJoins().add(chatMessageRoomJoin);
		chatMessageRoomJoin.setMember(this);

		return chatMessageRoomJoin;
	}

	public ChatMessageRoomJoin removeChatMessageRoomJoin(ChatMessageRoomJoin chatMessageRoomJoin) {
		getChatMessageRoomJoins().remove(chatMessageRoomJoin);
		chatMessageRoomJoin.setMember(null);

		return chatMessageRoomJoin;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setMember(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setMember(null);

		return product;
	}

	public List<ProductTransactionReview> getProductTransactionReviews() {
		return this.productTransactionReviews;
	}

	public void setProductTransactionReviews(List<ProductTransactionReview> productTransactionReviews) {
		this.productTransactionReviews = productTransactionReviews;
	}

	public ProductTransactionReview addProductTransactionReview(ProductTransactionReview productTransactionReview) {
		getProductTransactionReviews().add(productTransactionReview);
		productTransactionReview.setMember(this);

		return productTransactionReview;
	}

	public ProductTransactionReview removeProductTransactionReview(ProductTransactionReview productTransactionReview) {
		getProductTransactionReviews().remove(productTransactionReview);
		productTransactionReview.setMember(null);

		return productTransactionReview;
	}

	public List<AuctionProduct> getAuctionProducts() {
		return this.auctionProducts;
	}

	public void setAuctionProducts(List<AuctionProduct> auctionProducts) {
		this.auctionProducts = auctionProducts;
	}

	public AuctionProduct addAuctionProduct(AuctionProduct auctionProducts) {
		getAuctionProducts().add(auctionProducts);
		auctionProducts.setMember(this);

		return auctionProducts;
	}

	public AuctionProduct removeUsedAuctionProduct(AuctionProduct auctionProducts) {
		getAuctionProducts().remove(auctionProducts);
		auctionProducts.setMember(null);

		return auctionProducts;
	}

	public Long getSellerMemberSq() {
		return sellerMemberSq;
	}

	public void setSellerMemberSq(Long sellerMemberSq) {
		this.sellerMemberSq = sellerMemberSq;
	}

	public Long getBuyerMemberSq() {
		return buyerMemberSq;
	}

	public void setBuyerMemberSq(Long buyerMemberSq) {
		this.buyerMemberSq = buyerMemberSq;
	}
	
	

}