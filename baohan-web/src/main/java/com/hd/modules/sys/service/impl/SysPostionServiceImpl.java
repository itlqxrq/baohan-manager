package com.hd.modules.sys.service.impl;

import com.hd.modules.sys.dao.SysPostionDao;
import com.hd.modules.sys.entity.SysPostionEntity;
import com.hd.modules.sys.service.SysPostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author XA
 * @date 2019/6/28 0028 上午 9:40
 * @description 职位信息业务实现类
 * @params
 * @return
 */
@Service
public class SysPostionServiceImpl implements SysPostionService {
    @Autowired
    private SysPostionDao sysPostionDao;
    @Override
    public void savePostion(SysPostionEntity sysPostionEntity) {
        sysPostionDao.savePostion(sysPostionEntity);
    }

    @Override
    public void deletePostionById(Integer positionId) {
        sysPostionDao.deletePostionById(positionId);
    }

    @Override
    public void editPostion(SysPostionEntity sysPostionEntity) {
        sysPostionDao.editPostion(sysPostionEntity);
    }

    @Override
    public SysPostionEntity queryPostionByName(String name) {
        return sysPostionDao.queryPostionByName(name);
    }

    @Override
    public SysPostionEntity queryPostionByCode(String code) {
        return sysPostionDao.queryPostionByCode(code);
    }

    @Override
    public List<SysPostionEntity> queryPostionByDeptId(int deptId) {
        return sysPostionDao.queryPostionByDeptId(deptId);
    }

    @Override
    public List<SysPostionEntity> getPostionPage(Integer pageIndex, Integer limit) {
        int start = 0;
        if(pageIndex > 1){
            start = (pageIndex-1)*10;
        }
        return sysPostionDao.getPostionPage(start,limit);
    }

    @Override
    public List<SysPostionEntity> postionSearch(String name, String code, String deptName) {
        return sysPostionDao.postionSearch(name,code,deptName);
    }
}
