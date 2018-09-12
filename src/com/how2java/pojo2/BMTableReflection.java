package com.how2java.pojo2;

public class BMTableReflection {
    private int id;
    private String name;
    private int qq;
    private String type;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getQq(){
        return qq;
    }
    public String getType(){
        return type;
    }

    public void setId(int id){
        this.id=id;
    }
    public  void setName(String name){
        this.name=name;
    }
    public void setQq(int qq){
        this.qq=qq;
    }
    public void setType(String type) {
        this.type = type;
    }
}
