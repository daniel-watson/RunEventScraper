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
public class DetailPageLink {
    private String URL;

    public DetailPageLink() {
        
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    

    @Override
    public String toString() {
        return "Link{" + "URL=" + URL + '}';
    }
    
    public void getDetailPageURLs(String URL) {
        try {
            //use Jsoup connect to point it to the correct page
            //use .get or the get HTTP protocol toreturn the web page.
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla")
                    .timeout(3000)
                    .get();
            // get page title
            String title = doc.title();
            
            //Finds matching elements. it will look in for a class named evntTitle.
            //It will then save any <ahref> links to the list links
            Elements links = doc.select(".evntTitle > a[href]");
            System.out.println(links.size());
            
            //counter ensure i only recieve 10 links
            int i = 1;
            for (Element link : links) {
                // get the value from href attribute
                //the if statement checks whether the link is for a details page or and online entry form
                //returning online detail page links
                if( link.attr("href").contains("viewevent") ){
                    System.out.println("\nLink : " + "http://www.runnersworld.co.uk" + link.attr("href"));
                    System.out.println("Race Title : " + link.text());
                    System.out.println(i++);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
