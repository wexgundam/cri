package com.critc.cri.model;

/**
 * Created by rs on 2019-8-26.
 */
public class RailwayInformationSystem {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Integer RIOPI_ID;

 /**
     *
     */
    private String RIOPI_NAME;

    /**
     *项目类型编码，来源系统字典“项目类型”
     */

    private String PROJECT_TYPE_CODE;

    /**
     *项目类型名称，来源系统字典“项目类型”
     */
    private  String PROJECT_TYPE_NAME;

    /**
     *项目进度编码，来源系统字典“项目进度
     */
    private  String PROJECT_PROGRESS_CODE;

    /**
     *项目进度名称，来源系统字典“项目进度”
     */
    private  String PROJECT_PROGRESS_NAME;

    /**
     *通过评审的需求分析报告
     */
    private  String  REVIEW_PASSED_DAR;

    /**
     *通过评审的网络安全等级定级
     */
    private String REVIEW_PASSED_CPC;

    /**
     *通过评审的总体技术方案
     */
    private String REVIEW_PASSED_TTS;

    /**
     *通过评审的可行性研究报告
     */
    private  String REVIEW_PASSED_FSR;

    /**
     *建设单位Id
     */
    private Integer CONSTRUCTION_DEPARTMENT_ID;

    /**
     *建设单位名称
     */
    private  String  CONSTRUCTION_DEPARTMENT_NAME;

    /**
     *
     */
    private Integer ORDER_INDEX;

    /**
     *
     */
    private Integer CREATOR_ID;

    /**
     *
     */
    private String CREATOR_REAL_NAME;
    /**
     *
     */
    private String CREATED_AT;
    /**
     *
     */
    private Integer LAST_EDITOR_ID;
    /**
     *
     */
    private String LAST_EDITOR_REAL_NAME;
    /**
     *
     */
    private String LAST_EDITED_AT;


