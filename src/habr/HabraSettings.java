package habr;
import Settings.ParserSettings;

public class HabraSettings extends ParserSettings {
    public HabraSettings (int start, int end){
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://habr.com/ru/all";
        PREFIX = "page{CurrentId}";
    }

}
