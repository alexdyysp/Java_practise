package dao;

import org.apache.commons.dbutils.QueryRunner;
import tools.JDBCUtils;
import domain.Account;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

/*
实现对数据集gjp_account数据增删改查
创建QueryRunner,指定数据源
 */
public class AccountDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    public List<Account> selectAll(){
        //查询账户全部数据
        try {
            String sql = "SELECT * FROM gjp_accounting";
            List<Account> list_return = qr.query(sql, new BeanListHandler<>(Account.class));
            return list_return;
        } catch(SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("查询所有账务失败");
        }
    }
    public List<Account> select(String startDate,String endDate){
        //按条件查询
        try {
            String sql = "SELECT * FROM gjp_accounting WHERE createtime BETWEEN ? AND ? ";
            Object[] params = {startDate, endDate};
            return qr.query(sql, new BeanListHandler<>(Account.class), params);
        }catch (SQLException ex){
            System.out.print(ex);
            throw new RuntimeException("条件查询失败");
        }
    }
    public void AddAccount(Account ac) {
        //添加更新
        try {
            String sql = "INSERT INTO gjp_accounting (category,money,account,createtime,description)VALUES(?,?,?,?,?)";
            Object[] params = { ac.getCategory(), ac.getMoney(), ac.getAccount(), ac.getCreatetime(), ac.getDescription()};
            qr.update(sql, params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("更新添加失败");
        }
    }
    public void EditAccount(Account ac){
        try {
            String sql = "UPDATE gjp_accounting SET category=?,money=?,account=?,createtime=?,description=? WHERE ga_id=?";
            Object[] params = {ac.getCategory(), ac.getMoney(), ac.getAccount(), ac.getCreatetime(), ac.getDescription(), ac.getGa_id()};
            qr.update(sql, params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("更新编辑失败");
        }
    }

    public void DeleteAccount(int ga_id) {
        try {
            String sql = "DELETE FROM gjp_accounting where ga_id = ?";
            qr.update(sql, ga_id);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除失败");
        }
    }
}
