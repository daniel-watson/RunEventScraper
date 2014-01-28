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
public class ResultPageLinks extends Link{
    private String url;
    //private Document doc;
    
    public ResultPageLinks(String url){
        super(url);
    }
    
    
    public String getResultUrls(){
        String s = "";
        Elements links = getResultPageUrls();

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
    
     public Elements getResultPageUrls() {
        Document doc = connectToLink();
        //Finds matching elements. it will look in for a class named evntTitle.
        //It will then save any <ahref> links to the list links
        Elements links = doc.select("table.paging tbody tr td a");
        //System.out.println(links.size());
        return links;
    }
}

