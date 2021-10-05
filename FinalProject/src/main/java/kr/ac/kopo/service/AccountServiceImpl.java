package kr.ac.kopo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamodeling.common.Pagination;
import com.javamodeling.common.ResultPojoList;

import kr.ac.kopo.dao.AccountDao;
import kr.ac.kopo.dao.MemberDao;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.Member;

@Service
@Transactional
public class AccountServiceImpl extends ServiceSupport implements AccountService {

	@Autowired
	private AccountDao accountdao;

	@Override
	public ResultPojoList obtainAccountByMember(Member member) {

		ResultPojoList accountResult = new ResultPojoList();
		
		accountResult.setList(accountdao.obtainAccountByMember(member));
		
		return accountResult;
	}

	@Override
	public Account obtainMemberAccount(Member member) {
		
		Account accountResult = new Account();
		
		accountResult = accountdao.obtainMemberAccount(member);
		
		
		return accountResult;
	}



}
