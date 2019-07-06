/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.hd;

import com.hd.modules.sys.entity.SysPostionEntity;
import com.hd.modules.sys.service.SysPostionService;
import com.hd.service.DynamicDataSourceTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    private DynamicDataSourceTestService dynamicDataSourceTestService;

    @Autowired
    private SysPostionService sysPostionService;

    @Test
    public void test(){
        SysPostionEntity sysPostionEntity = new SysPostionEntity();
        sysPostionEntity.setId(2);
        sysPostionEntity.setCode("ZW002");
        sysPostionEntity.setName("测试工程师");
        sysPostionEntity.setDeptId(1);
        /**新增*/
//        sysPostionService.savePostion(sysPostionEntity);
        /**删除*/
//        sysPostionService.deletePositionById(1);
        /**修改*/
//        sysPostionService.editPosition(sysPostionEntity);
        /**根据名称、编码、所属部门ID查询数据*/
        SysPostionEntity sysPostionEntity1 = sysPostionService.queryPostionByName("测试工程师");
        SysPostionEntity sysPostionEntity2 = sysPostionService.queryPostionByCode("ZW001");
        List<SysPostionEntity> sysPostionEntity3 = sysPostionService.queryPostionByDeptId(1);
    }

}
