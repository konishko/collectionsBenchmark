package InputOutput;

import Tuples.LongPair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputWriter {
    public static void writeResult(ArrayList<HashMap<Integer, LongPair>> measures){
        try(FileWriter writer = new FileWriter("measures.txt", false))
        {
            HashMap<Integer, LongPair> LFDMeasure = measures.get(0);
            HashMap<Integer, LongPair> LLFDMeasure = measures.get(1);
            HashMap<Integer, LongPair> HMFDMeasure = measures.get(2);

            writer.write("LFD\n");
            for (int count: LFDMeasure.keySet()){
                writer.write(String.format("%s %s %s\n", count, LFDMeasure.get(count).getX(), LFDMeasure.get(count).getY()));
            }

            writer.write("LLFD\n");
            for (int count: LLFDMeasure.keySet()){
                writer.write(String.format("%s %s %s\n", count, LLFDMeasure.get(count).getX(), LLFDMeasure.get(count).getY()));
            }

            writer.write("HMFD\n");
            for (int count: HMFDMeasure.keySet()){
                writer.write(String.format("%s %s %s\n", count, HMFDMeasure.get(count).getX(), HMFDMeasure.get(count).getY()));
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
