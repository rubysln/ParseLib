package settings;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface HtmlLoader {
    Document getSourceByPageId(int id) throws IOException;
}
