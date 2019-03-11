package FrequencyDictBuilders;

import BaseFrequencyDict.BaseFrequencyDict;
import Tuples.DictPair;

import java.util.ArrayList;
import java.util.Collections;

public class ListFrequencyDict extends BaseFrequencyDict {
    private ArrayList<DictPair> frequencyDict = new ArrayList<DictPair>();

    public void getFrequencyDict(String[] words){
        frequencyDict.clear();

        for (String word: words) {
            Boolean wordInDict = false;

            for (DictPair token: frequencyDict){
                if(token.getWord().equals(word)){
                    token.inc();
                    wordInDict = true;
                    break;
                }
            }
            if(!wordInDict)
                frequencyDict.add(new DictPair(word, 1));

        }
    }

    public ArrayList<DictPair> getWordsByPrefix(String prefix){
        ArrayList<DictPair> result = new ArrayList<DictPair>();

        for (DictPair tuple: frequencyDict){
            if(tuple.getWord().startsWith(prefix)){
                result.add(tuple);
            }
        }

        Collections.sort(result, Collections.reverseOrder(DictPair.COMPARE_BY_FREQUENCY));
        return result;
    }

    public ArrayList<DictPair> returnFD(){
        return frequencyDict;
    }
}
