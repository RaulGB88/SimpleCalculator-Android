package com.practicas.pmdm.pmdm_t4a8_granel_raul.model;

public class Operator {

    private Integer id;
    private String name;
    private String descriptor;

    public Operator() {
    }

    public Operator(Integer id, String name, String descriptor) {
        this.id = id;
        this.name = name;
        this.descriptor = descriptor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public String toString() {
        return  name;
    }

}
