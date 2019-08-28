package com.critc.cri.service;

import com.critc.cri.dao.SystemInfoDao;
import com.critc.cri.model.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息系统Service
 *
 * @author rs
 * @date 2019-08-27
 */
@Service
public class SystemInfoService {
    @Autowired
    private SystemInfoDao systemInfoDao;

    /**
     *
     * what: 新增
     *
     * @param systemInfo
     * @return flag 0、失败，1、成功，2、名称已经存在
     *
     * @author  rs created on 2019年08月28日
     */
    public int add(SystemInfo systemInfo) {
        int flag = 0;
        int count =0;
    //    int count = systemInfoDao.getNameNum(systemInfo);
        if (count > 0) {
            flag = 2;
        }
        else {
            systemInfoDao.add(systemInfo);
            flag = 1;
        }
        return flag;
    }

    /**
     *
     * what: 修改
     *
     * @param
     * @return flag 0、失败，1、成功，2、名称已经存在
     *
     * @author  rs created on 2019年08月28日
     */
    public int update(SystemInfo systemInfo) {
        int flag = 0;
        int count =0;
      //  int count = systemInfoDao.getNameNum(systemInfo);
        if (count > 0) {
            flag = 2;
        }
        else {
            systemInfoDao.update(systemInfo);
            flag = 1;
        }
        return flag;
    }

    /**
     *
     * what: 删除
     *
     * @param id 部门id
     * @return 删除结果 1、删除成功  2、失败
     *
     * @author  rs created on 2019年08月28日
     */
    public int delete(int id) {
            return systemInfoDao.delete(id);

    }
    public SystemInfo get(int id) {
        return systemInfoDao.get(id);
    }

    /**
     *
     * what: 系统列表
     *
     * @return 结果集list
     *
     * @author  rs created on 2019年08月28日
     */
    public List<SystemInfo> list() {
        // 获取数据集
        List<SystemInfo> list = systemInfoDao.list();

        return list;
    }
}
