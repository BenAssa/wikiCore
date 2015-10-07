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



public class lxml2 {
   public static int i=0;
    public static void main(String[] args) {

        String filename="/run/shm/enwiki-20150901-pages-meta-current27.xml-p029625001p047687611";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        String url = "jdbc:postgresql://localhost:5432/wikipedia";
        String user = "yaear";
        String password = "vDApaCFA9WX5";
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT id from wikititles order by id desc limit 1");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       // WikiXMLParser wxsp = WikiXMLParserFactory.
               // getSAXParser(filename);

      /*  try {

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
        }                   */



        System.out.print(i);



    }
    }
