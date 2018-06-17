package com.victor.coordinatorlayoutdemo.bean;

public class LangyaSimple {
    private String id;
    private String proj_id;
    private String title;
    private String desc;
    private String project_title;

    public LangyaSimple(String id, String proj_id, String title, String desc, String project_title) {
        this.id = id;
        this.proj_id = proj_id;
        this.title = title;
        this.desc = desc;
        this.project_title = project_title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProj_id() {
        return proj_id;
    }

    public void setProj_id(String proj_id) {
        this.proj_id = proj_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }
    @Override
    public String toString() {
        return "LangyaSimple{" +
                "id='" + id + '\'' +
                ", proj_id='" + proj_id + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", project_title='" + project_title + '\'' +
                '}';
    }
}
