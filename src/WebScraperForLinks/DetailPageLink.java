/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author danielwatson
 */
public class DetailPageLink extends Link{
    private String url;
    //private Document doc;
    ArrayList<String> resultPages = new ArrayList<String>();
    Elements links = null;
    public DetailPageLink(String url) {
        super(url);
    }
    
    @Override
    public String toString() {
        return "Link{" + "URL=" + url + '}';
    }
    
    public String getURL() {
        String s ="";
        Elements links = getDetailPageURLs(url);
        for (Element link : links) {
            if( link.attr("href").contains("viewevent") ){
                s = s + "\nLink : " + "http://www.runnersworld.co.uk" + link.attr("href");
                //System.out.println("Race Title : " + link.text());
                //System.out.println(i++);
            }
        }
        return s;
    }
    
    
    public Elements getDetailPageURLs(String URL) {
        Document doc = connectToLink();
        //Finds matching elements. it will look in for a class named evntTitle.
        //It will then save any <ahref> links to the list links
        Elements links = doc.select(".evntTitle > a[href]");
        //System.out.println(links.size());
        return links;
    }
}
