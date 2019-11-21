import com.ssh.entity.Emp;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Before;

import java.io.Serializable;
import java.util.List;

public class Test {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @org.junit.Test
    public void test() {
        //1.获取SessionFactory 会话工厂
         sessionFactory = new Configuration().configure().buildSessionFactory();
        //2.生产会话 通过opensession 获取session对象
         session = sessionFactory.openSession();
        //3.开启一个事务
         transaction = session.beginTransaction();

        //4.1执行条件查询 load(要查询的实体类的类型,参数) load直接加载
        Emp emp = session.load(Emp.class,1);
        System.out.println(emp);
        /*//4.1.1缓存
        transaction.commit();//提交事务
        session.close();//关闭session
        System.out.println("**********************************************************************");
        session=sessionFactory.openSession();
        Transaction transaction1 = session.beginTransaction();*/
        Emp emp2 = session.load(Emp.class, 1);
        System.out.println(emp2);
        System.out.println("----------------------------------------------------------------------");
        //4.2执行条件查询 get(要查询的实体类的类型,参数)get 懒加载
        Emp getemp = session.get(Emp.class, 3);
        System.out.println(getemp);
        System.out.println("-----------------------------------------------------------------------");
        //4.3执行条件查询操作 hql语句
        String hql1 = "from Emp where id=:id";
        Query query = session.createQuery(hql1);
        query.setParameter("id", 22);//替换占位符
        Object o = query.uniqueResult();//只针对于已经知道只有一行结果时才能使用
        System.out.println(o);
        System.out.println("-----------------------------------------------------------------------");
        //5.查询全部
        Query query1 = session.createQuery("from Emp");
        List<Emp> list = query1.list();
        for (Emp emp1 : list) {
            System.out.println(emp1);
        }
        System.out.println("-----------------------------------------------------------------------");
        //5.1查询全部
        SQLQuery sqlQuery = session.createSQLQuery("select * from emp");
        sqlQuery.addEntity(Emp.class);
        List<Emp> list1 = sqlQuery.list();
        for (Emp emp1 : list1) {
            System.out.println(emp1);
        }
        System.out.println("------------------------------------------------------------------------");
       }

   /* @org.junit.Test
    public void testInsert() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        //增加
        Emp e=new Emp();
        e.setGid(2);
        e.setName("鼠标");
        e.setAge(19);
        e.setMoney(69);
        e.setDname("搬砖");
        Serializable save = session.save(e);
    }*/
    /*@org.junit.Test
    public void testDelete() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //删除
        Emp emp = session.get(Emp.class,23);
        session.delete(emp);
    }*/
}
