package com.critc.cri.service;

import com.critc.cri.dao.ExistingProjectDao;
import com.critc.cri.dao.PeopleDao;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.model.People;
import com.critc.cri.vo.ExistingProjectSearchVO;
import com.critc.sys.model.SysRole;
import com.critc.sys.vo.SysRoleSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统用户管理Service
 *
 * @author 孔垂云
 * @date 2017-06-13
 */
@Service
public class ExistingProjectService {
    @Autowired
    private ExistingProjectDao existingProjectsDao;

    public ExistingProject get(int id) {
        return existingProjectsDao.get(id);
    }


    /**
     * what: 获取列表
     *
     * @param existingProjectSearchVO 角色查询VO
     * @return 查询的list
     * @author 李红 created on 2017年11月6日
     */
    public List<ExistingProject> list(ExistingProjectSearchVO existingProjectSearchVO) {
        return existingProjectsDao.list(existingProjectSearchVO);
    }


    /**
     * what: 角色列表总数
     *
     * @param existingProjectSearchVO 角色查询VO
     * @return 角色列表总数
     * @author 孔垂云 created on 2017年11月6日
     */
    public int count(ExistingProjectSearchVO existingProjectSearchVO) {
        return existingProjectsDao.count(existingProjectSearchVO);
    }
}
