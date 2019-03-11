package Measurer;

import FrequencyDictBuilders.HashMapFrequencyDict;
import FrequencyDictBuilders.LinkedListFrequencyDict;
import FrequencyDictBuilders.ListFrequencyDict;
import InputOutput.InputParser;
import Tuples.DictPair;
import Tuples.LongPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MeasureMaker {
    public ArrayList<HashMap<Integer, LongPair>> getMeasures(String[] words, String prefix) {
        int iterations = 10;

        int[] countOfWords = {10, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 70000};

        HashMap<Integer, LongPair> measuresForHashMap = new HashMap<Integer, LongPair>();
        HashMap<Integer, LongPair> measuresForList = new HashMap<Integer, LongPair>();
        HashMap<Integer, LongPair> measuresForLinkedList = new HashMap<Integer, LongPair>();

        for(int count: countOfWords){
            if(count > words.length)
                break;

            String[] partOfWords = Arrays.copyOfRange(words, 0, count);

            ListFrequencyDict lfd = new ListFrequencyDict();
            LinkedListFrequencyDict llfd = new LinkedListFrequencyDict();
            HashMapFrequencyDict hmfd = new HashMapFrequencyDict();

            long resultForGettingLFD = 0;
            long resultForGettingLLFD = 0;
            long resultForGettingHMFD = 0;

            long resultForFindingLFD = 0;
            long resultForFindingLLFD = 0;
            long resultForFindingHMFD = 0;

            for(int i = 0; i < iterations; i++){
                resultForGettingLFD += lfd.measureGettingFreqDict(partOfWords);
                resultForFindingLFD += lfd.measureGettingByPrefix(prefix);

                System.out.println(String.format("now on LFD, count of words: %s in %s iteration", count, i));

                resultForGettingLLFD += llfd.measureGettingFreqDict(partOfWords);
                resultForFindingLLFD += llfd.measureGettingByPrefix(prefix);

                System.out.println(String.format("now on LLFD, count of words: %s in %s iteration", count, i));

                resultForGettingHMFD += hmfd.measureGettingFreqDict(partOfWords);
                resultForFindingHMFD += hmfd.measureGettingByPrefix(prefix);

                System.out.println(String.format("now on HMFD, count of words: %s in %s iteration", count, i));
            }

            measuresForList.put(count, new LongPair(resultForGettingLFD / iterations, resultForFindingLFD / iterations));
            measuresForLinkedList.put(count, new LongPair(resultForGettingLLFD / iterations, resultForFindingLLFD / iterations));
            measuresForHashMap.put(count, new LongPair(resultForGettingHMFD / iterations, resultForFindingHMFD / iterations));
        }

        ArrayList<HashMap<Integer, LongPair>> result = new ArrayList<>();
        result.add(measuresForList);
        result.add(measuresForLinkedList);
        result.add(measuresForHashMap);

        return result;
    }
}
