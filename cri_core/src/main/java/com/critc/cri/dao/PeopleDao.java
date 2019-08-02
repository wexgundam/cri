package com.critc.cri.dao;

import com.critc.core.dao.BaseDao;
import com.critc.cri.model.People;
import com.critc.sys.vo.SysUserSearchVO;
import org.springframework.stereotype.Repository;

/**
 * 系统用户Dao
 *
 * @author 孔垂云
 * @date 2017-06-13
 */
@Repository
public class PeopleDao extends BaseDao<People, SysUserSearchVO> {

    /**
     * what:    (这里用一句话描述这个方法的作用)
     *
     * @param people
     *
     * @return
     *
     * @author 马丽静 created on 2017年11月6日
     */
    public int add(People people) {
        String sql = "insert into t_people (id, name, age) ";
        sql += "values(seq_t_people.nextval,:name,:age)";
        return insertForId(sql, people, "id");
    }

    //
//    /**
//     * 修改用户
//     *
//     * @param sysUser
//     *
//     * @return
//     */
//    public int update(SysUser sysUser) {
//        String sql = "update t_sys_user set real_name=:realName,role_id=:roleId,mobile=:mobile,deletable=:deletable," +
//                "last_editor_id=:lastEditorId,last_editor_real_name=:lastEditorRealName,last_edited_at=sysdate," +
//                "department_id=:departmentId, pinyin=:pinyin,avatar=:avatar," +
//                "email=:email,nation=:nation,gender=:gender,political=:political,education=:education," +
//                "graduated_school=:graduatedSchool,major=:major,idcard=:idcard,telephone=:telephone,post=:post," +
//                "job_title=:jobTitle,display_order=:displayOrder,completion=:completion " +
//                "where id=:id ";
//        return update(sql, sysUser);
//    }
//
//    /**
//     * 删除用户
//     *
//     * @param id
//     *
//     * @return
//     */
//    public int delete(int id) {
//        String sql = "delete from t_sys_user where id=?";
//        return delete(sql, id);
//    }
//
    public People get(int id) {
        String sql = "select id, name, age from t_people where id=?";
        return get(sql, id);
    }
//
//    /**
//     * what:    根据username获取sysUser
//     *
//     * @param username
//     *
//     * @return
//     *
//     * @author 马丽静 created on 2017年11月6日
//     */
//    public SysUser getByName(String name) {
//        String sql = "select t.id,t.username,t.password,t.randomcode,t.status,t.real_name,t.mobile,t.avatar,t.role_id,t.deletable," +
//                "t.creator_id,t.creator_real_name,t.created_at,t.last_editor_id,t.last_editor_real_name,t.last_edited_at," +
//                "(select name from t_sys_role where id=role_id) roleName from t_sys_user t where username=?";
//        return get(sql, username);
//    }
//
//    /**
//     * 查询用户信息
//     *
//     * @param sysUserSearchVO
//     *
//     * @return
//     */
//    public List<SysUser> list(SysUserSearchVO sysUserSearchVO) {
//        String sql = "select t.id, t.username, t.password, t.randomcode, t.status, t.real_name, t.mobile, t.avatar,t.role_id,t.deletable," +
//                "t.creator_id,t.creator_real_name,t.created_at,t.last_editor_id,t.last_editor_real_name,t.last_edited_at," +
//                "t.department_id,t.is_admin, t.is_check, t.pinyin, t.email, t.gender, t.nation, t.political, t.education," +
//                "t.graduated_school,t.major, t.idcard, t.telephone, t.post, t.job_title, t.display_order,t.last_login_date," +
//                "(select name from t_sys_department d where t.department_id = d.id) as department_name,  " +
//                "(select name from t_sys_role where id = t.role_id) roleName from t_sys_user t where 1=1";
//        sql += createSearchSql(sysUserSearchVO);
//        sql += " order by t.id asc";
//        sql = PageUtil.createOraclePageSQL(sql, sysUserSearchVO.getPageIndex());
//        return list(sql, sysUserSearchVO);
//    }
//
//    public List<SysUser> listAll() {
//        String sql = "select t.id, t.username, t.password, t.randomcode, t.status, t.real_name, t.mobile, t.avatar,t.deletable," +
//                "t.creator_id,t.creator_real_name,t.created_at,t.last_editor_id,t.last_editor_real_name,t.last_edited_at," +
//                "t.department_id,t.is_admin, t.is_check, t.pinyin, t.email, t.gender, t.nation, t.political, t.education," +
//                "t.graduated_school, t.major, t.idcard, t.telephone, t.post, t.job_title, t.display_order,t.last_login_date," +
//                "(select name from t_sys_department d where t.department_id = d.id) as department_name," +
//                "(select name from t_sys_role where id = t.role_id) roleName from t_sys_user t ";
//        sql += " order by t.id asc";
//        return list(sql);
//    }
//
//    /**
//     * 查询用户总数
//     *
//     * @param sysUserSearchVO
//     *
//     * @return
//     */
//    public int count(SysUserSearchVO sysUserSearchVO) {
//        String sql = "select count(*) from t_sys_user where 1=1 ";
//        sql += createSearchSql(sysUserSearchVO);
//        return count(sql, sysUserSearchVO);
//    }
//
//    private String createSearchSql(SysUserSearchVO sysUserSearchVO) {
//        String sql = "";
//        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getUsername())) {
//            sql += " and username=:username";
//        }
//        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getRealName())) {
//            sql += " and real_name like :realName";
//        }
//        if (sysUserSearchVO.getRoleId() != null) {
//            sql += " and role_id=:roleId";
//        }
//        if (sysUserSearchVO.getStatus() != null) {
//            sql += " and status=:status";
//        }
//        if (sysUserSearchVO.getDepartmentId() != null) {
//            sql += " and department_id=:departmentId";
//        }
//        if ("1".equals(sysUserSearchVO.getIsCompletion())) {
//            sql += " and completion > 49";
//        }
//        if ("0".equals(sysUserSearchVO.getIsCompletion())) {
//            sql += "and completion < 50";
//        }
//
//
//        return sql;
//    }
}
