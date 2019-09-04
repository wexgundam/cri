package com.critc.cri.service;

import com.critc.cri.dao.ExistingProjectDao;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.vo.ExistingProjectSearchVO;

import com.critc.sys.model.SysRole;
import com.critc.util.cache.EhCacheUtil;
import com.critc.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    /**
     * what: 新增角色，同时新增对应的权限
     *
     * @param sysRole     sysRole
     * @param moduleArr   moduleArr
     * @param functionArr functionArr
     *
     * @return flag 0、失败，1、成功，2、角色名称已经存在
     *
     * @author
     */
    public int add(ExistingProject existingProject) {
        int flag = 0;
        int count = existingProjectsDao.getNameNum(existingProject);
        if (count > 0) {
            flag = 2;
        } else {
            existingProjectsDao.add(existingProject);
            flag = 1;
        }
        return flag;
    }
    /**
     * what: 修改角色，同时新增对应的权限
     * @param
     * @param
     * @param
     * @return flag 0、失败，1、成功，2、角色名称已经存在
     *
     * @author
     */
    public int update(ExistingProject existingProject) {
        int flag = 0;
        int count = existingProjectsDao.getNameNum(existingProject);
        if (count > 0) {
            flag = 2;
        } else {
            existingProjectsDao.update(existingProject);
            flag = 1;
        }
        return flag;
    }

    /**
     * what: 删除角色
     *
     * @param id 角色id
     *
     * @return flag 0、失败，1、成功，2、存在系统用户不能删除
     *
     * @author 孔垂云 created on 2017年11月6日
     */
    public int delete(int id) {
        int flag = 0;
        int count = existingProjectsDao.countExistingProjectNum(id);
        if (count > 0) {
            flag = existingProjectsDao.delete(id);
        }
        else{
            System.out.println("不存在既有信息系统");
        }
        return flag;
    }
}
