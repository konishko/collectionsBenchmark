package FrequencyDictBuilders;

import BaseFrequencyDict.BaseFrequencyDict;
import Tuples.DictPair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HashMapFrequencyDict extends BaseFrequencyDict {
    private HashMap<String, Integer> frequencyDict = new HashMap<String, Integer>();

    public void getFrequencyDict(String[] words){
        frequencyDict.clear();

        for(String word: words){
            if(frequencyDict.containsKey(word)){
                int frequency = frequencyDict.get(word);
                frequencyDict.put(word, frequency + 1);
            }

            else{
                frequencyDict.put(word, 1);
            }
        }
    }

    public ArrayList<DictPair> getWordsByPrefix(String prefix){
        ArrayList<DictPair> result = new ArrayList<DictPair>();

        for(String word: frequencyDict.keySet()){
            if(word.startsWith(prefix)){
                result.add(new DictPair(word, frequencyDict.get(word)));
            }
        }

        Collections.sort(result, Collections.reverseOrder(DictPair.COMPARE_BY_FREQUENCY));
        return result;
    }
}
