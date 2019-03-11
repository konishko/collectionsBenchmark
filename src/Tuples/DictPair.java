package Tuples;

import java.util.Comparator;

public class DictPair {
    private final String word;
    private int frequency;

    public DictPair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getWord() {
        return word;
    }

    public void inc(){
        this.frequency++;
    }

    public static final Comparator<DictPair> COMPARE_BY_FREQUENCY = new Comparator<DictPair>() {
        @Override
        public int compare(DictPair o1, DictPair o2) {
            return o1.frequency - o2.frequency;
        }
    };
}


