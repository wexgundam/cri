/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:boot
 * Module Name:TODO:Module
 */
package com.critc.cri.dao;

import com.critc.cri.model.ExistingProject;
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
public class TestExistingProjectDao {
    @Autowired
    private ExistingProjectDao existingProjectDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAdd() {
        ExistingProject existingProject = new ExistingProject();
        existingProject.setName("aaaaa");
        existingProject.setConstructionDepartmentId(1);
        existingProject.setConstructionDepartmentName("eeeeee");
        existingProject.setCreatorId(2);
        existingProject.setCreatorRealName("fffff");
        existingProject.setLastEditorId(3);
        existingProject.setLastEditorRealName("ggggg");
        existingProject.setOrderIndex(4);
        existingProject.setProjectProgressCode("hhhhh");
        existingProject.setProjectProgressName("IIIII");
        existingProject.setProjectTypeCode("jjjjjj");
        existingProject.setProjectTypeName("kkkkk");
        existingProject.setRisId(5);
        existingProject.setReviewPassedCpc("lllll");
        existingProject.setReviewPassedDar("mmmmm");
        existingProject.setReviewPassedFsr("nnnnn");
        existingProject.setReviewPassedTts("ooooo");
        existingProject.setConstructionDepartmentName("ppppp");
        existingProject.setConstructionDepartmentId(6);
        existingProjectDao.add(existingProject);
    }


    @Test
    public void testDelete() {
        existingProjectDao.delete(3);
        existingProjectDao.delete(2);
        existingProjectDao.delete(1);
    }

    @Test
    public void testUpdate() {
        ExistingProject existingProject = new ExistingProject();
        existingProject.setId(4);
        existingProject.setName("aaaaa*");
        existingProjectDao.update(existingProject);
    }

    @Test
    public void testGet() {
        System.out.println(existingProjectDao.get(5));
    }


}