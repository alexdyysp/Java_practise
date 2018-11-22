package view;

import controller.AccountController;
import domain.Account;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private AccountController controller = new AccountController();
    public void run(){
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        while (flag) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            int op = in.nextInt();
            switch (op) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    EditAccount();
                    break;
                case 3:
                    DeleteAccount();
                    break;
                case 4:
                    selectAccount();
                    break;
                case 5:
                    System.out.println("再见！");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }
    public void selectAccount() {
        System.out.println("1.查询所有　2.按条件查询");
        Scanner in = new Scanner(System.in);
        int op = in.nextInt();
        switch (op) {
            case 1:
                selectAll();//调用Controller层方法查询账务数据
                break;
            case 2:
                select();//按条件查询
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("输入错误！");
        }
    }
    public void selectAll(){
        //run controller method,query all data
        List<Account> list = controller.selectAll();
        if(list.size() != 0)
            printDataTable(list);
        else
            System.out.print("no data found");
    }
    public void select(){//调用控制层方法，传递日期，获取结果
        Scanner sc = new Scanner(System.in);
        System.out.println("选择条件查询请输入日期：");
        System.out.print("请输入日期：");
        String startDate = sc.nextLine();
        System.out.print("请输入结果日期：");
        String endDate = sc.nextLine();
        List<Account> list = controller.select(startDate, endDate);
        if(list.size() != 0)
            printDataTable(list);
        else
            System.out.print("no data found");
    }
    public void addAccount(){
        System.out.println("选择添加账户功能");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入分类名称");
        String category = sc.next();
        System.out.println("输入金额名称");
        double money = sc.nextDouble();
        System.out.println("输入账户名称");
        String account = sc.next();
        System.out.println("输入日期xxxx-xx-xx:");
        String createtime = sc.next();
        System.out.println("输入说明描述");
        String description = sc.next();
        //controller.AddAccount(sc);
        Account ac = new Account(0, category, money, account, createtime, description);
        controller.AddAccount(ac);
        System.out.print("添加更新成功");
    }
    public void EditAccount(){
        //调用SelectAll()，将数据显示出来，方便用户选择修改
        selectAll();
        System.out.println("选择编辑功能，请编辑：");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入ID:");
        int ga_id = sc.nextInt();
        System.out.println("输入分类名称");
        String category = sc.next();
        System.out.println("输入金额名称");
        double money = sc.nextDouble();
        System.out.println("输入账户名称");
        String account = sc.next();
        System.out.println("输入日期xxxx-xx-xx:");
        String createtime = sc.next();
        System.out.println("输入说明描述");
        String description = sc.next();
        //封装数据于Account对象中
        Account ac = new Account(ga_id,category,money,account,createtime,description);
        controller.EditAccount(ac);
    }
    public void DeleteAccount(){
        selectAll();
        System.out.println("选择删除功能：");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入ID:");
        int ga_id = sc.nextInt();
        controller.DeleteAccount(ga_id);
        System.out.println("删除完毕");
        selectAll();
    }
    private void printDataTable(List<Account> select) {
        //该方法用于打印数据
        List<Account> list = select;
        System.out.println("ID\t类别\t金额\t账户\t时间\t说明");//表头
        for (Account ac : list) {
            System.out.println(ac.getGa_id() + "\t" + ac.getCategory() + "\t" + ac.getMoney() + "\t"
                    + ac.getAccount() + "\t" + ac.getCreatetime() + "\t" + ac.getDescription());
        }
    }
}

