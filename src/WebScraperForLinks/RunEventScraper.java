/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

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
        
        DetailPageLink linky = new DetailPageLink("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
        System.out.println(linky.getURL());
        AllResultPagesLinks linkyRes = new AllResultPagesLinks("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
        System.out.println(linkyRes.getAllResultPageUrls());
    }
}

