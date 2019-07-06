package com.hd.modules.frontcabinet.controller;
import com.hd.modules.frontcabinet.entity.ManIfest;
import com.hd.modules.frontcabinet.service.ReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @author xrq
 * @date 2019/7/5 15:41
 * 货物列表
 */
@RestController
@RequestMapping("frontcabinet/Goods")
public class GoodsController {

    @Autowired
    private ReceiptsService receiptsService;

    @RequestMapping("/getGoodsPage")
    public List<ManIfest> getGoodsPage(Integer pageIndex,Integer limit){
        System.out.println(pageIndex);
        return receiptsService.getGoodsPage(pageIndex,limit);
    }
}
