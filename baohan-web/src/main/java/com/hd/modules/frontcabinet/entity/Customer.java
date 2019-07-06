package com.hd.modules.frontcabinet.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private int id;

    private int blongUserId;

    private int supportUserId;

    private String cusCode;

    private String cusName;

    private String userCode;

    private String simpleName;

    private String nameNe;

    private  int  type;

    private  int dealState;

    private int payMethodId;

    private int cardType;

    private String cardNum;

    private String tel;

    private String fax;

    private String website;

    private String partnet;

    private String address;

    private String fileKeyListStr;

    private int createUserId;

    private int updateUserId;

    private Date createTime;

    private Date updateTime;
}
