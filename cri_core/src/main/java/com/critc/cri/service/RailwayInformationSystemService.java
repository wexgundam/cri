package com.critc.cri.service;

import com.critc.cri.dao.RailwayInformationSystemDao;
import com.critc.cri.model.RailwayInformationSystem;
import com.critc.cri.vo.RailwayInformationSystemSearchVO;
import com.critc.util.model.ComboboxVO;
import com.critc.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信息系统Service
 *
 * @author rs
 * @date 2019-08-27
 */
@Service
public class RailwayInformationSystemService {
    @Autowired
    private RailwayInformationSystemDao railwayInformationSystemDao;

    /**
     *
     * what: 新增
     *
     * @param railwayInformationSystem
     * @return flag 0、失败，1、成功，2、名称已经存在
     *
     * @author  rs created on 2019年08月28日
     */
    public int add(RailwayInformationSystem railwayInformationSystem) {
        int flag = 0;
        int count = railwayInformationSystemDao.getNameNum(railwayInformationSystem);
        if (count > 0) {
            flag = 2;
        }
        else {
            railwayInformationSystemDao.add(railwayInformationSystem);
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
    public int update(RailwayInformationSystem railwayInformationSystem) {
        int flag = 0;
        int count = railwayInformationSystemDao.getNameNum(railwayInformationSystem);
        if (count > 0) {
            flag = 2;
        }
        else {
            railwayInformationSystemDao.update(railwayInformationSystem);
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
            return railwayInformationSystemDao.delete(id);

    }
    public RailwayInformationSystem get(int id) {
        return railwayInformationSystemDao.get(id);
    }

    /**
     *
     * what: 系统列表
     *
     * @return 结果集list
     *
     * @author  rs created on 2019年08月28日
     */
    public List<RailwayInformationSystem> list(RailwayInformationSystemSearchVO railwayInformationSystemSearchVO) {
        // 获取数据集
        List<RailwayInformationSystem> list = railwayInformationSystemDao.list(railwayInformationSystemSearchVO);

        return list;
    }
    /**
     * what: 系统列表总数
     *
     * @param
     *
     * @return 系统列表总数
     *
     * @author rs created on 2019年9月4日
     */
    public int count(RailwayInformationSystemSearchVO railwayInformationSystemSearchVO) {
        return railwayInformationSystemDao.count(railwayInformationSystemSearchVO);
    }
    //  获取信息化总体规划目录和铁路信息系统目录

    public List<RailwayInformationSystem> list() {
        // 获取数据集
        List<RailwayInformationSystem> list = railwayInformationSystemDao.list();

        return list;
    }


}
