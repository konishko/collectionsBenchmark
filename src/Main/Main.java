package Main;

import InputOutput.OutputWriter;
import Measurer.MeasureMaker;
import InputOutput.InputParser;
import Tuples.LongPair;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        ArrayList<String> input = InputParser.getInput();
        String[] words = InputParser.parseText(input);

        String prefix = "кня";

        MeasureMaker mm = new MeasureMaker();
        ArrayList<HashMap<Integer, LongPair>> measures = mm.getMeasures(words, prefix);

        OutputWriter.writeResult(measures);
    }
}
