package com.critc.cri.service;

import com.critc.cri.dao.ProjectDao;
import com.critc.cri.model.Project;
import com.critc.cri.vo.ProjectSearchVO;
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
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    /**
     *
     * what: 新增
     *
     * @param
     * @return flag 0、失败，1、成功，2、名称已经存在
     *
     * @author  rs created on 2019年08月28日
     */
    public int add(Project project) {
        int flag = 0;
        int count = projectDao.getNameNum(project);
        if (count > 0) {
            flag = 2;
        }
        else {
            projectDao.add(project);
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
    public int update(Project project) {
        int flag = 0;
        int count = projectDao.getNameNum(project);
        if (count > 0) {
            flag = 2;
        }
        else {
            projectDao.update(project);
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
            return projectDao.delete(id);

    }
    public Project get(int id) {
        return projectDao.get(id);
    }

    /**
     *
     * what: 系统列表
     *
     * @return 结果集list
     *
     * @author  rs created on 2019年08月28日
     */
    public List<Project> list(ProjectSearchVO projectSearchVO) {
        // 获取数据集
        List<Project> list = projectDao.list(projectSearchVO);

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
    public int count(ProjectSearchVO projectSearchVO) {
        return projectDao.count(projectSearchVO);
    }
    //  获取信息化总体规划目录和铁路信息系统目录

    public List<Project> list() {
        // 获取数据集
        List<Project> list = projectDao.list();

        return list;
    }


}
