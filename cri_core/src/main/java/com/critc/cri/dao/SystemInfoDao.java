package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.SystemInfo;
import com.critc.sys.vo.SysUserSearchVO;
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
public class SystemInfoDao extends BaseDao<SystemInfo, SysUserSearchVO> {

    /**
     * what:    添加
     *
     * @param systemInfo
     *
     * @return
     *
     * @author
     */
    public int add(SystemInfo systemInfo) {
        String sql = "insert into t_railway_information_system(id,name,riopi_id,riopi_name,order_index,creator_id,creator_real_name,created_at,last_editor_id,last_editor_real_name,last_edited_at)"
                + " values(SEQ_T_RIS.nextval,:name,:RIOPI_ID,:RIOPI_NAME,:ORDER_INDEX,:CREATOR_ID,:CREATOR_REAL_NAME,:CREATED_AT,:LAST_EDITOR_ID,:LAST_EDITOR_REAL_NAME,:LAST_EDITED_AT)";
        return insert(sql, systemInfo);
    }

    /**
     *
     * what: 修改
     *
     * @param systemInfo
     * @return int
     *
     * @author rs created on 2019年08月28日
     */
    public int update(SystemInfo systemInfo) {
        String sql = "update t_railway_information_system set name =:name, riopi_id =:RIOPI_ID, riopi_name =:RIOPI_NAME, " +
                "order_index =:ORDER_INDEX,creator_id=:CREATOR_ID,creator_real_name=:CREATOR_REAL_NAME,created_at=:CREATED_AT," +
                "last_editor_id=:LAST_EDITOR_ID,last_editor_real_name= :LAST_EDITOR_REAL_NAME,last_edited_at = :LAST_EDITED_AT where id=:id";
        return update(sql, systemInfo);
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
    public SystemInfo get(int id) {
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
    public int getNameNum(SystemInfo systemInfo) {
        String sql = "select count(*) from t_railway_information_system where name = :name";

        return count(sql, systemInfo);
    }
    public List<SystemInfo> list() {
        String sql = "select t.id,t.name,t.riopi_id,t.riopi_name,t.order_index,t.creator_id," +
                "t.creator_real_name,t.created_at," +
                "t.last_editor_id,t.last_editor_real_name," +
                "t.last_edited_at from t_railway_information_system t ";
        return list(sql);
    }
}
