package com.critc.cri.service;

import com.critc.cri.dao.ActionDao;
import com.critc.cri.model.Action;
import com.critc.cri.vo.ActionSearchVO;
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
public class ActionService {
    @Autowired
    private ActionDao actionDao;

    /**
     *
     * what: 新增
     *
     * @param
     * @return flag 0、失败，1、成功，2、名称已经存在
     *
     * @author  rs created on 2019年08月28日
     */
    public int add(Action action) {
        int flag = 0;
        int count = actionDao.getNameNum(action);
        if (count > 0) {
            flag = 2;
        }
        else {
            actionDao.add(action);
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
    public int update(Action action) {
        int flag = 0;
        int count = actionDao.getNameNum(action);
        if (count > 0) {
            flag = 2;
        }
        else {
            actionDao.update(action);
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
            return actionDao.delete(id);

    }
    public Action get(int id) {
        return actionDao.get(id);
    }

    /**
     *
     * what: 系统列表
     *
     * @return 结果集list
     *
     * @author  rs created on 2019年08月28日
     */
    public List<Action> list(ActionSearchVO actionSearchVO) {
        // 获取数据集
        List<Action> list = actionDao.list(actionSearchVO);

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
    public int count(ActionSearchVO actionSearchVO) {
        return actionDao.count(actionSearchVO);
    }
    //  获取信息化总体规划目录和铁路信息系统目录

    public List<Action> list() {
        // 获取数据集
        List<Action> list = actionDao.list();

        return list;
    }


}
