package com.critc.cri.service;

import com.critc.cri.dao.ExistingProjectDao;
import com.critc.cri.dao.RailwayInformationSystemDao;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.model.RailwayInformationSystem;
import com.critc.cri.model.Riopi;
import com.critc.cri.vo.ExistingProjectSearchVO;
import com.critc.cri.vo.RailwayInformationSystemSearchVO;
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
     * @author
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
     * @param
     * @param
     * @param
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
     * @author
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
//    /**
//     * what: 生成Ztree的树节点,新增机构时使用
//     */
//    public String createZtreeByModule() {
//        // 机构列表
//        List<ExistingProject> listModule = existingProjectsDao.list();
//        //List<SysDepartment> listModule = sysDepartmentDao.list();
//        StringBuilder sb = new StringBuilder();
//        for (ExistingProject existingModule: listModule) {
//            sb.append("{id : \"" + existingModule.getId() + "\",pId :\"" + existingModule.getParentId() + "\",name :\""
//                    + existingModule.getName() + "\",open : false");
//            sb.append("},");
//        }
//        return StringUtil.subTract(sb.toString());
//    }
}
