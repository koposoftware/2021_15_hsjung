package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the CHAT_MESSAGE database table.
 * 
 */
@Entity
@Table(name="CHAT_MESSAGE")
public class ChatMessage extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="CHAT_MESSAGE_SQ")
	private Long chatMessageSq;

	@Column(name="CHAT_MESSAGE")
	private String chatMessage;

	@Column(name="INPUT_DATE")
	private String inputDate;

	//bi-directional many-to-one association to ChatMessageRoom
	@ManyToOne
	@JoinColumn(name="CHAT_MESSAGE_ROOM_SQ")
	private ChatMessageRoom chatMessageRoom;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	public ChatMessage() {
	}

	public Long getChatMessageSq() {
		return this.chatMessageSq;
	}

	public void setChatMessageSq(Long chatMessageSq) {
		this.chatMessageSq = chatMessageSq;
	}

	public String getChatMessage() {
		return this.chatMessage;
	}

	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public ChatMessageRoom getChatMessageRoom() {
		return this.chatMessageRoom;
	}

	public void setChatMessageRoom(ChatMessageRoom chatMessageRoom) {
		this.chatMessageRoom = chatMessageRoom;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}