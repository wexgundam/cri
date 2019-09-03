package com.critc.cri.model;


import java.util.Date;

/**
 *
 * what: 部门实体类
 *
 *
 * @author 李红 created on 2017年10月30日
 */
public class Riopi {

    /**
     *主键，由SEQ_T_EXISTING_PROJECT生成
     */
    private int id;
    /**
     *铁路信息系统主键
     */
    private String name;
    /**
     *名称
     */
    private int parentId;
    /**
     *上级目录
     */
    private int bmDepartmentId;
    /**
     *业务管理部门主键
     */
    private String  bmDepartmentName;
    /**
     *业务管理部门名称
     */
    private Integer displayOrder;
    /**
     *排序
     */
    private String note;
    /**
     *备注
     */
    private Integer creatorId;
    /**
     *创建人ID
     */
    private String creatorRealName;
    /**
     *创建人实名
     */
    private Date createdAt;
    /**
     *创建时间
     */
    private Integer lastEditorId;
    /**
     *最后修改人ID
     */
    private String lastEditorRealName;
    /**
     *最后修改人NAME
     */
    private Date lastEditedAt;
    /**
     *最后修改时间
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Riopi riopi = (Riopi) o;

        return getId() == riopi.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Riopi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", bmDepartmentId=" + bmDepartmentId +
                ", bmDepartmentName='" + bmDepartmentName + '\'' +
                ", displayOrder=" + displayOrder +
                ", note='" + note + '\'' +
                ", creatorId=" + creatorId +
                ", creatorRealName='" + creatorRealName + '\'' +
                ", createdAt=" + createdAt +
                ", lastEditorId=" + lastEditorId +
                ", lastEditorName='" + lastEditorRealName + '\'' +
                ", lastEditedAt=" + lastEditedAt +
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

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getBmDepartmentId() {
        return bmDepartmentId;
    }

    public void setBmDepartmentId(int bmDepartmentId) {
        this.bmDepartmentId = bmDepartmentId;
    }

    public String getBmDepartmentName() {
        return bmDepartmentName;
    }

    public void setBmDepartmentName(String bmDepartmentName) {
        this.bmDepartmentName = bmDepartmentName;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
