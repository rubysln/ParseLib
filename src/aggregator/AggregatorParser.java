package aggregator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import settings.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class AggregatorParser implements Parser<ArrayList<String>> {

    @Override
    public ArrayList<String> Parse(Document document) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        Elements name = document.selectXpath("//*[@id=\"list_afisha\"]/div/div[5]/div/div[1]/h3/a");
        Elements date = document.getElementsByAttributeValue("class", "date_afisha");
        Elements duration = document.selectXpath("//*[@id=\"list_afisha\"]/div/div/div/div[3]/div/div[1]/div[1]");
        Elements PEGI = document.getElementsByAttributeValue("class", "value_limit");
        Elements pictures = document.selectXpath("//*[@id=\"list_afisha\"]/div/div[3]/div/a/img");
        for(int i = 0; i < name.size(); i++){
            try{
                Element nameElement = name.get(i);
                Element dateElement = date.get(i);
                Element durationElement = duration.get(i);
                Element PEGIElement = PEGI.get(i);
                Element picturesElement = pictures.get(i);
                String put = "Название спектакля: " + nameElement.text()
                        + ", Дата и время: " + dateElement.text() + ",\s"
                        + durationElement.text()
                        + ", Возрастное ограничение: " + PEGIElement.text() + "\s"
                        + "\n" + picturesElement.attr("src");
                list.add(put);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
