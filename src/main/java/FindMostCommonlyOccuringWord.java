import java.io.IOException;
import java.util.*;

public class FindMostCommonlyOccuringWord {
    public static void main(String[] args) throws Exception {

        String text = "Есть много вариантов Lorem Ipsum, но большинство из них имеет не всегда приемлемые модификации," +
                " например, юмористические вставки или слова, которые даже отдалённо не напоминают латынь. " +
                "Если вам нужен Lorem Ipsum для серьёзного проекта, вы наверняка не хотите какой-нибудь шутки, скрытой в середине абзаца. " +
                "Также все другие известные генераторы Lorem Ipsum используют один и тот же текст, который они просто повторяют," +
                " пока не достигнут нужный объём. Это делает предлагаемый здесь генератор единственным настоящим Lorem Ipsum генератором. " +
                "Он использует словарь из более чем 200 латинских слов, а также набор моделей предложений. " +
                "В результате сгенерированный Lorem Ipsum выглядит правдоподобно, не имеет повторяющихся абзацей или \"невозможных\" слов.";

        List<String> textToArray = getTextAsArray(text);
        findTheMostFrequentWord(textToArray);
    }

    private static List<String> getTextAsArray(String text) throws Exception {
        if (text == null ) {
            throw new Exception("The text is null, it was not defined.");        }
        else if (text.length() == 0) {
            throw new Exception("The text length is equal to zero.");
        }
        else {
            List<String> textToArray = new ArrayList<String>(Arrays.asList(text
                    .replaceAll("\\p{P}", "")
                    .toLowerCase()
                    .split(" ")));
            return textToArray;
        }
    }

    private static void findTheMostFrequentWord(List<String> textToArray) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int counter = 1;
        int frequency = 1;

        for (String word : textToArray) {
          /*  for (int i = 0; i < textToArray.size(); i++) {
                if (textToArray.get(i) == word) {
                    frequency++;
                    textToArray.remove(textToArray.get(i));
                }
            }*/
          Iterator it = textToArray.iterator();
          while(it.hasNext()){
              Object item = it.next();
              if(item == word) {
                  frequency++;
                  textToArray.remove(item);
              }
          }

            if (counter < frequency) {
                map.clear();
                map.put(word, frequency);
                counter = frequency;
            } else if (counter == frequency) {
                map.put(word, frequency);
            }
        }
        System.out.println(map.entrySet());
    }
}


