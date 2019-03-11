package BaseFrequencyDict;

import Tuples.DictPair;

import java.util.ArrayList;

abstract public class BaseFrequencyDict {
    abstract public void getFrequencyDict(String[] words);

    abstract public ArrayList<DictPair> getWordsByPrefix(String prefix);

    public long measureGettingFreqDict(String[] words){
        long startTime = System.nanoTime();
        getFrequencyDict(words);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public long measureGettingByPrefix(String prefix){
        long startTime = System.nanoTime();
        getWordsByPrefix(prefix);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }
}
