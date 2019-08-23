/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:cri2
 * Module Name:TODO:Module
 */
package com.critc.cri.model;

import java.util.Date;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 靳磊 created on 2019/8/2
 */
public class ExistingProject {
    /**
     *主键，由SEQ_T_EXISTING_PROJECT生成
     */
    private int id;
    /**
     *铁路信息系统主键
     */
    private int risId;
    /**
     *铁路信息系统名称
     */
    private String name;
    /**
     *名称
     */
    private String projectTypeCode;



    private String projectTypeName;
    private String projectProgressCode;
    private String projectProgressName;
    private String reviewPassedDar;
    private String reviewPassedCpc;
    private String reviewPassedTts;
    private String reviewPassedFsr;

    private int constructionDepartmentId;
    private String constructionDepartmentName;
    private Integer orderIndex;
    private Integer creatorId;
    private String creatorRealName;
    private Date createdAt;
    private Integer lastEditorId;
    private String lastEditorRealName;
    private Date lastEditedAt;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExistingProject people = (ExistingProject) o;

        return id == people.id;
    }
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "ExistingProject{" +
                "id=" + id +
                ", res_id=" + risId +
                ", name='" + name + '\'' +
                ", projectTypeCode='" + projectTypeCode + '\'' +
                ", projectTypeName='" + projectTypeName + '\'' +
                ", projectProgressCode='" + projectProgressCode + '\'' +
                ", projectProgressName='" + projectProgressName + '\'' +
                ", reviewPassedDar='" + reviewPassedDar + '\'' +
                ", reviewPassedCpc='" + reviewPassedCpc + '\'' +
                ", reviewPassedTts='" + reviewPassedTts + '\'' +
                ", reviewPassedFsr='" + reviewPassedFsr + '\'' +
                ", constructionDepartmentId=" + constructionDepartmentId +
                ", constructionDepartmentName='" + constructionDepartmentName + '\'' +
                ", orderIndex=" + orderIndex +
                ", creatorId=" + creatorId +
                ", creatorRealName='" + creatorRealName + '\'' +
                ", createdAt=" + createdAt +
                ", lastEditorId=" + lastEditorId +
                ", lastEditorRealName='" + lastEditorRealName + '\'' +
                ", lastEditedAt=" + lastEditedAt +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getRisId() {
        return risId;
    }

    public void setRisId(int risId) {
        this.risId = risId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectTypeCode() {
        return projectTypeCode;
    }

    public void setProjectTypeCode(String projectTypeCode) {
        this.projectTypeCode = projectTypeCode;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getProjectProgressCode() {
        return projectProgressCode;
    }

    public void setProjectProgressCode(String projectProgressCode) {
        this.projectProgressCode = projectProgressCode;
    }

    public String getProjectProgressName() {
        return projectProgressName;
    }

    public void setProjectProgressName(String projectProgressName) {
        this.projectProgressName = projectProgressName;
    }

    public String getReviewPassedDar() {
        return reviewPassedDar;
    }

    public void setReviewPassedDar(String reviewPassedDar) {
        this.reviewPassedDar = reviewPassedDar;
    }

    public String getReviewPassedCpc() {
        return reviewPassedCpc;
    }

    public void setReviewPassedCpc(String reviewPassedCpc) {
        this.reviewPassedCpc = reviewPassedCpc;
    }

    public String getReviewPassedTts() {
        return reviewPassedTts;
    }

    public void setReviewPassedTts(String reviewPassedTts) {
        this.reviewPassedTts = reviewPassedTts;
    }

    public String getReviewPassedFsr() {
        return reviewPassedFsr;
    }

    public void setReviewPassedFsr(String reviewPassedFsr) {
        this.reviewPassedFsr = reviewPassedFsr;
    }

    public int getConstructionDepartmentId() {
        return constructionDepartmentId;
    }

    public void setConstructionDepartmentId(int constructionDepartmentId) {
        this.constructionDepartmentId = constructionDepartmentId;
    }

    public String getConstructionDepartmentName() {
        return constructionDepartmentName;
    }

    public void setConstructionDepartmentName(String constructionDepartmentName) {
        this.constructionDepartmentName = constructionDepartmentName;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorRealName() {
        return creatorRealName;
    }

    public void setCreatorRealName(String creatorRealName) {
        this.creatorRealName = creatorRealName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getLastEditorId() {
        return lastEditorId;
    }

    public void setLastEditorId(Integer lastEditorId) {
        this.lastEditorId = lastEditorId;
    }

    public String getLastEditorRealName() {
        return lastEditorRealName;
    }

    public void setLastEditorRealName(String lastEditorRealName) {
        this.lastEditorRealName = lastEditorRealName;
    }

    public Date getLastEditedAt() {
        return lastEditedAt;
    }

    public void setLastEditedAt(Date lastEditedAt) {
        this.lastEditedAt = lastEditedAt;
    }


}
