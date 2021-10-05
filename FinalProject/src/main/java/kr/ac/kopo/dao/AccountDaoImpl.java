package kr.ac.kopo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.javamodeling.component.DaoInterface;
import com.javamodeling.dao.JPADaoSupport;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductImg;

@Repository
public class AccountDaoImpl extends JPADaoSupport implements AccountDao {

	@Override
	public List<Account> obtainAccountByMember(Member member) {
		
		String sql ="SELECT a FROM Account as a WHERE a.member.memberSq = :member";

		TypedQuery<Account> query = entityManager.createQuery(sql, Account.class);
		
		query.setParameter("member", member.getMemberSq());
		
		return query.getResultList();
			
	}

	@Override
	public History obtainHistoryByAccount(Account account) {
		
		String sql ="SELECT a FROM History as a JOIN FETCH a.account as b WHERE a.accountSq = :account";

		TypedQuery<History> query = entityManager.createQuery(sql, History.class);
		
		query.setParameter("account", account.getAccountSq());
		
		return query.getSingleResult();
	}

	@Override
	public Account obtainMemberAccount(Member member) {
		
		String sql ="SELECT a FROM Account as a WHERE a.accountSq = :account";

		TypedQuery<Account> query = entityManager.createQuery(sql, Account.class);
		
		query.setParameter("account", member.getMemberMainAccount());
		
		return query.getSingleResult();
	}




}
