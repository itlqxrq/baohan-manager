package com.hd.modules.frontcabinet.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManIfest {
    private int id;

    private String orderNo;

    private int orderMainId;

    private int cusId;

    private String cusCode;

    private String cusName;

    private int groupId;

    private String userCode;

    private String cargoSource;

    private String  cargoState;

    private int  cargoNum;

    private String cargoLable;

    private String fileKeyListStr;

    private int orderState;

    private String action;

    private String storgeLocation;

    private int isWarehouseRead;

    private String addRemark;

    private String serviceItem;

    private int serviceNum;

    private int serviceCharge;

    private String relationRemark;

    private String confirmRemark;

    private String auditRemark;

    private String problemDesc;

    private String returnInfo;

    private String returnOrderNo;

    private int returnCharge;

    private int createUserId;

    private Date createTime;

    private Date confirmTime;

    private Date arrivedTime;

    private Date updateTime;

}
