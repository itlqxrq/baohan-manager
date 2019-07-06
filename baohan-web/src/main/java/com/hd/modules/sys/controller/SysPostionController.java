package com.hd.modules.sys.controller;

import com.hd.common.utils.R;
import com.hd.modules.sys.entity.SysPostionEntity;
import com.hd.modules.sys.service.SysPostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XA
 * @date 2019/6/28 0028 上午 10:00
 * @description 职位信息控制类
 * @params
 * @return
 */
@RestController
@RequestMapping("sys/position")
public class SysPostionController {

    @Autowired
    private SysPostionService sysPostionService;

    @RequestMapping("/getPostionPage")
    public List<SysPostionEntity> getPostionPage(Integer pageIndex, Integer limit){
        return sysPostionService.getPostionPage(pageIndex,limit);
    }

    @RequestMapping("/savePostion")
    public R savePostion(@RequestBody SysPostionEntity sysPostionEntity){
        sysPostionService.savePostion(sysPostionEntity);
        return R.ok("职位信息写入成功！");
    }

    @RequestMapping("/deletePostionById")
    public R deletePostionById(Integer postionId){
        sysPostionService.deletePostionById(postionId);
        return R.ok("职位信息删除成功！");
    }

    @RequestMapping("/editPostion")
    public R editPostion(@RequestBody SysPostionEntity sysPostionEntity){
        sysPostionService.editPostion(sysPostionEntity);
        return R.ok("职位信息修改成功！");
    }

    @RequestMapping("/postionSearch")
    public List<SysPostionEntity> postionSearch(String name, String code, String deptName){
        return sysPostionService.postionSearch(name,code,deptName);
    }

}
