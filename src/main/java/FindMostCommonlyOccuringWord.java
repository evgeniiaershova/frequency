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

/*
        String text = null;
        String text = "";
        String text = "cat dog";
        String text = "test log test log ";
*/

        if (text == null ) {
            System.out.println("The text is null, it was not defined.");        }
        else if (text.length() == 0) {
            System.out.println("The text length is equal to zero.");
        }
        else findTheMostFrequentWord(text);

    }

    private static void findTheMostFrequentWord(String text) {
        List<String> textToArray = new ArrayList<String>(Arrays.asList(text
                .replaceAll("\\p{P}", "")
                .toLowerCase()
                .split(" ")));

        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        for (String word : textToArray) {
                map.put(word, Collections.frequency(textToArray, word));
        }

        Map.Entry<String, Integer> maxValue = map.entrySet().iterator().next();
         // find the largest frequency value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue.getValue()) {
                maxValue = entry;
            }
        }

        // check if there are words more than one word with max frequency value
        Map<String, Integer> rivalsMap = new LinkedHashMap<String, Integer>();
        if (maxValue.getValue() != 1) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue.getValue()) {
                    rivalsMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        if (rivalsMap.size() <= 1 ) {
            if (maxValue.getValue() != 1) {
                System.out.println("the most popular word is \"" + maxValue.getKey() + "\", it occurs " + maxValue.getValue() + " times.");
            }
            else {
                System.out.println("There's no word, which occurs more than once.");
            }
        }
        else {
            System.out.println("The most popular words are: " + rivalsMap.entrySet());
        }
    }
}


