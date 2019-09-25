package com.qf.el;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int age;
    private String name;
    private Date birthday;





    public String getBirthStr(){//解析成的属性就是birthStr
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(birthday);
        return format;
    }



    public User() {
    }

    public User(int age, String name, Date birthday) {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
