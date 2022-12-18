package habr;

import habr.HabrSettings;
import org.jsoup.Jsoup;
import settings.HtmlLoader;
import settings.ParserSettings;

import java.io.IOException;

public class HabrHtmlLoader implements HtmlLoader {
    private String url;

    public HabrHtmlLoader(ParserSettings settings){
        url = HabrSettings.BASE_URL + "/" + HabrSettings.PREFIX;
    }

    public org.jsoup.nodes.Document getSourceByPageId(int id) throws IOException {
        String currentURL = url.replace("{CurrentId}", Integer.toString(id));
        return Jsoup.connect(currentURL).get();
    }
}
