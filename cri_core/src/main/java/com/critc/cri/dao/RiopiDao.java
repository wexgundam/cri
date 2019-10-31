package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.Riopi;
import com.critc.cri.vo.RiopiSearchVO;
import com.critc.util.model.ComboboxVO;
import com.critc.util.page.PageUtil;
import com.critc.util.string.StringUtil;
import org.springframework.stereotype.Repository;
import com.critc.util.model.ComboboxVO;

import java.util.List;

/**
 * Created by LXY777 on 2019-08-16.
 */
@Repository
public class RiopiDao extends BaseDao<Riopi, RiopiSearchVO> {

    public Riopi get(int id) {
                String sql = "select t.id," +
                "t.name," +
                "t.parent_id," +
                "t.bm_department_id," +
                "t.bm_department_name," +
                "t.display_order," +
                "t.note," +
                "t.creator_id," +
                "t.creator_real_name," +
                "t.created_at," +
                "t.last_editor_id," +
                "t.last_editor_real_name," +
                "t.last_edited_at " +
                "from t_riopi t " +
                "where t.id=:id";
        return get(sql, id);
    }

    public List<Riopi> list(RiopiSearchVO riopiSearchVO) {
                String sql = "select t.id," +
                "t.name," +
                "t.parent_id," +
                "t.bm_department_id," +
                "t.bm_department_name," +
                "t.display_order," +
                "t.note," +
                "t.creator_id," +
                "t.creator_real_name," +
                "t.created_at," +
                "t.last_editor_id," +
                "t.last_editor_real_name," +
                "t.last_edited_at " +
                "from t_riopi t where 1=1 ";
        sql += createSearchSql(riopiSearchVO);
        sql += " order by to_char(display_order) asc";
      //  sql = PageUtil.createOraclePageSQL(sql, riopiSearchVO.getPageIndex());
        return list(sql,riopiSearchVO);
    }
//
//    /**
//     *
//     * what: 查询角色总数
//     *
//     * @param
//     * @return int
//     *
//     * @author 李红 created on 2017年11月8日
//     */
//    public int count() {
//        String sql = "select count(*) from t_sys_role where 1=1 ";
//        return count(sql);
//    }
//
    public int add(Riopi riopi) {
        String sql = "insert into t_riopi (id, " +
                "name," +
                "parent_id," +
                "bm_department_id," +
                "bm_department_name," +
                "display_order," +
                "note," +
                "creator_id," +
                "creator_real_name," +
                "created_at," +
                "last_editor_id," +
                "last_editor_real_name," +
                "last_edited_at) ";
        sql += "values(seq_t_riopi.nextval," +
                ":name," +
                ":parentId," +
                ":bmDepartmentId," +
                ":bmDepartmentName," +
                ":displayOrder," +
                ":note," +
                ":creatorId," +
                ":creatorRealName," +
                "sysdate," +
                ":lastEditorId," +
                ":lastEditorRealName," +
                "sysdate) ";


        return insertForId(sql, riopi, "id");
    }


    public int delete(int id) {
        String sql = "delete from t_riopi where id=? ";
        return delete(sql, id);
    }


    public int update(Riopi riopi) {
        String sql = "update t_riopi set " +
                "name=:name," +
                "parent_id=:parentId," +
                "bm_department_id=:bmDepartmentId," +
                "bm_department_name=:bmDepartmentName," +
                "display_order=:displayOrder," +
                "note=:note," +
                "last_editor_id=:lastEditorId," +
                "last_editor_real_name=:lastEditorRealName," +
                "last_edited_at=sysdate " +
                "where id=:id";
        return update(sql, riopi);
    }
//
//
//    public Riopi get(int id) {
//        String sql = "select t.id," +
//                "t.name," +
//                "t.parent_id," +
//                "t.bm_department_id," +
//                "t.bm_department_name," +
//                "t.display_order," +
//                "t.note," +
//                "t.creator_id," +
//                "t.creator_real_name," +
//                "t.created_at," +
//                "t.last_editor_id," +
//                "t.last_editor_real_name," +
//                "t.last_edited_at " +
//                "from t_riopi t " +
//                "where t.id=:id";
//
//        return get(sql, id);
//    }
//
    public int getNameNum(Riopi riopi) {
        String sql = "select count(*) from t_riopi where name = ?";
//        if (StringUtil.isNotNullOrEmpty(String.valueOf(riopi.getName()))) {
//            sql += " and name = :name";
//        }
        Object[] objects = new Object[] {riopi.getName()};
        return count(sql,objects);
    }
//
//    public int countUserNum(int id) {
//        String sql = "select count(*) from t_sys_user where role_id=?";
//        return count(sql, id);
//    }
    /**
     *
     * what: 查询时使用拼接url. <br/>
     * when: 点击查询时使用.<br/>
     *
     * @param
     * @return 返回拼接的查询sql
     *
     * @author 刘正荣 created on 2017年10月31日
     */
    private String createSearchSql(RiopiSearchVO riopiSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(riopiSearchVO.getName())) {
            sql += " and name like :NameStr";
        }
//        if (StringUtil.isNotNullOrEmpty(riopiSearchVO.getVersion())) {
//            sql += " and version like :versionStr";
//        }
//        if (StringUtil.isNotNullOrEmpty(riopiSearchVO.getReleaseBy())) {
//            sql += " and release_by like :releaseByStr";
//        }
//        if (StringUtil.isNotNullOrEmpty(riopiSearchVO.getReleaseDate())) {
//            sql += " and release_date like :releaseDateStr";
//        }
        return sql;
    }
    public int count(RiopiSearchVO riopiSearchVO) {
        String sql = "select count(*) from  t_riopi where 1=1 ";
        sql += createSearchSql(riopiSearchVO);
        return count(sql, riopiSearchVO);
    }
    /**
     *
     * what: 角色下拉框
     *
     * @return list
     *
     * @author lxy created on 2017年11月8日
     */
    public List<ComboboxVO> listCombo() {
        String sql = "select t.id value,t.name content from t_riopi t where 1=1 order by id ";
        return listCombobox(sql);
    }
    /**
     *
     * what: 获取所有目录
     *
     * @return list
     *
     * @author lxy created on 2019年9月4日
     */
    public List<Riopi> list() {
        String sql = "select t.id," +
                "t.name," +
                "t.parent_id," +
                "t.bm_department_id," +
                "t.bm_department_name," +
                "t.display_order," +
                "t.note," +
                "t.creator_id," +
                "t.creator_real_name," +
                "t.created_at," +
                "t.last_editor_id," +
                "t.last_editor_real_name," +
                "t.last_edited_at " +
                "from t_riopi t where 1=1 ";
        return list(sql);
    }
}
