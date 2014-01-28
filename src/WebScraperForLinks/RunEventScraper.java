/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

/**
 *
 * @author danielwatson
 */
public class RunEventScraper {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DetailPageLinks linky = new DetailPageLinks("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
        System.out.println(linky.getDetailURL());
        ResultPageLinks linkyRes = new ResultPageLinks("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
        System.out.println(linkyRes.getResultUrls());
    }
}

