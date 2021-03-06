package com.critc.cri.service;

import com.critc.cri.dao.RiopiDao;
import com.critc.cri.model.Riopi;
import com.critc.cri.vo.RiopiSearchVO;
import com.critc.util.page.PageSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.critc.util.model.ComboboxVO;
import com.critc.util.string.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户管理Service
 *
 *
 * @author 孔垂云
 * @date 2017-06-13
 */
@Service
public class RiopiService  extends PageSearchVO{
    @Autowired
    private RiopiDao riopiDao;

    public Riopi get(int id) {
        return riopiDao.get(id);
    }
    public List<Riopi> list(RiopiSearchVO riopiSearchVO) {
        // 获取所有部门
        List<Riopi> list = riopiDao.list(riopiSearchVO);
        return list;
    }
    public List<Riopi> list() {
        // 获取所有部门
        List<Riopi> list = riopiDao.list();
        return list;
    }
    /**
     *
     * what: 新增
     *
     * @param
     * @return flag 0、失败，1、成功，2、部门名称已经存在
     *
     * @author 李红 created on 2017年10月30日
     */
    public int add(Riopi riopi) {
        int flag = 0;
        int count = riopiDao.getNameNum(riopi);
        if (count > 0) {
            flag = 2;
        }
        else {
            riopiDao.add(riopi);
            flag = 1;
        }
        return flag;
    }

    /**
     *
     * what: 修改
     *
     * @param
     * @return flag 0、失败，1、成功，2、部门名称已经存在
     *
     * @author 李红 created on 2017年10月30日
     */
    public int update(Riopi riopi) {
        int flag = 0;
        int count = riopiDao.getNameNum(riopi);
        if (count > 0) {
            flag = 2;
        }
        else {
            riopiDao.update(riopi);
            flag = 1;
        }
        return flag;
    }

    /**
     *
     * what: 删除部门，先判断是否有下级部门，有的话提示不允许删除
     *
     * @param id 部门id
     * @return 删除结果 2、还有下级部门，1、删除成功
     *
     * @author 李红 created on 2017年10月30日
     */
    public int delete(int id) {
            return riopiDao.delete(id);
    }

    public int count(RiopiSearchVO riopiSearchVO) {
        return riopiDao.count(riopiSearchVO);
    }
    public List<ComboboxVO> listCombo() {
        //获取数据集
        List<ComboboxVO> list = riopiDao.listCombo();

        return list;
    }
    /**
     *
     * what: 生成Ztree的树节点,新增机构时使用
     *
     * @return Ztree
     *
     * @author 李红 created on 2017年10月30日
     */
    public String createZtreeByModule() {
        // 信息化名称列表
        List<Riopi> listModule =riopiDao.list();
        StringBuilder sb = new StringBuilder();
        for (Riopi sysModule : listModule) {
            sb.append("{id : \"" + sysModule.getId() + "\",pId :\"" + sysModule.getParentId() + "\",name :\""
                    + sysModule.getName() + "\",open : false");
            sb.append("},");
        }
        return StringUtil.subTract(sb.toString());
    }

}