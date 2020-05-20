package hangman;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WordProvider {
    public static List<String> getWords() {

        //set url to connect to
        final String url = "https://www.hangmanwords.com/words";
        List<String> wordList = new ArrayList<>();

        try {
            //fetch document
            Document document = Jsoup.connect(url).get();

            //access elements of document
            Elements words = document.select("div.expandable-subject").get(0).select("li");
            //System.out.println(words);

            for (Element word : words) {
                //System.out.println(word.text());

                wordList.add(String.valueOf(word));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return wordList;
    }
}
