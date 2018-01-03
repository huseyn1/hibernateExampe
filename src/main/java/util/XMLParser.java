
package util;

import entity.Human;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

    public static List<Human> parseProductLinks(String url) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Human> humans = new ArrayList<>();
        
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        org.w3c.dom.Document xmlDoc = docBuilder.parse(url);
        List <String> urlList = new ArrayList<>();
        
        NodeList humanNodes = xmlDoc.getElementsByTagName("human");//xml faylin icinde human elementi var
            for (int i=0; i<humanNodes.getLength();i++){
               Node humanNode = humanNodes.item(i);
               NodeList humanChildren = humanNode.getChildNodes();
               Node idNode = humanChildren.item(0);
               Node nameNode = humanChildren.item(1);
               Node ageNode = humanChildren.item(3);
               
               Human human = new Human();
//               human.setId(Integer.parseInt(idNode.getTextContent()));
               human.setName(nameNode.getTextContent());
               
               String dateStr = ageNode.getTextContent();
               Date dt = sdf.parse(dateStr);
               human.setAge(dt);
               humans.add(human);
            }
        return humans;
    }
    
}
