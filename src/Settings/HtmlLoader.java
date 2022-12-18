package Settings;

import habr.HabrSettings;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlLoader {
    String url;

    public HtmlLoader(ParserSettings settings){
        url = HabrSettings.BASE_URL + "/" + HabrSettings.PREFIX;
    }

    public org.jsoup.nodes.Document getSourceByPageId(int id) throws IOException {
        String currentURL = url.replace("{CurrentId}", Integer.toString(id));
        return Jsoup.connect(currentURL).get();
    }
}
