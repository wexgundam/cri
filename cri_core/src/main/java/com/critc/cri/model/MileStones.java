package com.critc.cri.model;

/**
 * Created by rs on 2019-8-26.
 */
public class MileStones {

    private int id;
    private String name;              //项目名称
    private String actionName;       //项目类型
    private String milestonesStartat;  //里程碑开始时间
    private String milestonesEndat;  //里程碑结束时间
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

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getMilestonesStartat() {
        return milestonesStartat;
    }

    public void setMilestonesStartat(String milestonesStartat) {
        this.milestonesStartat = milestonesStartat;
    }

    public String getMilestonesEndat() {
        return milestonesEndat;
    }

    public void setMilestonesEndat(String milestonesEndat) {
        this.milestonesEndat = milestonesEndat;
    }

    public String getLeadingPeople() {
        return leadingPeople;
    }

    public void setLeadingPeople(String leadingPeople) {
        this.leadingPeople = leadingPeople;
    }
}
