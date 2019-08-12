package com.critc.cri.service;

import com.critc.cri.dao.PeopleDao;
import com.critc.cri.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户管理Service
 *
 * @author 孔垂云
 * @date 2017-06-13
 */
@Service
public class PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    public People get(int id) {
        return peopleDao.get(id);
    }
}
