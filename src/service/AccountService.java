package service;

import dao.AccountDao;
import domain.Account;

import java.util.List;

/*
业务层类
接受上面控制层数据，
传递给Dao层类，操作数据库
 */
public class AccountService {
    private AccountDao dao = new AccountDao();
    public List<Account> selectAll() {
        return dao.selectAll();
    }
    public List<Account> select(String startDate,String endDate){
        return dao.select(startDate,endDate);
    }
    public void AddAccount(Account ac){
        dao.AddAccount(ac);
    }
    public void EditAccount(Account ac){
        dao.EditAccount(ac);
    }

    public void DeleteAccount(int ga_id) {
        dao.DeleteAccount(ga_id);
    }
}
