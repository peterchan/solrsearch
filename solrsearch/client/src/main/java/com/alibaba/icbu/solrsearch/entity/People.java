package com.alibaba.icbu.solrsearch.entity;

import org.apache.solr.client.solrj.beans.Field;

public class People {

    @Field
    private String id;
    @Field
    private String name;
    @Field
    private int    age;
    @Field
    private String sex_prop;
    @Field
    private String job_prop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex_prop() {
        return sex_prop;
    }

    public void setSex_prop(String sex_prop) {
        this.sex_prop = sex_prop;
    }

    public String getJob_prop() {
        return job_prop;
    }

    public void setJob_prop(String job_prop) {
        this.job_prop = job_prop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
