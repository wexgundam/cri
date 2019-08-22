/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:boot
 * Module Name:TODO:Module
 */
package com.critc.cri.dao;

import com.critc.cri.model.People;
import com.critc.sys.dao.SysUserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * what:    测试UserMysqlRepository.<br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 靳磊 created on 2017/12/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext-database.xml")
public class TestPeopleDao {
    @Autowired private PeopleDao peopleDao;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testAdd() {
//        People people = new People();
//        people.setName("广州");
//        people.setAge(50);
//        peopleDao.add(people);

        People people = peopleDao.get(200);
        Assert.assertNotNull(people);
        Assert.assertEquals("广州", people.getName());
        Assert.assertEquals(50, people.getAge());
    }
}
