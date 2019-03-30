package strings.lecture;

import java.util.HashMap;

/**
 * Created by jaynehsu on 3/18/19.
 */
public class Letter {
    public static Letter createDictionary(String[] words) {
        Letter dictionary = new Letter();

        for (String word : words) {
            Letter iter = dictionary;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!iter.nextLetters.containsKey(c)) {
                    iter.nextLetters.put(c, new Letter(c));
                }
                iter = iter.nextLetters.get(c);
            }
            iter.end = true;
        }

        return dictionary;
    }

        public char c;
        public boolean end = false;
        private int hit = 0;

        public HashMap<Character, Letter> nextLetters = new HashMap<>();

        public Letter() {
        }

        public Letter(char c) {
            this.c = c;
        }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public static Letter createDictionary(String str) {
        Letter dictionary = new Letter();
        for (int i = str.length() - 1; i >= 0; i--) {
            String sub = str.substring(i, str.length());
            addToDictionary(dictionary, sub);
        }
        return dictionary;
    }



    public static void addToDictionary(Letter dictionary, String sub) {
        int i = 0;
        while (i < sub.length()) {
            char c = sub.charAt(i);
            if (dictionary.nextLetters.containsKey(c)) {
                Letter l = dictionary.nextLetters.get(c);
                l.setHit(l.getHit() + 1);
                dictionary.nextLetters.put(c, l);
                dictionary = l;
            } else {
                Letter l = new Letter(c);
                l.setHit(1);
                dictionary.nextLetters.put(c, l);
                dictionary = l;
            }
            i++;
        }
    }
}
