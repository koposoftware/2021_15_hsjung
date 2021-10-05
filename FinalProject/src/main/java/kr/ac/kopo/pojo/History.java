package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;

import java.math.BigDecimal;


/**
 * The persistent class for the HISTORY database table.
 * 
 */
@Entity
public class History extends CommonPojo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "HistorySequenceGenerator")
	@SequenceGenerator(sequenceName = "HISTORY_SEQ", name = "HistorySequenceGenerator", allocationSize = 1)
	@Column(name="HISTORY_SQ")
	private Long historySq;
	
	@Column(name="CHANGE")
	private Long change;

	@Column(name="FIELD")
	private String field;

	@Column(name="MODIFY_CHANGE")
	private Long modifyChange;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="RECEIVER_BANK_CODE")
	private Long receiverBankCode;
	
	@Column(name="RECEIVER_ACCOUNT_NUMBER")
	private Long receiverAccountNumber;

	@Column(name="TASK")
	private String task;

	//bi-directional one-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCOUNT_SQ")
	private Account account;

	public History() {
	}

	public Long getChange() {
		return this.change;
	}

	public void setChange(Long change) {
		this.change = change;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Long getModifyChange() {
		return this.modifyChange;
	}

	public void setModifyChange(Long modifyChange) {
		this.modifyChange = modifyChange;
	}

	public Long getHistorySq() {
		return this.historySq;
	}

	public void setHistorySq(Long historySq) {
		this.historySq = historySq;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Long getReceiverBankCode() {
		return this.receiverBankCode;
	}

	public void setReceiverBankCode(Long receiverBankCode) {
		this.receiverBankCode = receiverBankCode;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

}