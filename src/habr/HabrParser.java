package habr;

import Settings.Parser;

import javax.swing.text.Document;
import java.util.ArrayList;

public class HabrParser implements Parser<ArrayList<String>> {
    @Override
    public ArrayList<String> Parse(Document document) {
        ArrayList<String> list = new ArrayList<>();
        return list;
    }
}
