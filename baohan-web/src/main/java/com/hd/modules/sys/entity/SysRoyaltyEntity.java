package com.hd.modules.sys.entity;

import javax.validation.constraints.NotNull;

/**
 * @author XA
 * @date 2019/7/2 0002 上午 9:34
 * @description 提成点数实体类
 * @params
 * @return
 */
public class SysRoyaltyEntity {
    private Integer id;
    @NotNull(message = "是否试用期不能为空！")
   private Integer isProbation;
    @NotNull(message = "职位信息不能为空！")
   private Integer positionId;
    @NotNull(message = "职位名称不能为空！")
   private String postionName;
    @NotNull(message = "利润阶梯分界不能为空！")
   private double threshold;
    @NotNull(message = "第一阶梯提成点数不能为空！")
   private double stepOne;
    @NotNull(message = "第二阶梯提成点数不能为空！")
   private double stepTwo;

   private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsProbation() {
        return isProbation;
    }

    public void setIsProbation(Integer isProbation) {
        this.isProbation = isProbation;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPostionName() {
        return postionName;
    }

    public void setPostionName(String postionName) {
        this.postionName = postionName;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getStepOne() {
        return stepOne;
    }

    public void setStepOne(double stepOne) {
        this.stepOne = stepOne;
    }

    public double getStepTwo() {
        return stepTwo;
    }

    public void setStepTwo(double stepTwo) {
        this.stepTwo = stepTwo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SysRoyaltyEntity{" +
                "id=" + id +
                ", isProbation=" + isProbation +
                ", positionId=" + positionId +
                ", postionName='" + postionName + '\'' +
                ", threshold=" + threshold +
                ", stepOne=" + stepOne +
                ", stepTwo=" + stepTwo +
                ", remark='" + remark + '\'' +
                '}';
    }
}
