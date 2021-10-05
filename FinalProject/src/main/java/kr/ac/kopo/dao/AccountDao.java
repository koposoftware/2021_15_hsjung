package kr.ac.kopo.dao;

import java.util.List;

import com.javamodeling.common.Pagination;
import com.javamodeling.component.DaoInterface;

import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductImg;

public interface AccountDao extends DaoInterface {

	List<Account> obtainAccountByMember(Member member);

	History obtainHistoryByAccount(Account account);

	Account obtainMemberAccount(Member member);


}
