package cn.edu.scujcc.moneyapp.bean;

public class OutpayBean {
    private int id;
    private double money;
    private String time;
    private String type;
    private String payee;
    private String remark;

    public OutpayBean(int id, double money, String time, String type, String payee, String remark) {
        this.id = id;
        this.money = money;
        this.time = time;
        this.type = type;
        this.payee = payee;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlayer() {
        return payee;
    }

    public void setPlayer(String payee) { this.payee = payee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
