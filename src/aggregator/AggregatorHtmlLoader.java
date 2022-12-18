package aggregator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import settings.HtmlLoader;
import settings.ParserSettings;

import java.io.IOException;

public class AggregatorHtmlLoader implements HtmlLoader {
    private String url;
    public AggregatorHtmlLoader(ParserSettings settings){
        url = AggregatorSettings.BASE_URL;
    }

    @Override
    public Document getSourceByPageId(int id) throws IOException {
        return Jsoup.connect(url).get();
    }
}
