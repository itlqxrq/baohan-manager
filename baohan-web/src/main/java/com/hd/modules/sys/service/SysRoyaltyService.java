package com.hd.modules.sys.service;

import com.hd.modules.sys.entity.SysRoyaltyEntity;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/2 0002 上午 10:03
 * @description 提成点数业务接口
 * @params
 * @return
 */
public interface SysRoyaltyService {

    void royaltyAdd(SysRoyaltyEntity sysRoyaltyEntity);

    void royaltyDelById(Integer royaltyId);

    void royaltyEdit(SysRoyaltyEntity sysRoyaltyEntity);

    List<SysRoyaltyEntity> royaltySec(SysRoyaltyEntity sysRoyaltyEntity);

    List<SysRoyaltyEntity> getPageData(Integer pageIndex, Integer limit);
}
