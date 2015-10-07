import org.w3c.dom.Document;
import org.w3c.dom.*;
import java.util.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 * Created by alittleprincefan on 10/1/2015.
 */
public class cmlread {
    public static void main(String[] args) {

        try {
            System.out.println("Root element  " );

                    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new  File("/run/shm/enwiki-20150901-pages-meta-current27.xml-p029625001p047687611"));

            // normalize text representation
            doc.getDocumentElement().normalize();
            System.out.println("Root element of the doc is " +
                    doc.getDocumentElement().getNodeName());


            NodeList nodeList = doc.getElementsByTagName("title");

            //Iterating through the nodes and extracting the data.
            // NodeList  = doc.getDocumentElement().getChildNodes();
            //  Node firstPersonNode = nodeList.item(1);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node m = nodeList.item(i); //.getFirstChild();
                       /* if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){


                            Element firstPersonElement = (Element)firstPersonNode;

                            //-------
                            NodeList firstNameList = firstPersonElement.getElementsByTagName("first");
                            Element firstNameElement = (Element)firstNameList.item(0);

                            NodeList textFNList = firstNameElement.getChildNodes();
                            System.out.println("First Name : " +
                                    ((Node)textFNList.item(0)).getNodeValue().trim());

                            //-------
                            NodeList lastNameList = firstPersonElement.getElementsByTagName("last");
                            Element lastNameElement = (Element)lastNameList.item(0);

                            NodeList textLNList = lastNameElement.getChildNodes();
                            System.out.println("Last Name : " +
                                    ((Node)textLNList.item(0)).getNodeValue().trim());

                            //----
                            NodeList ageList = firstPersonElement.getElementsByTagName("age");
                            Element ageElement = (Element)ageList.item(0);

                          // NodeList textAgeList = ageElement.getChildNodes();
                           */
                //System.out.println(firstPersonNode.getLocalName());
                //System.out.println(firstPersonNode.getNamespaceURI());
                System.out.println(m.getNodeName());
                Node child = m.getLastChild();
                System.out.println(m.getNodeValue());

                if (child != null) {
                    System.out.println(child.getNodeName());
                    System.out.println(child.getNodeValue());
                    child = child.getNextSibling();

                }
                if (child != null) {
                    System.out.println(child.getNodeName());
                    System.out.println(child.getNodeValue());

                }
                System.out.println("-----------------------------" + i);


                //------


                //}//end of if clause


            }//end of for loop with s var


        } catch (SAXParseException err) {
            System.out.println("** Parsing error" + ", line "
                    + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());

        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();

        } catch (Throwable t) {
            t.printStackTrace();
        }
        //System.exit (0);

        //end of main


    }
}