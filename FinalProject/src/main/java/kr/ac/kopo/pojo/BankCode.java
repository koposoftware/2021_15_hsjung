package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the BANK_CODE database table.
 * 
 */
@Entity
@Table(name="BANK_CODE")
public class BankCode extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "BankCodeSequenceGenerator")
	@SequenceGenerator(sequenceName = "BANK_CODE_SEQ", name = "BankCodeSequenceGenerator", allocationSize = 1)
	@Column(name="BANK_CD")
	private Long bankCd;

	@Column(name="BANK_CODE")
	private String bankCode;

	@Column(name="BANK_NAME")
	private String bankName;

	public BankCode() {
	}

	public Long getBankCd() {
		return this.bankCd;
	}

	public void setBankCd(Long bankCd) {
		this.bankCd = bankCd;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}