package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.RailwayInformationSystem;
import com.critc.cri.vo.RailwayInformationSystemSearchVO;
import com.critc.util.model.ComboboxVO;
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
public class RailwayInformationSystemDao extends BaseDao<RailwayInformationSystem,RailwayInformationSystemSearchVO> {

    /**
     * what:    添加
     *
     * @param railwayInformationSystem
     *
     * @return
     *
     * @author
     */
    public int add(RailwayInformationSystem railwayInformationSystem) {
        String sql = "insert into t_railway_information_system(id,name,riopi_id,riopi_name,order_index,creator_id,creator_real_name,created_at,last_editor_id,last_editor_real_name,last_edited_at)"
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,:CREATED_AT,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,:LAST_EDITED_AT)";
        return insert(sql, railwayInformationSystem);
    }

    /**
     *
     * what: 修改
     *
     * @param railwayInformationSystem
     * @return int
     *
     * @author rs created on 2019年08月28日
     */
    public int update(RailwayInformationSystem railwayInformationSystem) {
        String sql = "update t_railway_information_system set name =:name, riopi_id =:RIOPI_ID, riopi_name =:RIOPI_NAME, " +
                "order_index =:ORDER_INDEX,creator_id=:CREATOR_ID,creator_real_name=:CREATOR_REAL_NAME,created_at=:CREATED_AT," +
                "last_editor_id=:LAST_EDITOR_ID,last_editor_real_name= :LAST_EDITOR_REAL_NAME,last_edited_at = :LAST_EDITED_AT where id=:id";
        return update(sql, railwayInformationSystem);
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
        String sql = "delete from t_railway_information_system where id=?";
        return delete(sql, id);
    }
    public RailwayInformationSystem get(int id) {
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
    public int getNameNum(RailwayInformationSystem railwayInformationSystem) {
        String sql = "select count(*) from t_railway_information_system where name = ?";
        if (StringUtil.isNotNullOrEmpty(String.valueOf(railwayInformationSystem.getId()))) {
            sql += " and id != ?";
        }
        Object[] objects = new Object[] {railwayInformationSystem.getName(), railwayInformationSystem.getId()};
        return count(sql, objects);
    }
    public List<RailwayInformationSystem> list(RailwayInformationSystemSearchVO railwayInformationSystemSearchVO) {
        String sql = "select t.id,t.name,t.riopi_id,t.riopi_name,t.order_index,t.creator_id," +
                "t.creator_real_name,t.created_at," +
                "t.last_editor_id,t.last_editor_real_name," +
                "t.last_edited_at from t_railway_information_system t where 1=1 ";
        sql += createSearchSql(railwayInformationSystemSearchVO);
        sql += " order by order_index asc ";
      //  sql = PageUtil.createOraclePageSQL(sql, railwayInformationSystemSearchVO.getPageIndex());
        return list(sql, railwayInformationSystemSearchVO);
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
    public int count(RailwayInformationSystemSearchVO railwayInformationSystemSearchVO) {
        String sql = "select count(*) from t_railway_information_system t where 1=1 ";
        sql += createSearchSql(railwayInformationSystemSearchVO);
        return count(sql, railwayInformationSystemSearchVO);
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
    private String createSearchSql(RailwayInformationSystemSearchVO railwayInformationSystemSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(railwayInformationSystemSearchVO.getName())) {
            sql += " and name like :name";
        }else if(StringUtil.isNotNullOrEmpty(railwayInformationSystemSearchVO.getriopiName())){
            sql += " and riopi_name like :riopiName";
        }
        return sql;
    }
    /**
     *
     * what: 角色下拉框
     *
     * @return list
     *
     * @author 李红 created on 2017年11月8日
     */
    public List<ComboboxVO> listCombo() {
        String sql = "select t.id value,t.name content from t_riopi t where 1=1 order by id ";
        return listCombobox(sql);
    }
}
