package com.ssh.dao;

import com.ssh.utils.HibernateUtils;
import com.ssh.entity.Emp;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author ShenShuaiHu
 * @create 2019-11-21-11:03
 */
public class EmpDaoimpl implements EmpDao {

    public List<Emp> findAll() {
        //1.获取session
        Session session = HibernateUtils.getSession();
        //2.创建hql语句
        String hql = "from com.ssh.entity.Emp";
        //3.创建query对象
        Query query = session.createQuery(hql);
        //4.进行查询
        List<Emp> list = query.list();
        //5.关闭
        HibernateUtils.closeSession();
        return list;
    }
    public List<Emp> selectQueryAll() {
        //1.创建hql语句
        String hql = "from com.ssh.entity.Emp";
        //2.创建query对象
        Query query =HibernateUtils.getQuery(hql);
        //3.进行查询
        List<Emp> list = query.list();
        //4.关闭
        HibernateUtils.closeSession();
        System.out.println("hbfdhjgfdhjgfbhj");
        return list;
    }
}
