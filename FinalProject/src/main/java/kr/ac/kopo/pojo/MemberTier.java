package kr.ac.kopo.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEMBER_TIER database table.
 * 
 */
@Entity
@Table(name="MEMBER_TIER")
public class MemberTier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MemberTierSequenceGenerator")
	@SequenceGenerator(sequenceName = "MEMBER_TIER_SEQ", name = "MemberTierSequenceGenerator", allocationSize = 1)
	@Column(name="MEMBER_TIER_SQ")
	private Long memberTierSq;

	@Column(name="MEMBER_TIER")
	private String memberTier;

	@Column(name="MEMBER_TIER_SCORE")
	private Long memberTierScore;

	//bi-directional one-to-one association to MemberInf
	@OneToMany(mappedBy="member")
	private List<MemberInfo> member;

	public MemberTier() {
	}

	public Long getMemberTierSq() {
		return memberTierSq;
	}

	public void setMemberTierSq(Long memberTierSq) {
		this.memberTierSq = memberTierSq;
	}

	public String getMemberTier() {
		return memberTier;
	}

	public void setMemberTier(String memberTier) {
		this.memberTier = memberTier;
	}

	public Long getMemberTierScore() {
		return memberTierScore;
	}

	public void setMemberTierScore(Long memberTierScore) {
		this.memberTierScore = memberTierScore;
	}

	public List<MemberInfo> getMember() {
		return member;
	}

	public void setMember(List<MemberInfo> member) {
		this.member = member;
	}






}