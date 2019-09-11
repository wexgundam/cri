/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:boot
 * Module Name:TODO:Module
 */
package com.critc.cri.dao;

import com.critc.cri.model.ExistingProject;
import com.critc.cri.vo.ExistingProjectSearchVO;
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
        existingProject.setName("@@@@@");
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
        existingProject.setRisId(8);
        existingProject.setReviewPassedCpc("lllll");
        existingProject.setReviewPassedDar("mmmmm");
        existingProject.setReviewPassedFsr("nnnnn");
        existingProject.setReviewPassedTts("ooooo");
        existingProject.setConstructionDepartmentName("ppppp");
        existingProject.setConstructionDepartmentId(6);
        existingProject.setRisName("from rs");
        existingProjectDao.add(existingProject);
    }


    @Test
    public void testDelete() {
        existingProjectDao.delete(94);
    }

    @Test
    public void testUpdate() {
        ExistingProject existingProject = new ExistingProject();
        existingProject.setId(87);
        existingProject.setName("￥");
        existingProject.setRisName("testing change content...");
        existingProjectDao.update(existingProject);
    }

    @Test
    public void testGet() {
        System.out.println(existingProjectDao.get(108));
    }

    @Test
    public void testCount(){
        ExistingProjectSearchVO existingProjectSearchVO = new ExistingProjectSearchVO();
        System.out.println("~~~~~~~~~:"+existingProjectDao.count(existingProjectSearchVO));
    }




}