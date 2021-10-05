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
import javax.persistence.Table;

import com.javamodeling.common.CommonPojo;
import com.javamodeling.common.ResultValue;


/**
 * The persistent class for the CHAT_MESSAGE_ROOM_JOIN database table.
 * 
 */
@Entity
@Table(name="CHAT_MESSAGE_ROOM_JOIN")
public class ChatMessageRoomJoin extends CommonPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="CHAT_MESSAGE_ROOM_JOIN_PK")
	private Long chatMessageRoomJoinPk;

	//bi-directional many-to-one association to ChatMessageRoom
	@ManyToOne
	@JoinColumn(name="CHAT_MESSAGE_ROOM_SQ")
	private ChatMessageRoom chatMessageRoom;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MEMBER_SQ")
	private Member member;

	public ChatMessageRoomJoin() {
	}

	public Long getChatMessageRoomJoinPk() {
		return this.chatMessageRoomJoinPk;
	}

	public void setChatMessageRoomJoinPk(Long chatMessageRoomJoinPk) {
		this.chatMessageRoomJoinPk = chatMessageRoomJoinPk;
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