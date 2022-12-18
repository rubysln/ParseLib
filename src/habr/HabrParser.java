package habr;

import Settings.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class HabrParser implements Parser<ArrayList<String>> {
    @Override
    public ArrayList<String> Parse(Document document) {
        ArrayList<String> list = new ArrayList<>();
        Elements articles = document.selectXpath("//*/div/h2/a/span");
        for(var e: articles){
            list.add(e.text());
        }
        return list;
    }
}
