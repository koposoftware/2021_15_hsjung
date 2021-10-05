package kr.ac.kopo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the CHAT_MESSAGE_ROOM database table.
 * 
 */
@Entity
@Table(name="CHAT_MESSAGE_ROOM")
public class ChatMessageRoom extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="CHAT_MESSAGE_ROOM_SQ")
	private Long chatMessageRoomSq;

	@Column(name="INPUT_DATE")
	private String inputDate;

	@Column(name="IS_AUCTION")
	private String isAuction;

	@Column(name="PRODUCT_SQ")
	private Long productSq;

	//bi-directional many-to-one association to ChatMessage
	@OneToMany(mappedBy="chatMessageRoom")
	private List<ChatMessage> chatMessages;

	//bi-directional many-to-one association to ChatMessageRoomJoin
	@OneToMany(mappedBy="chatMessageRoom")
	private List<ChatMessageRoomJoin> chatMessageRoomJoins;

	public ChatMessageRoom() {
	}

	public Long getChatMessageRoomSq() {
		return this.chatMessageRoomSq;
	}

	public void setChatMessageRoomSq(Long chatMessageRoomSq) {
		this.chatMessageRoomSq = chatMessageRoomSq;
	}

	public String getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getIsAuction() {
		return this.isAuction;
	}

	public void setIsAuction(String isAuction) {
		this.isAuction = isAuction;
	}

	public Long getProductSq() {
		return this.productSq;
	}

	public void setProductSq(Long productSq) {
		this.productSq = productSq;
	}

	public List<ChatMessage> getChatMessages() {
		return this.chatMessages;
	}

	public void setChatMessages(List<ChatMessage> chatMessages) {
		this.chatMessages = chatMessages;
	}

	public ChatMessage addChatMessage(ChatMessage chatMessage) {
		getChatMessages().add(chatMessage);
		chatMessage.setChatMessageRoom(this);

		return chatMessage;
	}

	public ChatMessage removeChatMessage(ChatMessage chatMessage) {
		getChatMessages().remove(chatMessage);
		chatMessage.setChatMessageRoom(null);

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
		chatMessageRoomJoin.setChatMessageRoom(this);

		return chatMessageRoomJoin;
	}

	public ChatMessageRoomJoin removeChatMessageRoomJoin(ChatMessageRoomJoin chatMessageRoomJoin) {
		getChatMessageRoomJoins().remove(chatMessageRoomJoin);
		chatMessageRoomJoin.setChatMessageRoom(null);

		return chatMessageRoomJoin;
	}

}