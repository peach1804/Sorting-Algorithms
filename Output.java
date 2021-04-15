package basepackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

    public static void dataOutput(String mergeData, String quickData, String heapData) {

        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("sortSpeed.csv", true));
            output.newLine();
            output.write(mergeData);
            output.write(",");
            output.write(quickData);
            output.write(",");
            output.write(heapData);
            output.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void csvFile() {
        try {
            File file = new File("sortSpeed.csv");
            FileWriter fw = new FileWriter(file, false);
            fw.flush();
            fw.write("Merge,Quick,Heap");
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
