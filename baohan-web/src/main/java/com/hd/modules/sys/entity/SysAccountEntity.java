package com.hd.modules.sys.entity;
/**
 * @author XA
 * @date 2019/7/3 0003 下午 13:48
 * @description 会计科目实体类
 * @params
 * @return
 */
public class SysAccountEntity {
    private Integer id;
    private String code;
    private String name;
    private Integer parentId;
    private String parentName;
    private String remark;
    private Integer isOpen;
    private Integer isInProfit;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer idOpen) {
        this.isOpen = idOpen;
    }

    public Integer getIsInProfit() {
        return isInProfit;
    }

    public void setIsInProfit(Integer isInProfit) {
        this.isInProfit = isInProfit;
    }

    @Override
    public String toString() {
        return "SysAccountEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", remark='" + remark + '\'' +
                ", idOpen=" + isOpen +
                ", isInProfit=" + isInProfit +
                '}';
    }
}
