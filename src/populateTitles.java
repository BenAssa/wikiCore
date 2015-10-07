/**
 * Created by alittleprincefan on 10/1/2015.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.HashSet;


public class populateTitles {
   public static int i=0;
    static Connection con = null;
    static Statement st = null;
    static ResultSet rs = null;
    public static boolean initalized=false;
                         static int currentID=0;


    public static String validWord(String word) {
        char t='z'+1;
        if (word.length()>170 )
            return null;
        for (int i = 0; i < word.length(); i++) {
            //   if (word.charAt(i) == ' '|| word.charAt(i) == '_')
            //   word = word.substring(0, i) + t + word.substring(i + 1);

            if (word.charAt(i) < '0' || word.charAt(i) > 'z' + 1)
                return null;
        }
        return word;

    }

    public static boolean initalize(){



        String url = "jdbc:postgresql://localhost:5432/wikipedia";
        String user = "yaear";
        String password = "vDApaCFA9WX5";

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(url, user, password);
            try{
                st = con.createStatement();
            }catch(Exception x) {
                x.printStackTrace();

            }
            initalized=true;

return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
               return false;

        }
    }
    public static boolean eraseData(){
                                            return true;



    }
public static  int insertTitle(String Title){
if (initalized==false)
    return -1;
    int max=0;
    int res=0;
    try {
        if (st==null){

            System.err.println("WTFF");
            return 0;
        }
        st.execute("insert into  wikiTitles(title) values('"   +Title+"')");
  /*  rs =   st.executeQuery("select id from wikiTitles order by id desc limit 1;");
       if (rs.next())
         max= Integer.parseInt( rs.getString(1));
                if (max>currentID){
                    currentID=max;
                    return max;
                }
            System.err.println("mmm"+max);
        res= Integer.parseInt(rs.getString(1));    */
    }
        catch (Exception x) {
            x.printStackTrace();


        }

    return res;
}


public static void main(String[] args) {
    int[] mmm = new int[180];

    //Trie<Integer> st = new Trie<Integer>();
    //HashSet<String> st=new HashSet<String>();
    int i=0;
    int i2=0;
    int i3=0;

                     initalize();
    try (BufferedReader br = new BufferedReader(new FileReader("titles"))) {
        String line;
        String title="";
        while ((line = br.readLine()) != null) {
            i++;
            line=line.toLowerCase();
            if (validWord(line)!=null) {
          //      insertTitle(line);
                if (title.length()<5000){
                title=title+"'),('"+line;
                }
                else
                {
                    insertTitle(title);

                title="";
                }
                               i2++;
                mmm[line.length()]++;
            }
            if (i%10000==0)   {
                System.err.println(i+"    "+i2);
                //return;

            }
        }
    }catch (Exception e)
    {           // handle exception

        System.err.println(e.getMessage()); // handle exception
        System.err.println(e.getLocalizedMessage()); // handle exception
        System.err.println(e.toString()); // handle exception


    }
        String filename="/run/shm/enwiki-20150901-pages-meta-current27.xml-p029625001p047687611";
    initalize();


            try {
                if (rs != null) {
                    rs.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    if (st != null) {
        try {

            st.close();
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



        //System.out.print(i);



    }
}
