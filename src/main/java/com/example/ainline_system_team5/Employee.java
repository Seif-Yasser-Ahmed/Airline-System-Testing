package com.example.ainline_system_team5;

import java.util.Map;

public class Employee extends Person{
//    boolean isAdmin=false;
    float salary;

    public Employee(String fname, String lname) {
        super(fname, lname);
    }
    public Employee(String fname, String lname, int id, String pass, String mail, String phone, String add) {
        super(fname, lname, id, pass, mail, phone, add);
    }
    public Object getPersonDetailsbyID(int id){
        Map idmap=getIdmap();
        return idmap.get(id);
    }
}
