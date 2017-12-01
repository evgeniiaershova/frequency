import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class FindMostCommonlyOccuringWord {

    public static void main(String[] args) {
        String text = "Есть много вариантов Lorem Ipsum, но большинство из них имеет не всегда приемлемые модификации, например, юмористические вставки или слова, которые даже отдалённо не напоминают латынь. Если вам нужен Lorem Ipsum для серьёзного проекта, вы наверняка не хотите какой-нибудь шутки, скрытой в середине абзаца. Также все другие известные генераторы Lorem Ipsum используют один и тот же текст, который они просто повторяют, пока не достигнут нужный объём. Это делает предлагаемый здесь генератор единственным настоящим Lorem Ipsum генератором. Он использует словарь из более чем 200 латинских слов, а также набор моделей предложений. В результате сгенерированный Lorem Ipsum выглядит правдоподобно, не имеет повторяющихся абзацей или \"невозможных\" слов.";
        List<String> ar = new ArrayList<String>(Arrays.asList(text
                .replaceAll("\\p{P}", "")
                .toLowerCase()
                .split(" ")));
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : ar) {
            System.out.println(word);
            map.put(word, Collections.frequency(ar, word));

        }
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
           System.out.println(key + " = " + value);

       }
    }

}
