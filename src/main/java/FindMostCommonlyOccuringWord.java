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
        Map<String, Integer> mapFr = createWordFrequencyMapVerLoop(textToArray);
        findTheMaxVal(mapFr);
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

    public static void findTheMaxVal(Map<String, Integer> map) {
        int count = 1;
        HashMap<String, Integer> newMap = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                newMap.clear();
                newMap.put(entry.getKey(), entry.getValue());
                count = entry.getValue();
            } else if (entry.getValue() == count) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("[Result]: " + newMap.entrySet());
    }

    private static Map<String, Integer> createWordFrequencyMap(List<String> textToArray) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Iterator it = textToArray.iterator();
        int run = 0;
        while (it.hasNext()) {
            String word = it.next().toString();
            int result = 0;
            List<String> ar = new ArrayList<String>(textToArray);
            Iterator iterator = ar.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next().toString();
                if (word.equals(item)) {
                    result++;
                    run ++;
                    iterator.remove();
                }
            }
            map.put(word, result);
        }
        System.out.println("Times run: " + run);
        return map;
    }


    //    private static Map<String, Integer> createWordFrequencyMap(List<String> textToArray) {
//        Map<String, Integer> map = new HashMap<>();
//        Iterator it = textToArray.iterator();
//        int runSum = 0;
//        while (it.hasNext()) {
//            String word = it.next().toString();
//            int[] fr = countFrequency(textToArray, word);
//            map.put(word, fr[1]);
//            runSum = runSum + fr[0];
////                map.put(word, countFrequency(textToArray, word));
//        }
//        System.out.println("Times run: " + runSum);
//        return map;
//    }


    private static int[] countFrequency(List<String> array, String word) {
        List<String> ar = new ArrayList<String>(array);
        int result = 0;
        int run = 0;
        Iterator it = ar.iterator();
        while (it.hasNext()) {
            String item = it.next().toString();
            if (word.equals(item)) {
                result++;
                run++;
                it.remove();
            }
        }
        return new int[]{run, result};
    }

    public static int[] frequency(Collection<?> c, Object o) {
        int result = 0;
        int run = 0;
        if (o == null) {
            for (Object e : c)
                if (e == null)
                    result++;
        } else {
            for (Object e : c) {
                if (o.equals(e)) {
                    result++;
                    run++;
                }
            }
        }
        return new int[]{run, result};
    }


    private static Map<String, Integer> createWordFrequencyMapVerLoop(List<String> textToArray) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> newList = new ArrayList<String>(textToArray);
        int run = 0;
        for (int i = 0; i < textToArray.size(); i++) {
            String wordToComp = textToArray.get(i);
            int result = 0;
            for (int j = 0; j < newList.size(); j++ ) {
                String word = newList.get(j);
                if (wordToComp.equals(word)) {
                    result++;
                    run++;
                }
            }
            textToArray.remove(wordToComp);
            map.put(wordToComp, result);
        }
        System.out.println("Times run: " + run);
        return map;
    }
}


