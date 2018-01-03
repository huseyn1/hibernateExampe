
package com.huseyn.hibernateexample;

import entity.Human;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import services.DBserviceWithHibernate;
import util.XMLParser;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        
        Human human = new Human();
        human.setId(BigDecimal.ONE);
        human.setName("name");
        human.setAge(new Date());
        
        DBserviceWithHibernate.addHuman(human);
        Human human1 = DBserviceWithHibernate.getHuman(2);
        
        List<Human> list =  DBserviceWithHibernate.getHumansbyName("huseyn");
        
        DBserviceWithHibernate.updateHumans(human);
        
        List<Human> humans = XMLParser.parseProductLinks("xml url linki");
        
        DBserviceWithHibernate.addHumans(humans);
    }
    
}
