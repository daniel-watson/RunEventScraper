package WebScraperForLinks;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielwatson
 */
public abstract class Link {
    private String url;
    private Document doc;
    
    public Link(String url){
        this.url = url;
    }
    
    public Document connectToLink(){
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

    @Override
    public String toString() {
        return "url=" + url;
    }
    
    
}
