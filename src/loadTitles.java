/**
 * Created by alittleprincefan on 10/1/2015.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;


public class loadTitles {
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

    public static HashMap<String, Integer> getTitles(){
        return                  getTitles(Integer.MAX_VALUE)      ;
    }

        public static HashMap<String, Integer> getTitles(int rows){
if (initalized==false)
    return null;

    HashMap<String,Integer>        temp=new HashMap<String,Integer>()      ;
    int max=0;
    int res=0;
    try {
    st = con.createStatement();
    rs =   st.executeQuery("select * from wikiTitles order by id desc limit 50 ");
        while (rs.next() && i<rows)
           // Integer.parseInt( rs.getString(1));
        temp.put(rs.getString(2),rs.getInt(1));

    }
        catch (Exception x) {
            x.printStackTrace();


        }
    if (st != null) {
        try {

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return temp;
}




}
