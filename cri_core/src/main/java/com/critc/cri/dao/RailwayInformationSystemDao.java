package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.RailwayInformationSystem;
import com.critc.cri.vo.RailwayInformationSystemSearchVO;
import com.critc.util.model.ComboboxVO;
import com.critc.util.page.PageUtil;
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
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,sysdate,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,sysdate)";
        return insert(sql, railwayInformationSystem);
    }

    public int addForId(RailwayInformationSystem railwayInformationSystem) {
        String sql = "insert into t_railway_information_system(id,name,riopi_id,riopi_name,order_index,creator_id,creator_real_name,created_at,last_editor_id,last_editor_real_name,last_edited_at)"
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,sysdate,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,sysdate)";
        return insertForId(sql, railwayInformationSystem, "id");
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
//        String sql = "select t.id,t.name,t.riopi_id,t.riopi_name,t.order_index,t.creator_id," +
//                "t.creator_real_name,t.created_at," +
//                "t.last_editor_id,t.last_editor_real_name," +
//                "t.last_edited_at from t_railway_information_system t where 1=1 ";
        String sql = "select * from (select t1.id,t1.name,t1.parent_id riopi_id,t1.display_order order_index," +
                "'' project_type_name,'' project_progress_name,'' review_passed_dar,'' review_passed_cpc,'' review_passed_tts,'' review_passed_fsr,'' construction_department_name," +
                "t1.creator_real_name,t1.created_at,t1.last_editor_real_name,t1.last_edited_at from t_riopi t1" +
                " union " +
                "select t.id,t.name,t.riopi_id,t.order_index,t.project_type_name,t.project_progress_name,t.review_passed_dar,t.review_passed_cpc,t.review_passed_tts,t.review_passed_fsr,t.construction_department_name," +
                "t.creator_real_name,t.created_at," +
                "t.last_editor_real_name,t.last_edited_at from t_railway_information_system t) a where 1=1";
        sql += createSearchSql(railwayInformationSystemSearchVO);
        sql += " order by to_char(nvl(order_index,0)) asc ";
     //   sql = PageUtil.createOraclePageSQL(sql, railwayInformationSystemSearchVO.getPageIndex());
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
        String sql = "select count(*) from (select * from (select t1.id,t1.name,t1.parent_id riopi_id,t1.display_order order_index ,t1.creator_real_name,t1.created_at,t1.last_editor_real_name,t1.last_edited_at from t_riopi t1 union select t.id,t.name,t.riopi_id,t.order_index,t.creator_real_name,t.created_at,t.last_editor_real_name,t.last_edited_at from t_railway_information_system t ) a where 1=1) a where 1=1 ";
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
            sql += " and a.name like :NameStr";
        }else if(StringUtil.isNotNullOrEmpty(railwayInformationSystemSearchVO.getriopiName())){
            sql += " and a.name like :riopiNameStr";
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
    public List<RailwayInformationSystem> list() {
        String sql="select t.id,t.name,t.riopi_id,t.riopi_name, t.order_index,t.last_edited_at from t_railway_information_system t";
        return list(sql);
    }

    public int getMaxNum() {
        String sql = "select max(id) from t_railway_information_system ";
          return count(sql);
    }
}
