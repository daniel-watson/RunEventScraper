/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runeventscraper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author danielwatson
 */
public class RunEventScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try{
        String url = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=";
        //use Jsoup connect to point it to the correct page
        //use .get or the get HTTP protocol toreturn the web page.
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla")
                .timeout(3000)
                .get();
        // get page title
        String title = doc.title();
        
        //Finds matching elements. it will look in for a class named paging.
        //It will then save any <ahref> links to the list links
        Elements links = doc.select(".paging > a[href]");
        System.out.println(links.size());  
    
    } catch (IOException e) {
    e.printStackTrace();
}
}
    }

