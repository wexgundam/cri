package com.critc.cri.service;

import com.critc.cri.dao.MileStonesDao;
import com.critc.cri.model.MileStones;
import com.critc.cri.vo.MilestonesSearchVO;
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
public class MileStonesService {
    @Autowired
    private MileStonesDao mileStonesDao;

    /**
     *
     * what: 新增
     *
     * @param
     * @return flag 0、失败，1、成功，2、名称已经存在
     *
     * @author  rs created on 2019年08月28日
     */
    public int add(MileStones mileStones) {
        int flag = 0;
        int count = mileStonesDao.getNameNum(mileStones);
        if (count > 0) {
            flag = 2;
        }
        else {
            mileStonesDao.add(mileStones);
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
    public int update(MileStones mileStones) {
        int flag = 0;
        int count = mileStonesDao.getNameNum(mileStones);
        if (count > 0) {
            flag = 2;
        }
        else {
            mileStonesDao.update(mileStones);
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
            return mileStonesDao.delete(id);

    }
    public MileStones get(int id) {
        return mileStonesDao.get(id);
    }

    /**
     *
     * what: 系统列表
     *
     * @return 结果集list
     *
     * @author  rs created on 2019年08月28日
     */
    public List<MileStones> list(MilestonesSearchVO milestonesSearchVO) {
        // 获取数据集
        List<MileStones> list = mileStonesDao.list(milestonesSearchVO);

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
    public int count(MilestonesSearchVO milestonesSearchVO) {
        return mileStonesDao.count(milestonesSearchVO);
    }
    //  获取信息化总体规划目录和铁路信息系统目录

    public List<MileStones> list() {
        // 获取数据集
        List<MileStones> list = mileStonesDao.list();

        return list;
    }


}
