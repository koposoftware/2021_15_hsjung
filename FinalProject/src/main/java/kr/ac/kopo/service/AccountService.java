package kr.ac.kopo.service;

import com.javamodeling.common.ResultPojoList;

import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.Member;

public interface AccountService {
	
	public ResultPojoList obtainAccountByMember(Member member);

	public Account obtainMemberAccount(Member member);


}
