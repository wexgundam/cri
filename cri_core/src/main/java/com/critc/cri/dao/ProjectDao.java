package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.Project;
import com.critc.cri.vo.ProjectSearchVO;
import com.critc.util.string.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 铁路信息系统Dao
 *
 * @author rs
 * @date 2019-08-27
 */
@Repository
public class ProjectDao extends BaseDao<Project,ProjectSearchVO> {

    /**
     * what:    添加
     *
     * @param
     *
     * @return
     *
     * @author
     */
    public int add(Project project) {

        String sql = "insert into t_railway_information_system(id,name,riopi_id,riopi_name,order_index,creator_id,creator_real_name,created_at,last_editor_id,last_editor_real_name,last_edited_at)"
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,sysdate,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,sysdate)";
        return insert(sql, project);
    }

    public int addForId(Project project) {
        String sql = "insert into t_railway_information_system(id,name,riopi_id,riopi_name,order_index,creator_id,creator_real_name,created_at,last_editor_id,last_editor_real_name,last_edited_at)"
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,sysdate,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,sysdate)";
        return insertForId(sql,project, "id");
    }
    /**
     *
     * what: 修改
     *
     * @param
     * @return int
     *
     * @author rs created on 2019年08月28日
     */
    public int update(Project project) {
        String sql = "update t_railway_information_system set name =:name, riopi_id =:RIOPI_ID, riopi_name =:RIOPI_NAME, " +
                "order_index =:ORDER_INDEX,creator_id=:CREATOR_ID,creator_real_name=:CREATOR_REAL_NAME,created_at=:CREATED_AT," +
                "last_editor_id=:LAST_EDITOR_ID,last_editor_real_name= :LAST_EDITOR_REAL_NAME,last_edited_at = :LAST_EDITED_AT where id=:id";
        return update(sql, project);
    }

    /**
     *
     * what: 删除
     *
     * @param id id
     * @return int
     *
     * @author rs created on 2019年08月28日
     */
    public int delete(int id) {
        String sql = "delete from t_project where id=?";
        return delete(sql, id);
    }
    public Project get(int id) {
        String sql = "select t.id,t.name,t.riopi_id,t.riopi_name,t.order_index,t.creator_id,t.creator_real_name,t.created_at,t.last_editor_id,t.last_editor_real_name,t.last_edited_at from t_railway_information_system t where id=?";
        return get(sql, id);
    }
    /**
     *
     * what: 按系统名称查询
     *
     * @param
     * @return int
     *
     * @author rs created on 2019年08月28日
     */
    public int getNameNum(Project project) {
        String sql = "select count(*) from t_project where name = ?";
        if (StringUtil.isNotNullOrEmpty(String.valueOf(project.getId()))) {
            sql += " and id != ?";
        }
        Object[] objects = new Object[] {project.getName(), project.getId()};
        return count(sql, objects);
    }
    public List<Project> list(ProjectSearchVO projectSearchVO) {
       String sql = "select t.name,t.project_type_name,t.project_progress_name,t.construction_department_name,t.creator_real_name,t.project_start_at,t.project_end_at,t.leading_peaple from t_project t";
        sql += createSearchSql(projectSearchVO);
     //   sql += " order by to_char(nvl(order_index,0)) asc ";
     //   sql = PageUtil.createOraclePageSQL(sql, railwayInformationSystemSearchVO.getPageIndex());
        return list(sql, projectSearchVO);
    }
    /**
     *
     * what: 查询系统总数
     *
     * @param
     * @return int
     *
     * @author rs created on 2019年9月4日
     */
    public int count(ProjectSearchVO projectSearchVO) {
        String sql = "select count(*) from t_project  where 1=1 ";
        sql += createSearchSql(projectSearchVO);
        return count(sql, projectSearchVO);
    }
    /**
     *
     * what: 创建查询语句
     *
     * @param
     * @return sql语句
     *
     * @author rs created on 2017年11月8日
     */
    private String createSearchSql(ProjectSearchVO projectSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(projectSearchVO.getName())) {
            sql += " and a.name like :NameStr";
        }
        return sql;
    }
    /**
     *
     * what: 获取所有目录
     *
     * @return list
     *
     * @author rs created on 2019年9月4日
     */
    public List<Project> list() {
        String sql="select t.name,t.project_type_name,t.project_progress_name,t.construction_department_name,t.creator_real_name,t.project_start_at,t.project_end_at,t.leading_peaple from t_project t";
        return list(sql);
    }

    public int getMaxNum() {
        String sql = "select max(id) from t_project ";
          return count(sql);
    }
}
