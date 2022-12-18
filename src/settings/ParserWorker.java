package settings;

import habr.HabrHtmlLoader;

import java.io.IOException;
import java.util.ArrayList;

public class ParserWorker<T> {
   private Parser<T> parser;
   private ParserSettings parserSettings;
   private HtmlLoader loader;
   private boolean isActivate;
   ArrayList<OnNewDataHandler> onNewDataList = new ArrayList<>();
   ArrayList<OnCompleted> onCompletedList = new ArrayList<>();

    public void setLoader(HtmlLoader loader) {
        this.loader = loader;
    }

    public ParserWorker(ParserSettings parserSettings) {
        this.parserSettings = parserSettings;
    }

    public void Start() throws IOException {
        isActivate = true;
        Worker();
    }
    public void Abort(){
        isActivate = false;
    }

    public void Worker() throws IOException {
        for(int i = parserSettings.getStartPoint(); i <= parserSettings.getEndPoint(); i++){
            if(!isActivate){
                onCompletedList.get(0).onCompleted(this);
                return;
            }
            T result = parser.Parse(loader.getSourceByPageId(i));
            onNewDataList.get(0).onNewData(this, result);
        }
        onCompletedList.get(0).onCompleted(this);
        isActivate = false;
    }

    public Parser<T> getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public ParserSettings getParserSettings() {
        return parserSettings;
    }

    public void setParserSettings(ParserSettings parserSettings) {
        loader = new HabrHtmlLoader(parserSettings);
        this.parserSettings = parserSettings;
    }

    public ArrayList<OnNewDataHandler> getOnNewDataList() {
        return onNewDataList;
    }

    public ArrayList<OnCompleted> getOnCompletedList() {
        return onCompletedList;
    }
}
