package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the HISTORY_LOG database table.
 * 
 */
@Entity
@Table(name="HISTORY_LOG")
public class HistoryLog extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="HISTORY_LOG_SQ")
	private Long historyLogSq;

	@Column(name="HISTORY_LOG_MESSAGE")
	private String historyLogMessage;

	@Column(name="HISTORY_LOG_TIME")
	private String historyLogTime;

	public HistoryLog() {
	}

	public Long getHistoryLogSq() {
		return this.historyLogSq;
	}

	public void setHistoryLogSq(Long historyLogSq) {
		this.historyLogSq = historyLogSq;
	}

	public String getHistoryLogMessage() {
		return this.historyLogMessage;
	}

	public void setHistoryLogMessage(String historyLogMessage) {
		this.historyLogMessage = historyLogMessage;
	}

	public String getHistoryLogTime() {
		return this.historyLogTime;
	}

	public void setHistoryLogTime(String historyLogTime) {
		this.historyLogTime = historyLogTime;
	}

}