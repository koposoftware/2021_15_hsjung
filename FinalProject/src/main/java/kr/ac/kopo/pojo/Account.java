package kr.ac.kopo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;
import com.javamodeling.util.NumberUtils;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name="Account")
public class Account extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "AccountSequenceGenerator")
	@SequenceGenerator(sequenceName = "ACCOUNT_SEQ", name = "AccountSequenceGenerator", allocationSize = 1)
	@Column(name="ACCOUNT_SQ")
	private Long accountSq;

	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name="BANK_CD")
	private String bankCd;

	@Column(name="CHANGE")
	private Long change;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="UPDATE_DATE")
	private String updateDate;
	
	@Column(name="ACCOUNT_PWD")
	private String accountPwd;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	//bi-directional one-to-one association to History
	@OneToMany(mappedBy="account")
	private List<History> history;

	public Account() {
	}

	public Long getAccountSq() {
		return this.accountSq;
	}

	public void setAccountSq(Long accountSq) {
		this.accountSq = accountSq;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankCdName() {
		
		if(this.bankCd.equals("1")) {
			return "하나은행";
		}else {
			return this.bankCd;
		}
	}
	
	public String getBankCd() {
		return this.bankCd;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public String getChangeWithComma() {
		
		return NumberUtils.convertComma(this.change);
	}
	
	public Long getChange() {
		return this.change;
	}

	public void setChange(Long change) {
		this.change = change;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
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

	public List<History> getHistory() {
		return this.history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public String getAccountPwd() {
		return accountPwd;
	}

	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}

	
}