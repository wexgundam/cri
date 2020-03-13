package com.critc.cri.model;

/**
 * Created by rs on 2019-8-26.
 */
public class Action {

    private int id;
    private String name;              //项目名称
    private String projectName;       //项目类型
    private String actionStartat;  //开始时间
    private String actionEndat;  //结束时间
    private String creatorrealName;  //创建人
    private String leadingPeople;  //负责人


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getActionStartat() {
        return actionStartat;
    }

    public void setActionStartat(String actionStartat) {
        this.actionStartat = actionStartat;
    }

    public String getActionEndat() {
        return actionEndat;
    }

    public void setActionEndat(String actionEndat) {
        this.actionEndat = actionEndat;
    }

    public String getCreatorrealName() {
        return creatorrealName;
    }

    public void setCreatorrealName(String creatorrealName) {
        this.creatorrealName = creatorrealName;
    }

    public String getLeadingPeople() {
        return leadingPeople;
    }

    public void setLeadingPeople(String leadingPeople) {
        this.leadingPeople = leadingPeople;
    }
}
