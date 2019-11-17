package model;

import model.interf.IDivision;

public class Division implements IDivision {

    private Integer id;
    private String nameDivision;

    public Division(Integer id, String name){
        this.id=id;
        this.nameDivision=name;
    }
    public Division(String s){
        this.nameDivision=s;
    }
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
this.id=id;
    }

    @Override
    public String getName() {
        return nameDivision;
    }

    @Override
    public void setName(String name) {
this.nameDivision=name;
    }
}
