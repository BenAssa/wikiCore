/**
 * Created by alittleprincefan on 10/1/2015.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.jhu.nlp.wikipedia.*;



public class lxml {
    public static int i=0;
    public static void main(String[] args) {

        String filename="/run/shm/enwiki-20150901-pages-meta-current27.xml-p029625001p047687611";


        WikiXMLParser wxsp = WikiXMLParserFactory.
                getSAXParser(filename);

        try {

            wxsp.setPageCallback(new PageCallbackHandler() {
                public void process(WikiPage page) {
                    //System.out.print(page.getTitle());

                    if (!page.isSpecialPage())
                    {
                        i++;
                        System.out.print(page.getTitle() +"_____"+page.isSpecialPage()+"_"+page.isRedirect()+"+"+page.isStub());
                    }
                }
            });

            wxsp.parse();

        }catch(Exception e) {
            e.printStackTrace();
        }



        System.out.print(i);



    }
}