    @Override
    public String toString() {
        return "RailwayInformationSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", RIOPI_ID=" + RIOPI_ID +
                ", RIOPI_NAME='" + RIOPI_NAME + '\'' +
                ", ORDER_INDEX=" + ORDER_INDEX +
                ", CREATOR_ID=" + CREATOR_ID +
                ", CREATOR_REAL_NAME='" + CREATOR_REAL_NAME + '\'' +
                ", CREATED_AT='" + CREATED_AT + '\'' +
                ", LAST_EDITOR_ID=" + LAST_EDITOR_ID +
                ", LAST_EDITOR_REAL_NAME='" + LAST_EDITOR_REAL_NAME + '\'' +
                ", LAST_EDITED_AT='" + LAST_EDITED_AT + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getRIOPI_ID() {
        return RIOPI_ID;
    }

    public String getRIOPI_NAME() {
        return RIOPI_NAME;
    }

    public Integer getORDER_INDEX() {
        return ORDER_INDEX;
    }

    public Integer getCREATOR_ID() {
        return CREATOR_ID;
    }

    public String getCREATOR_REAL_NAME() {
        return CREATOR_REAL_NAME;
    }

    public String getCREATED_AT() {
        return CREATED_AT;
    }

    public Integer getLAST_EDITOR_ID() {
        return LAST_EDITOR_ID;
    }

    public String getLAST_EDITOR_REAL_NAME() {
        return LAST_EDITOR_REAL_NAME;
    }

    public String getLAST_EDITED_AT() {
        return LAST_EDITED_AT;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRIOPI_ID(Integer  RIOPI_ID) {
        this.RIOPI_ID = RIOPI_ID;
    }

    public void setRIOPI_NAME(String RIOPI_NAME) {
        this.RIOPI_NAME = RIOPI_NAME;
    }

    public void setORDER_INDEX(int ORDER_INDEX) {
        this.ORDER_INDEX = ORDER_INDEX;
    }

    public void setCREATOR_ID(Integer CREATOR_ID) {
        this.CREATOR_ID = CREATOR_ID;
    }

    public void setCREATOR_REAL_NAME(String CREATOR_REAL_NAME) {
        this.CREATOR_REAL_NAME = CREATOR_REAL_NAME;
    }

    public void setCREATED_AT(String CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public void setLAST_EDITOR_ID(Integer LAST_EDITOR_ID) {
        this.LAST_EDITOR_ID = LAST_EDITOR_ID;
    }

    public void setLAST_EDITOR_REAL_NAME(String LAST_EDITOR_REAL_NAME) {
        this.LAST_EDITOR_REAL_NAME = LAST_EDITOR_REAL_NAME;
    }

    public void setLAST_EDITED_AT(String LAST_EDITED_AT) {
        this.LAST_EDITED_AT = LAST_EDITED_AT;
    }


    public String getPROJECT_TYPE_CODE() {
        return PROJECT_TYPE_CODE;
    }

    public void setPROJECT_TYPE_CODE(String PROJECT_TYPE_CODE) {
        this.PROJECT_TYPE_CODE = PROJECT_TYPE_CODE;
    }

    public String getPROJECT_TYPE_NAME() {
        return PROJECT_TYPE_NAME;
    }

    public void setPROJECT_TYPE_NAME(String PROJECT_TYPE_NAME) {
        this.PROJECT_TYPE_NAME = PROJECT_TYPE_NAME;
    }

    public String getPROJECT_PROGRESS_CODE() {
        return PROJECT_PROGRESS_CODE;
    }

    public void setPROJECT_PROGRESS_CODE(String PROJECT_PROGRESS_CODE) {
        this.PROJECT_PROGRESS_CODE = PROJECT_PROGRESS_CODE;
    }

    public String getPROJECT_PROGRESS_NAME() {
        return PROJECT_PROGRESS_NAME;
    }

    public void setPROJECT_PROGRESS_NAME(String PROJECT_PROGRESS_NAME) {
        this.PROJECT_PROGRESS_NAME = PROJECT_PROGRESS_NAME;
    }

    public String getREVIEW_PASSED_DAR() {
        return REVIEW_PASSED_DAR;
    }

    public void setREVIEW_PASSED_DAR(String REVIEW_PASSED_DAR) {
        this.REVIEW_PASSED_DAR = REVIEW_PASSED_DAR;
    }

    public String getREVIEW_PASSED_CPC() {
        return REVIEW_PASSED_CPC;
    }

    public void setREVIEW_PASSED_CPC(String REVIEW_PASSED_CPC) {
        this.REVIEW_PASSED_CPC = REVIEW_PASSED_CPC;
    }

    public String getREVIEW_PASSED_TTS() {
        return REVIEW_PASSED_TTS;
    }

    public void setREVIEW_PASSED_TTS(String REVIEW_PASSED_TTS) {
        this.REVIEW_PASSED_TTS = REVIEW_PASSED_TTS;
    }

    public String getREVIEW_PASSED_FSR() {
        return REVIEW_PASSED_FSR;
    }

    public void setREVIEW_PASSED_FSR(String REVIEW_PASSED_FSR) {
        this.REVIEW_PASSED_FSR = REVIEW_PASSED_FSR;
    }

    public Integer getCONSTRUCTION_DEPARTMENT_ID() {
        return CONSTRUCTION_DEPARTMENT_ID;
    }

    public void setCONSTRUCTION_DEPARTMENT_ID(Integer CONSTRUCTION_DEPARTMENT_ID) {
        this.CONSTRUCTION_DEPARTMENT_ID = CONSTRUCTION_DEPARTMENT_ID;
    }

    public String getCONSTRUCTION_DEPARTMENT_NAME() {
        return CONSTRUCTION_DEPARTMENT_NAME;
    }

    public void setCONSTRUCTION_DEPARTMENT_NAME(String CONSTRUCTION_DEPARTMENT_NAME) {
        this.CONSTRUCTION_DEPARTMENT_NAME = CONSTRUCTION_DEPARTMENT_NAME;
    }
}
