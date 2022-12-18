package habr;

import settings.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HabrParser implements Parser<HashMap<String, ArrayList<String>>> {
    private static final String imageFolder = "C:\\Java\\ParseLib\\Images";
    @Override
    public HashMap<String, ArrayList<String>> Parse(Document document) throws IOException {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        Elements id = document.selectXpath("//article");
        for(var e: id){
            String idValue = e.attr("id");
            ArrayList<String> title = new ArrayList<>();

            Elements titleElements = document.selectXpath("//*[@id=\""+idValue+"\"]/div/div/div/div/div/p");
            for(var j : titleElements){
                title.add(j.text());
            }
            map.put(e.selectXpath("//*[@id=\""+idValue+"\"]/div/h2/a/span").text(), title);
        }
        Elements pictures = document.selectXpath("//img[contains(@class,'tm-article-snippet__lead-image')]");
        for(var p : pictures){
            String pictureURL = p.attr("src");
            downloadPic(pictureURL);
        }
        return map;
    }

    private static void downloadPic(String url) throws IOException {
        Random random = new Random();
        String pictureName = random.toString() + ".jpg";

        URL urlImage = new URL(url);
        InputStream inputStream = urlImage.openStream();

        byte[] buffer = new byte[4096];
        int n = -1;

        OutputStream os =
                new FileOutputStream( imageFolder + "\\" + pictureName );

        while ( (n = inputStream.read(buffer)) != -1 ){
            os.write(buffer, 0, n);
        }

        os.close();

        System.out.println("Downloading picture...");
    }
}
