/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author danielwatson
 */
public class AllResultPagesLinks extends Link{
    private String url;
    //private Document doc;
    
    public AllResultPagesLinks(String url){
        super(url);
    }
   
    
    public String getAllResultPageUrls(){ 
        String s = "";
              Document doc = connectToLink();

            Elements links = doc.select("table.paging tbody tr td a");
            // System.out.println(links.size());
            for (Element link : links){
                if( link.attr("href").endsWith("11") )
                {
                    break;
                }
                 s = s + "\nLink : " + "http://www.runnersworld.co.uk/events/" + link.attr("href");
            }
            return s;
    }
}

