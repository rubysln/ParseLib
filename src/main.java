import Settings.Parser;
import habr.*;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        ParserWorker<ArrayList<String>> parser = new ParserWorker<>(new HabraSettings(1, 5));
        parser.setParser(new HabrParser());
        parser.getOnCompletedList().add(new Completed());
        parser.getOnNewDataList().add(new NewData());
        parser.Start();
    }
}
