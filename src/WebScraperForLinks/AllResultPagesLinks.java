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
public class AllResultPagesLinks {
    
    public AllResultPagesLinks(){
    }
    
    //    String url      = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=";
    //                       http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntDate=a:fut&cp=1
    //    String urlPage2 = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntDate=a:fut&cp=2";
    //    String urlPage3 = "http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntDate=a:fut&cp=3";
    //                       http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntDate=a:fut&evntWheelChairAccessible=1&distance=10&evntSurface=Road&cp=2
    
    
    public void createUrl(String url){
        try{
            //use Jsoup connect to point it to the correct page
            //use .get or the get HTTP protocol toreturn the web page.
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(3000)
                    .get();
//            Elements table = doc.getElementsByClass(".paging td");
//            //Elements links = table.getElementsByTag("a");
//            for (Element link: table) {
//                String href = link.attr("href");
//                System.out.println(href);
//            }
            
            Elements links = doc.select("table.paging tbody tr td a");
            //Elements links = block.getElementsByTag("a");
            System.out.println(links.size());
            for (Element link : links){
                System.out.println("\nLink : " + "http://www.runnersworld.co.uk" + link.attr("href"));
                System.out.println(link);
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

