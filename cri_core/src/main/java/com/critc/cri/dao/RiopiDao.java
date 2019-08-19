package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.Riopi;
import org.springframework.stereotype.Repository;

/**
 * Created by LXY777 on 2019-08-16.
 */
@Repository
public class RiopiDao extends BaseDao<Riopi,Riopi> {

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
        String sql = "update t_riopi set"+
                "name=:name," +
                "parent_id=:parentId," +
                "bm_department_id=:bmDepartmentId," +
                "bm_department_name=:bmDepartmentName," +
                "display_order=:displayOrder," +
                "note=:note," +
                "creator_id=:creatorId," +
                "creator_real_name=creatorRealName:," +
                "created_at=:sysdate," +
                "last_editor_id=:lastEditorId," +
                "last_editor_real_name=:lastEditorRealName," +
                "last_edited_at=:sysdate where id=:id";
        return update(sql, riopi);
    }



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
                "t.last_edited_at) ";

        return get(sql, id);
    }

}
