
import java.util.*;

/**
 * @author ji.xie
 * @Filename MorseCodeConvenice.java
 * @description leetcode: 804. Unique Morse Code Words
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/6/7 17:04</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class MorseCodeConvenice {

    private static final int WORD_LENGTH = 26;

    private static final String[] MORSE = new String[]
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    static int uniqueMorseRepresentations1(String[] words) {
        List<String> diff = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            boolean existFlag = true;
            String revWord = getRevWord(words[i]);
            for (String rev : diff) {
                if (rev.equals(revWord)) {
                    existFlag = false;
                    break;
                }
            }
            if (existFlag) {
                diff.add(revWord);
            }
        }

        return diff.size();
    }

    /**
     * 参考leetCode高榜:
     * 学习点:
     * 1.char a-z=>以a为参照,加 整数,可得到相应间隔char,被char 减,可得到间隔整数
     * 2.利用hashSet去重
     * <p>
     * 1技巧原理:
     *    char类型是可以运算的因为char在ASCII等字符编码表中有对应的数值
     *    所以,用int类型来接,则显示char之间相差值
     *        用char类型来接,则显示值对应的ASCII码
     */
    static int uniqueMorseRepresentations2(String[] words) {
        Set<String> diff = new HashSet<>();
        for (String word : words) {
            StringBuilder revWord = new StringBuilder();
            for (char c : word.toCharArray()) {
                System.out.println("word:" + (c - 'a'));
                revWord.append(MORSE[c - 'a']);
            }
            System.out.println("rev-word:" + revWord);
            diff.add(revWord.toString());
        }

        return diff.size();
    }

    private static String getRevWord(String word) {
        StringBuffer revWord = new StringBuffer();
        Map<String, String> wordMap = getWordMap();
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            System.out.println("k:" + String.valueOf(w[i]));
            revWord.append(wordMap.get(String.valueOf(w[i])));
        }
        System.out.println("transfer-word:" + revWord.toString());
        return revWord.toString();
    }

    private static Map getWordMap() {
        Map wordMap = new HashMap<String, String>(WORD_LENGTH);
        for (int i = 0; i < WORD_LENGTH; i++) {
            char c = (char) (i + 'a');
            wordMap.put(String.valueOf(c), MORSE[i]);
        }
        return wordMap;
    }

}