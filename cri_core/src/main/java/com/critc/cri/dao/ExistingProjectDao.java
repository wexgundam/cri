package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.vo.ExistingProjectSearchVO;
import com.critc.sys.model.SysRole;
import com.critc.sys.vo.SysRoleSearchVO;
import com.critc.util.page.PageUtil;
import com.critc.util.string.StringUtil;
import org.springframework.stereotype.Repository;
import sun.util.resources.mt.CalendarData_mt;

import java.util.List;

/**
 * Created by DJF on 2019/8/15.
 */
@Repository
public class ExistingProjectDao extends BaseDao<ExistingProject,ExistingProject> {

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
                "last_edited_at) ";
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
                "sysdate) ";
        return insertForId(sql, existingProject, "id");
    }
    public int delete(int id) {
        String sql = "delete from t_existing_project where id=?";
        return delete(sql, id);
    }
    public int update(ExistingProject existingProject) {
        String sql = "update t_existing_project set ris_id=:risId," +
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
                "last_edited_at=:lastEditedAt where id=:id";
        return update(sql, existingProject);
    }
    /**
     * what: 根据id获取
     *
     * @param id 部门id
     * @return 根据id查询的对象
     * @author 李红 created on 2017年10月30日
     */
    public ExistingProject get(int id) {
        String sql = "select t.id," +
                "t.ris_id, " +
                "t.name," +
                "t.project_type_code," +
                "t.project_type_name," +
                "t.project_progress_code," +
                "t.project_progress_name," +
                "t.review_passed_dar," +
                "t.review_passed_cpc," +
                "t.review_passed_tts," +
                "t.review_passed_fsr," +
                "t.construction_department_id," +
                "t.construction_department_name," +
                "t.order_index," +
                "t.creator_id," +
                "t.creator_real_name," +
                "t.created_at," +
                "t.last_editor_id," +
                "t.last_editor_real_name," +
                "t.last_edited_at from t_existing_project t where id=?";
        return get(sql, id);
    }


    /**
     * what: 角色列表
     *
     * @param existingProjectSearchVO 角色查询VO
     *
     * @return list
     *
     * @author 李红 created on 2017年11月8日
     */
    public List<ExistingProject> list(ExistingProjectSearchVO existingProjectSearchVO) {
        String sql = "select t.id,t.name,t.description,t.display_order,t.creator_id,t.creator_real_name,t.created_at,t.last_editor_id,t.last_editor_real_name,t.last_edited_at,t.deletable from t_sys_role t where 1=1 ";
        sql += createSearchSql(existingProjectSearchVO);
        sql += " order by display_order asc ";
        sql = PageUtil.createOraclePageSQL(sql, existingProjectSearchVO.getPageIndex());
        return list(sql, existingProjectSearchVO);
    }
    /**
     * what: 查询角色总数
     *
     * @param existingProjectSearchVO 角色查询VO
     *
     * @return int
     *
     * @author 李红 created on 2017年11月8日
     */
    public int count(ExistingProjectSearchVO existingProjectSearchVO) {
        String sql = "select count(*) from t_sys_role where 1=1 ";
        sql += createSearchSql(existingProjectSearchVO);
        return count(sql, existingProjectSearchVO);
    }


    /**
     * what: 创建查询语句
     *
     * @param existingProjectSearchVO 角色查询VO
     *
     * @return sql语句
     *
     * @author 李红 created on 2017年11月8日
     */
    private String createSearchSql(ExistingProjectSearchVO existingProjectSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(existingProjectSearchVO.getName())) {
            sql += " and name like :nameStr";
        }
        return sql;
    }

}

