package controller;
/*
控制层类定义方法，实现查询所有账务数据
 */
import domain.Account;
import service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService service = new AccountService();

    public List<Account> selectAll(){
        return service.selectAll();
    }
    public List<Account> select(String startDate,String endDate){
        return service.select(startDate,endDate);
    }
    public void AddAccount(Account ac){
        service.AddAccount(ac);
    }
    public void EditAccount(Account ac){
        service.EditAccount(ac);
    }

    public void DeleteAccount(int ga_id) {
        service.DeleteAccount(ga_id);
    }
}
