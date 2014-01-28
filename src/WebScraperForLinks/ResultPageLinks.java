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
import java.util.ArrayList;


/**
 *
 * @author danielwatson
 */
public class ResultPageLinks{
    
    private String url;
    private Document doc;
    private ArrayList<String> resultList;
    
    public ResultPageLinks(){
        resultList = new ArrayList<String>();
    }
    
    public Document connectToLink(String url){
        try{
            //use Jsoup connect to point it to the correct page
            //use .get or the get HTTP protocol toreturn the web page.
             doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(3000)
                    .get();                       
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
        
    }
    public ArrayList getUrls(String url) {
        doc = connectToLink(url);
        //Finds matching elements. it will look in for a class named evntTitle.
        //It will then save any <ahref> links to the list links
        Elements links = doc.select("table.paging tbody tr td a");
        int i = 0;
        for (Element link : links){
            if( link.attr("href").endsWith("11") )
            {
                break;
            }
            String s =  "http://www.runnersworld.co.uk/events/" + link.attr("href");
            resultList.add(i,s);
            i++;
        }
        return resultList;
    }
    public void displayDetailURLs(){
        for (String link : resultList)
        {
            System.out.println(link);
        }
    }
}

