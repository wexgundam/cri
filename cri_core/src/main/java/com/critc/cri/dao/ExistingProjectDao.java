package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.vo.ExistingProjectSearchVO;
import com.critc.sys.model.SysDepartment;
import com.critc.sys.model.SysRole;
import com.critc.sys.vo.SysRoleSearchVO;
import com.critc.util.page.PageUtil;
import com.critc.util.string.StringUtil;
import org.springframework.stereotype.Repository;
import sun.util.resources.mt.CalendarData_mt;

import java.util.List;

/**
 * Created by 卢薪竹 on 2019/8/15.
 */
@Repository
public class ExistingProjectDao extends BaseDao<ExistingProject,ExistingProjectSearchVO> {
    /**
     * what: 按既有信息系统名称查询
     *
     * @param
     *
     * @return int
     * @author
     */
    public int getNameNum(ExistingProject existingProject) {
        String sql = "select count(*) from t_existing_project where name = ?";
        if (StringUtil.isNotNullOrEmpty(String.valueOf(existingProject.getId()))) {
            sql += " and id != ?";
        }
        Object[] objects = new Object[]{existingProject.getName(), existingProject.getId()};
        return count(sql, objects);
    }

    public int add(ExistingProject existingProject) {
        String sql = "insert into t_existing_project (id, " +
                "ris_id, " +
                "name," +
                "project_type_code," +
                "project_type_name," +
                "project_progress_code," +
                "project_progress_name," +
                "review_passed_dar," +
                "review_passed_cpc," +
                "review_passed_tts," +
                "review_passed_fsr," +
                "construction_department_id," +
                "construction_department_name," +
                "order_index," +
                "creator_id," +
                "creator_real_name," +
                "created_at," +
                "last_editor_id," +
                "last_editor_real_name," +
                "last_edited_at, "+
                "ris_name) ";
        sql += "values(seq_t_existing_project.nextval," +
                ":risId," +
                ":name," +
                ":projectTypeCode," +
                ":projectTypeName," +
                ":projectProgressCode," +
                ":projectProgressName," +
                ":reviewPassedDar," +
                ":reviewPassedCpc," +
                ":reviewPassedTts," +
                ":reviewPassedFsr," +
                ":constructionDepartmentId," +
                ":constructionDepartmentName," +
                ":orderIndex," +
                ":creatorId," +
                ":creatorRealName," +
                "sysdate," +
                ":lastEditorId," +
                ":lastEditorRealName," +
                "sysdate," +
                ":risName) ";
        return insertForId(sql, existingProject, "id");
    }

    public int delete(int id) {
        String sql = "delete from t_existing_project where id=?";
        return delete(sql, id);
    }
    public int update(ExistingProject existingProject) {
        String sql = "update t_existing_project set " +
                "ris_id=:risId," +
                "ris_name=:risName,"+
                "name=:name," +
                "project_type_code=:projectTypeCode," +
                "project_type_Name=:projectTypeName," +
                "project_progress_code=:projectProgressCode," +
                "project_progress_name=:projectProgressName," +
                "review_passed_dar=:reviewPassedDar," +
                "review_passed_cpc=:reviewPassedCpc," +
                "review_passed_tts=:reviewPassedTts," +
                "review_passed_fsr=:reviewPassedFsr," +
                "construction_department_id=:constructionDepartmentId," +
                "construction_department_name=:constructionDepartmentName," +
                "order_index=:orderIndex," +
                "last_editor_id=:lastEditorId," +
                "last_editor_real_name=:lastEditorRealName," +
                "last_edited_at=sysdate where id=:id";
        return update(sql, existingProject);
    }
    /**
     * what: 根据id获取
     * @param : * @param null
     * @return: 根据id查询的对象
     * @Description : 
     * @author 卢薪竹 created by 8:51 2019/8/28
    */


    public ExistingProject get(int id) {
        String sql = "select t.id,t.name,t.ris_id,t.ris_name,t.project_type_code, " +
                "(select name from t_sys_dic where category='PROJECT_TYPE' and code = project_type_code) project_type_name, " +
                "t.project_progress_code, " +
                "(select name from t_sys_dic where category='PROJECT_PROGRESS' and code = project_progress_code) project_progress_name, " +
                "t.review_passed_dar,t.review_passed_cpc,t.review_passed_tts,t.review_passed_fsr,t.construction_department_id,t.construction_department_name, " +
                "t.order_index,t.creator_id,t.creator_real_name,t.created_at,t.last_editor_id,t.last_editor_real_name,t.last_edited_at from t_existing_project t " +
                "where id=?";
        return get(sql, id);
    }
    public ExistingProject getData(int id) {
        String sql = "select nvl(t.ris_id,0),t.name,t.project_type_code,t.project_type_name,t.project_progress_code," +
                "t.project_progress_name,t.review_passed_dar,t.review_passed_cpc,t.review_passed_tts," +
                "t.review_passed_fsr,nvl(t.construction_department_id,0)," +
                "t.construction_department_name,nvl(t.order_index,0),nvl(t.creator_id,0),t.creator_real_name," +
                "nvl(t.last_editor_id,0),t.last_editor_real_name,t.ris_name from t_existing_project t" +
                " where id=?";
        return get(sql, id);
    }
    /**
     * what:既有信息系统列表
     * @param : existingProjectSearchVO 角色查询VO
     * @return: list
     * @Description : 
     * @author 卢薪竹 created by 8:52 2019/8/28
    */
    public List<ExistingProject> list(ExistingProjectSearchVO existingProjectSearchVO) {
        String sql ="select t.id,t.name,t.ris_name,t.ris_id," +
                "(select name from t_sys_dic where category='PROJECT_TYPE' and code = project_type_code) project_type_name,"+
                "(select name from t_sys_dic where category='PROJECT_PROGRESS' and code = project_progress_code) project_progress_name," +
                "t.review_passed_cpc,t.construction_department_name,t.creator_real_name,t.last_editor_real_name,t.last_edited_at from t_existing_project t where 1=1";

        sql += createSearchSql(existingProjectSearchVO);
        //sql += " order by display_order asc ";
        sql = PageUtil.createOraclePageSQL(sql, existingProjectSearchVO.getPageIndex());
        return list(sql, existingProjectSearchVO);
    }
    /**
     * what: 查询既有项目总数
     * @param : existingProjectSearchVO 角色查询VO
     * @return: int
     * @Description : 
     * @author 卢薪竹 created by 8:52 2019/8/28
    */
    public int count(ExistingProjectSearchVO existingProjectSearchVO) {
        String sql = " select count(*) from t_existing_project where 1=1";
        sql += createSearchSql(existingProjectSearchVO);
        return count(sql, existingProjectSearchVO);
    }
    /**
     * what: 创建查询语句
     * @param : existingProjectSearchVO 角色查询VO
     * @return: sql语句
     * @Description : 
     * @author 卢薪竹 created by 8:53 2019/8/28
    */
    private String createSearchSql(ExistingProjectSearchVO existingProjectSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(existingProjectSearchVO.getName())) {
            sql += " and name like :nameStr";
        }
        return sql;
    }

    /**
     * what: 根据项目id查询项目数量
     *
     * @param id 既有项目id
     *
     * @return int
     *
     * @author
     */
    public int countExistingProjectNum(int id) {
        String sql = "select count(*) from t_existing_project where id=?";
        return count(sql, id);
    }
}

