/**
 * Created by alittleprincefan on 10/1/2015.
 */
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
public class TimedRun {




   public static String validWord(String word) {
       char t='z'+1;
       if (word.length()>170 )
           return null;
       for (int i = 0; i < word.length(); i++) {
        //   if (word.charAt(i) == ' '|| word.charAt(i) == '_')
            //   word = word.substring(0, i) + t + word.substring(i + 1);

           if (word.charAt(i) < 'a'-2 || word.charAt(i) > 'z' + 1)
               return null;
       }
       return word;

   }

    public static void main(String[] args) {
        int[] mmm = new int[180];


}
