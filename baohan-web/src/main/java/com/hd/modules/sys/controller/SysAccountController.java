package com.hd.modules.sys.controller;

import com.hd.common.utils.R;
import com.hd.modules.sys.entity.SysAccountEntity;
import com.hd.modules.sys.service.SysAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/3 0003 下午 14:32
 * @description 会计科目控制类
 * @params
 * @return
 */
@RestController
@RequestMapping("/sys/account")
public class SysAccountController {

    @Autowired
    private SysAccountService sysAccountService;

    @RequestMapping("/getPageData")
    public List<SysAccountEntity> getPageData(){
        return sysAccountService.getPageData();
    }

    @RequestMapping("/accountAdd")
    public R accountAdd(@RequestBody SysAccountEntity sysAccountEntity){
        sysAccountService.accountAdd(sysAccountEntity);
        return  R.ok("会计科目新增完成！");
    }

    @RequestMapping("/accountDelById")
    public R accountDelById(Integer accountId){
        sysAccountService.accountDelById(accountId);
        return R.ok("会计科目删除完成！");
    }

    @RequestMapping("accountEdit")
    public R accountEdit (@RequestBody SysAccountEntity sysAccountEntity){
        sysAccountService.accountEdit(sysAccountEntity);
        return R.ok();
    }

    @RequestMapping("/accountSec")
    public List<SysAccountEntity> accountSec(String name){
        return sysAccountService.accountSec(name);
    }
}
