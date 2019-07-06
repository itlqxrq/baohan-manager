package com.hd.modules.sys.service;

import com.hd.modules.sys.entity.SysPostionEntity;

import java.util.List;

/**
 * @author XA
 * @date 2019/6/28 0028 上午 9:33
 * @description 职位信息
 * @params
 * @return
 */
public interface SysPostionService {
    /**保存职位信息*/
    void savePostion(SysPostionEntity sysPostionEntity);

    /**删除职位信息*/
    void deletePostionById(Integer postionId);

    /**修改职位信息*/
    void editPostion(SysPostionEntity sysPostionEntity);

    /**根据职位名称查找职位详情*/
    SysPostionEntity queryPostionByName(String name);

    /**根据职位编码查找职位详情*/
    SysPostionEntity queryPostionByCode(String name);

    /**根据职位所属部门查找职位详情*/
    List<SysPostionEntity> queryPostionByDeptId(int deptId);

    /**根据pageIndex获取职位信息*/
    List<SysPostionEntity> getPostionPage(Integer pageIndex, Integer limit);

    /**复合查询职位信息*/
    List<SysPostionEntity> postionSearch(String name, String code, String deptName);
}
