package com.ssh.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * hibernate 工具类
 * @author ShenShuaiHu
 * @create 2019-11-21-11:05
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    static {
        //1.获取SessionFactory 会话工厂
        sessionFactory = new Configuration().configure().buildSessionFactory();
        //2.生产会话 通过opensession 获取session对象
        session = sessionFactory.openSession();
        //3.开启事务
        transaction = session.beginTransaction();
    }
    public static Session getSession() {
        return session;
    }

    public static Query getQuery(String hql){
        return session.createQuery(hql);
    }

    public static void closeSession() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
