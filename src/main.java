import Settings.Parser;
import habr.*;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ParserWorker<ArrayList<String>> parser = new ParserWorker<>(new HabrParser());
        parser.setParser(new HabraSettings(0,1));
        parser.onComplitedList.add(new OnCompleted());
        parser.onNewDataList.add(new NewData());
        parser.Start();
        Thread.sleep(10000);
        parser.Abort();
    }
}
