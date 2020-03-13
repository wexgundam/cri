package com.critc.cri.service;

import com.critc.cri.dao.ExistingProjectDao;
import com.critc.cri.dao.RailwayInformationSystemDao;
import com.critc.cri.dao.RiopiDao;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.model.RailwayInformationSystem;
import com.critc.cri.model.Riopi;
import com.critc.cri.vo.ExistingProjectSearchVO;
import com.critc.cri.vo.RailwayInformationSystemSearchVO;
import com.critc.sys.model.SysDepartment;
import com.critc.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.resources.cldr.lg.FormatData_lg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExistingProjectService {
    @Autowired
    private ExistingProjectDao existingProjectsDao;

    @Autowired
    private RailwayInformationSystemService railwayInformationSystemService;

    @Autowired
    private RailwayInformationSystemDao railwayInformationSystemDao;

    @Autowired
    private RiopiService riopiService;
    /**
     * what:根据id获取对象
     * @param : id 部门id
     * @return: 根据id查询的部门对象
     * @Description : 
     * @author 卢薪竹 created by 17:04 2019/9/20
    */
    public ExistingProject get(int id) {
        return existingProjectsDao.getData(id);
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
    /**
     *
     * what: 生成Ztree的树节点,新增机构时使用
     *
     * @return Ztree
     *
     * @author rs  created on 2017年10月30日
     */
    public String createZtreeByModule() {
        // 信息化名称列表
        List<RailwayInformationSystem> list = railwayInformationSystemService.list();
        List<Riopi> riopilist = riopiService.list();

        List<Riopi> listModule = new ArrayList<>();

        for(RailwayInformationSystem railwayInformationSystem:list){
           Riopi riopi = new Riopi();
           riopi.setId(railwayInformationSystem.getId());
           riopi.setParentId(railwayInformationSystem.getRIOPI_ID());
           riopi.setName(railwayInformationSystem.getName());
            listModule.add(riopi);
        }
        for(Riopi riopi:riopilist){
            riopi.setId(riopi.getId());
            riopi.setParentId(riopi.getParentId());
            riopi.setName(riopi.getName());
            listModule.add(riopi);
        }
        StringBuilder sb = new StringBuilder();
        for (Riopi riopiModule : listModule) {
            sb.append("{id : \"" + riopiModule.getId() + "\",pId :\"" + riopiModule.getParentId() + "\",name :\""
                    + riopiModule.getName() + "\",open : false");
            sb.append("},");
        }
        return StringUtil.subTract(sb.toString());
    }
    //导入数据
    public Map<String, String> importData(int no, int riopiId, String riopiName) {

        ExistingProject existingProject  = get(no);
        RailwayInformationSystem railwayInformationSystem  = new RailwayInformationSystem();
        railwayInformationSystem.setName(existingProject.getName());
        railwayInformationSystem.setRIOPI_ID(riopiId);
        railwayInformationSystem.setRIOPI_NAME(riopiName);
        railwayInformationSystem.setORDER_INDEX(11);
        railwayInformationSystem.setCREATOR_ID(existingProject.getCreatorId());
        railwayInformationSystem.setCREATOR_REAL_NAME(existingProject.getCreatorRealName());
        railwayInformationSystem.setLAST_EDITOR_ID(existingProject.getLastEditorId());
        railwayInformationSystem.setPROJECT_TYPE_CODE(existingProject.getProjectTypeCode());
        railwayInformationSystem.setPROJECT_TYPE_NAME(existingProject.getProjectTypeName());
        railwayInformationSystem.setPROJECT_PROGRESS_CODE(existingProject.getProjectProgressCode());
        railwayInformationSystem.setPROJECT_PROGRESS_NAME(existingProject.getProjectProgressName());
        railwayInformationSystem.setREVIEW_PASSED_DAR(existingProject.getReviewPassedDar());
        railwayInformationSystem.setREVIEW_PASSED_CPC(existingProject.getReviewPassedCpc());
        railwayInformationSystem.setREVIEW_PASSED_TTS(existingProject.getReviewPassedTts());
        railwayInformationSystem.setREVIEW_PASSED_FSR(existingProject.getReviewPassedFsr());
        railwayInformationSystem.setCONSTRUCTION_DEPARTMENT_ID(existingProject.getConstructionDepartmentId());
        railwayInformationSystem.setCONSTRUCTION_DEPARTMENT_NAME(existingProject.getConstructionDepartmentName());

        int flag = 0;
        int riopi_id = 0;
        int count = railwayInformationSystemDao.getNameNum(railwayInformationSystem);
        if (count > 0) {
            flag = 2;
        } else {
            // 插入并返回主键
            riopi_id= railwayInformationSystemDao.addForId(railwayInformationSystem);
            flag = 1;
        }
        //更新既有信息系统riopi_id

        existingProject.setRisId(riopi_id);
        existingProjectsDao.update(existingProject);

       // map存放要放回的数据
        Map<String,String> map = new HashMap<>();
        map.put("flag",Integer.toString(flag));

        return map;
    }

    //
    //更新数据
    public int updateData(int no, int riopiId, String riopiName) {

        int flag = 0;
        ExistingProject existingProject = existingProjectsDao.getData(no);
        existingProject.setId(no);
        existingProject.setRisId(riopiId);
        existingProject.setRisName(riopiName);
        flag = existingProjectsDao.update(existingProject);
        return flag;

    }
}
