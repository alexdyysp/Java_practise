package domain;

public class Account {
    private int ga_id;
    private String category;
    private double money;
    private String account;
    private String createtime;
    private String description;
    public Account(){}//空参数构造
    public Account(int ga_id, String category, double money, String account, String createtime, String description) {//参数构造
        this.ga_id = ga_id;
        this.category = category;
        this.money = money;
        this.account = account;
        this.createtime = createtime;
        this.description = description;
    }

    public int getGa_id() {
        return ga_id;
    }

    public void setGa_id(int ga_id) {
        this.ga_id = ga_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
