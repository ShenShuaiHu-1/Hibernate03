package com.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ShenShuaiHu
 * @create 2019-11-20-14:42
 */
@Entity
public class Emp {
    private int id;
    private int gid;
    private String name;
    private int age;
    private int money;
    private String dname;

    public Emp() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gid", nullable = false)
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMonoey() {
        return money;
    }

    public void setMonoey(int monoey) {
        this.money = monoey;
    }

    @Basic
    @Column(name = "dname", nullable = false, length = 20)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", dname='" + dname + '\'' +
                '}';
    }

    @Basic
    @Column(name = "money", nullable = false)
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp emp = (Emp) o;

        if (id != emp.id) return false;
        if (gid != emp.gid) return false;
        if (age != emp.age) return false;
        if (money != emp.money) return false;
        if (name != null ? !name.equals(emp.name) : emp.name != null) return false;
        if (dname != null ? !dname.equals(emp.dname) : emp.dname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + money;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        return result;
    }

    public Emp(int gid, String name, int age, int money, String dname) {
        this.gid = gid;
        this.name = name;
        this.age = age;
        this.money = money;
        this.dname = dname;
    }
}
