/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

import org.jsoup.nodes.Element;

/**
 *
 * @author danielwatson
 */
public class RunEventScraper {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DetailPageLinks linky = new DetailPageLinks();
        linky.getUrls("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntDate=a:fut&cp=5");
        linky.displayDetailURLs();
        
        ResultPageLinks linkyRes = new ResultPageLinks();
        linkyRes.getUrls("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
        linkyRes.displayDetailURLs();
       // AllEvents AL = new AllEvents();
 //       AL.processAllEventLinks();
       // AL.displayDetailURLs();
        
       // DetailPageLinks
    }
}

