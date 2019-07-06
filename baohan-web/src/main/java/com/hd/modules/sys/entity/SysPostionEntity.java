package com.hd.modules.sys.entity;

/*
 * @author XA
 * @date 2019/6/28 0028 上午 9:34
 * @description 职位信息实体类
 * @params
 * @return
 */
public class SysPostionEntity {
    private int id;
    private String code;
    private String name;
    private int deptId;
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public SysPostionEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
