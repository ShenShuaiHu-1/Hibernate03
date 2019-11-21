package com.ssh.dao;

import com.ssh.entity.Emp;

import java.util.List;

/**
 * @author ShenShuaiHu
 * @create 2019-11-21-11:00
 */
public interface EmpDao {
    List<Emp> findAll();

}
