package com.hd.modules.sys.controller;

import com.hd.common.utils.R;
import com.hd.modules.sys.entity.SysRoyaltyEntity;
import com.hd.modules.sys.service.SysRoyaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XA
 * date 2019/7/2 0002 上午 11:09
 * description 提成点数控制类
 * params
 * return
 */
@RestController
@RequestMapping("/sys/royalty")
public class SysRoyaltyController {

    @Autowired
    private SysRoyaltyService sysRoyaltyService;

    @RequestMapping("/royaltyAdd")
    public R royaltyAdd(@RequestBody SysRoyaltyEntity sysRoyaltyEntity){
        sysRoyaltyService.royaltyAdd(sysRoyaltyEntity);
        return R.ok("提成点数数据写入成功！");
    }

    @RequestMapping("/royaltyDelById")
    public R royaltyDelById(Integer royaltyId){
        sysRoyaltyService.royaltyDelById(royaltyId);
        return R.ok("提成点数数据删除成功！");
    }

    @RequestMapping("/royaltyEdit")
    public R royaltyEdit(@RequestBody SysRoyaltyEntity sysRoyaltyEntity){
        sysRoyaltyService.royaltyEdit(sysRoyaltyEntity);
        return R.ok("提成点数数据修改成功！");
    }

    @RequestMapping("/royaltySec")
    public List<SysRoyaltyEntity> royaltySec(SysRoyaltyEntity sysRoyaltyEntity){
        return sysRoyaltyService.royaltySec(sysRoyaltyEntity);
    }

    @RequestMapping("/getPageData")
    public List<SysRoyaltyEntity> getPageData(Integer pageIndex,Integer limit){
        return sysRoyaltyService.getPageData(pageIndex,limit);
    }
}
