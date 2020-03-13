package com.critc.cri.model;

/**
 * Created by rs on 2019-8-26.
 */
public class Project {

    private int id;
    private String name;              //项目名称
    private String projectTypeName;       //项目类型
    private String projectProgressName;
    private String constructionDepartmentName;  //建设单位
    private String creatorRealName;  //创建人
    private String ProjectStartat;  //开始时间
    private String ProjectEndat;  //结束时间
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

    public String getProjectProgressName() {
        return projectProgressName;
    }

    public void setProjectProgressName(String projectProgressName) {
        this.projectProgressName = projectProgressName;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getConstructionDepartmentName() {
        return constructionDepartmentName;
    }

    public void setConstructionDepartmentName(String constructionDepartmentName) {
        this.constructionDepartmentName = constructionDepartmentName;
    }

    public String getCreatorRealName() {
        return creatorRealName;
    }

    public void setCreatorRealName(String creatorRealName) {
        this.creatorRealName = creatorRealName;
    }

    public String getProjectStartat() {
        return ProjectStartat;
    }

    public void setProjectStartat(String projectStartat) {
        ProjectStartat = projectStartat;
    }

    public String getProjectEndat() {
        return ProjectEndat;
    }

    public void setProjectEndat(String projectEndat) {
        ProjectEndat = projectEndat;
    }

    public String getLeadingPeople() {
        return leadingPeople;
    }

    public void setLeadingPeople(String leadingPeople) {
        this.leadingPeople = leadingPeople;
    }

    //模糊查询
    public String getNameStr() {
        return "%" + name + "%";
    }


    @Override
    public String toString() {
        return "ProjectSearchVO{" +
                "name='" + name + '\'' +
                ", projectTypeName='" + projectTypeName + '\'' +
                ", constructionDepartmentName='" + constructionDepartmentName + '\'' +
                ", creatorRealName='" + creatorRealName + '\'' +
                ", ProjectStartat='" + ProjectStartat + '\'' +
                ", ProjectEndat='" + ProjectEndat + '\'' +
                ", leadingPeople='" + leadingPeople + '\'' +
                '}';
    }
}
