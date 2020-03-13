package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.Action;
import com.critc.cri.vo.ActionSearchVO;
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
public class ActionDao extends BaseDao<Action,ActionSearchVO> {

    /**
     * what:    添加
     *
     * @param
     *
     * @return
     *
     * @author
     */
    public int add(Action action) {

        String sql = "insert into t_railway_information_system(id,name,riopi_id,riopi_name,order_index,creator_id,creator_real_name,created_at,last_editor_id,last_editor_real_name,last_edited_at)"
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,sysdate,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,sysdate)";
        return insert(sql, action);
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
    public int update(Action action) {
        String sql = "update t_key_action set name =:name, project_name =:projectName, action_start_at =:actionStartat, " +
                "action_end_at =:actionEndat,leading_peaple=:leadingPeople where id=:id";
        return update(sql, action);
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
        String sql = "delete from t_key_action where id=?";
        return delete(sql, id);
    }
    public Action get(int id) {
        String sql = "select t.name,t.project_name,t.action_start_at,t.action_end_at,t.leading_peaple from t_key_action t where id=?";
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
    public int getNameNum(Action action) {
        String sql = "select count(*) from t_key_action where name = ?";
        if (StringUtil.isNotNullOrEmpty(String.valueOf(action.getId()))) {
            sql += " and id != ?";
        }
        Object[] objects = new Object[] {action.getName(), action.getId()};
        return count(sql, objects);
    }
    public List<Action> list(ActionSearchVO actionSearchVO) {
       String sql = "select t.name,t.project_name,t.action_start_at,t.action_end_at,t.leading_peaple from t_key_action t";
        sql += createSearchSql(actionSearchVO);
     //   sql += " order by to_char(nvl(order_index,0)) asc ";
     //   sql = PageUtil.createOraclePageSQL(sql, railwayInformationSystemSearchVO.getPageIndex());
        return list(sql, actionSearchVO);
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
    public int count(ActionSearchVO actionSearchVO) {
        String sql = "select count(*) from t_key_action  where 1=1 ";
        sql += createSearchSql(actionSearchVO);
        return count(sql,actionSearchVO);
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
    private String createSearchSql(ActionSearchVO actionSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(actionSearchVO.getName())) {
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
    public List<Action> list() {
        String sql="select t.name,t.project_name,t.action_start_at,t.action_end_at,t.leading_peaple from t_key_action t";
        return list(sql);
    }

    public int getMaxNum() {
        String sql = "select max(id) from t_key_action ";
          return count(sql);
    }
}
