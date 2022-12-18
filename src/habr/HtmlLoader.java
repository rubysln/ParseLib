package habr;

import Settings.ParserSettings;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HtmlLoader {
    String url;

    public HtmlLoader(ParserSettings settings){
        url = HabraSettings.BASE_URL + "/" + HabraSettings.PREFIX;
    }

    public org.jsoup.nodes.Document getSourceByPageId(int id) throws IOException {
        String currentURL = url.replace("{CurrentId}", Integer.toString(id));
        return Jsoup.connect(currentURL).get();
    }
}
