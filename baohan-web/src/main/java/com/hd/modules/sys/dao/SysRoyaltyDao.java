package com.hd.modules.sys.dao;

import com.hd.modules.sys.entity.SysRoyaltyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author XA
 * @date 2019/7/2 0002 上午 10:10
 * @description 提成点数Dao接口
 * @params
 * @return
 */
@Mapper
@Component
public interface SysRoyaltyDao {
    void royaltyAdd(SysRoyaltyEntity sysRoyaltyEntity);

    void royaltyDelById(Integer royaltyId);

    void royaltyEdit(SysRoyaltyEntity sysRoyaltyEntity);

    List<SysRoyaltyEntity> royaltySec(SysRoyaltyEntity sysRoyaltyEntity);

    List<SysRoyaltyEntity> getPageData(Integer start, Integer limit);
}
