package com.critc.cri.dao;

import com.critc.cri.model.Riopi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by LXY777 on 2019-08-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext-database.xml")
public class TestRiopiDao {
    @Autowired
    private RiopiDao riopiDao;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testAdd() {
//        People people = new People();
//        people.setName("广州");
//        people.setAge(50);
//        peopleDao.add(people);

        Riopi riopi = new Riopi();
        riopi.setId(1);
        riopi.setName("sss");
        riopi.setParentId(2);
        riopi.setBmDepartmentId(3);
        riopi.setBmDepartmentName("aaa");
        riopi.setDisplayOrder(4);
        riopi.setNote("kkk");
        riopi.setCreatorId(5);
        riopi.setCreatorRealName("www");
        riopi.setLastEditorId(6);
        riopi.setLastEditorRealName("qqq");
     //   riopiDao.add(riopi);


        //ExistingProject existingProject = existingProjectDao.get(200);


    }

    @Test
    public void testDelete() {

   //     riopiDao.delete(1);

    }


    @Test
    public void testUpdate() {
        Riopi riopi = riopiDao.get(21);
        riopi.setName("ww");
        riopi.setParentId(9);
        riopi.setBmDepartmentId(8);
        riopi.setBmDepartmentName("rrr");
        riopi.setDisplayOrder(7);
        riopi.setNote("lll");
        riopi.setCreatorId(6);
        riopi.setCreatorRealName("www");
        riopi.setLastEditorId(45);
        riopi.setLastEditorRealName("ppp");
     //   riopiDao.update(riopi);

    }


    @Test
    public void testGet() {
        Riopi one = riopiDao.get(21);
        System.out.println(one);


    }
}
