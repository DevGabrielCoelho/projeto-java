package model;

public class Type {
    public int id;
    public String name;

    public Type(String name) {
        this.name = name;
    }

    public String getName(){
      return name;
    }
}