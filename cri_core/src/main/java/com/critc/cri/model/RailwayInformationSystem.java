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
}
