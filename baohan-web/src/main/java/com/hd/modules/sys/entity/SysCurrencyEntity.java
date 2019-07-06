package com.hd.modules.sys.entity;
/**
 * @author XA
 * @date 2019/7/4 0004 下午 14:11
 * @description 币别资料实体类
 * @params
 * @return
 */
public class SysCurrencyEntity {
    private Integer id;
    private String month;
    private String name;
    private String nameEn;
    private double rmbExchangeRate;
    private double usdExchangeRate;
    private double hkdExchangeRate;
    private String effectDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public double getRmbExchangeRate() {
        return rmbExchangeRate;
    }

    public void setRmbExchangeRate(double rmbExchangeRate) {
        this.rmbExchangeRate = rmbExchangeRate;
    }

    public double getUsdExchangeRate() {
        return usdExchangeRate;
    }

    public void setUsdExchangeRate(double usdExchangeRate) {
        this.usdExchangeRate = usdExchangeRate;
    }

    public double getHkdExchangeRate() {
        return hkdExchangeRate;
    }

    public void setHkdExchangeRate(double hkdExchangeRate) {
        this.hkdExchangeRate = hkdExchangeRate;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    @Override
    public String toString() {
        return "SysCurrencyEntity{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", name='" + name + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", rmbExchangeRate=" + rmbExchangeRate +
                ", usdExchangeRate=" + usdExchangeRate +
                ", hkdEcchangeRate=" + hkdExchangeRate +
                ", effectDate='" + effectDate + '\'' +
                '}';
    }
}
