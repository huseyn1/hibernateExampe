
package services;

import util.HibernateConfigUtil;
import entity.Human;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class DBserviceWithHibernate {
    
    public static void addHuman(Human human){
        //session factory goturuldu
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        
        //sessiya yaradildi
        Session session = sessionFactory.openSession();
        
        //transaction acildi
        Transaction t = session.beginTransaction();
        
        session.merge(human);
        t.commit();
        session.close();   
        sessionFactory.close();
        
    }
    
    public static Human getHuman(int id){
        //session factory goturuldu
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        
        //sessiya yaradildi
        Session session = sessionFactory.openSession();
        
        //transaction acildi
        Transaction t = session.beginTransaction();
        
        Human human = (Human) session.get(Human.class, id);
        
        
        t.commit();
        session.close(); 
        sessionFactory.close();
        return human;
        
    }
     
    public static List<Human> getHumansbyName(String name){
          
        
        //session factory goturuldu
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        
        //sessiya yaradildi
        Session session = sessionFactory.openSession();
        //transaction acildi
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Human.class);
        criteria.add(Restrictions.like("NAME", name,MatchMode.ANYWHERE));
        List<Human> list = criteria.list();
        t.commit();
        session.close(); 
        sessionFactory.close();
        return list;
        
    }
      
    public static void updateHumans(Human human){
        //session factory goturuldu
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        
        //sessiya yaradildi
        Session session = sessionFactory.openSession();
        
        //transaction acildi
        Transaction t = session.beginTransaction();
        
        session.update(human);
        t.commit();
        session.close();   
        sessionFactory.close();
        
    }
    
    public static void addHumans(List<Human> humans){
       
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction t = session.beginTransaction();
        
            for (Human human : humans){
                session.merge(human);
                session.flush();
                session.clear();
            }
            
        t.commit();
        session.close();
        sessionFactory.close();
    
    }
            
    
}
