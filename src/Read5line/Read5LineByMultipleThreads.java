package Read5line;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Read5LineByMultipleThreads {
  final static String inputPath = "C:\\Users\\naman.batra\\readit.txt";
  final static String outputPath = "C:\\Users\\naman.batra\\outputPrint.txt";
  // decalared a sing string that will contain all the key value pair of string and its hex value
  static String fileOutput = "";

  public static void main(String[] args) throws IOException {
    // created a thread pool of 5 threads
    ExecutorService executor = Executors.newFixedThreadPool(5);
    // created a buffered reader to read inpult file
    BufferedReader bufferReadLine = new BufferedReader(new FileReader(inputPath));
    BufferedReader bufferNextLineCheck = new BufferedReader(new FileReader(inputPath));
    String singleLine = bufferNextLineCheck.readLine();
    while (singleLine != null) {
      executor.execute(() -> {
        String singleLineFetch = null;
        try {
          singleLineFetch = bufferReadLine.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        String hexString = "";
        singleLineFetch = singleLineFetch.replaceAll("\\s+", "");
        for (int i = 0; i < singleLineFetch.length(); i++) {
          char character = singleLineFetch.charAt(i);
          int asciiValue = (int) character;
          String hexCharacter = Integer.toHexString(asciiValue);
          hexString += hexCharacter;
        }
        String opString = singleLineFetch + ":" + hexString + "\n";
        System.out.println(opString);
        fileOutput = fileOutput.concat(opString);
      });
      singleLine = bufferNextLineCheck.readLine();

    }

    executor.shutdown();
    while (!executor.isTerminated()) {

    }

    File file = new File(outputPath);
    FileWriter fw = new FileWriter(file, true);
    fw.write(fileOutput);
    fw.close();
    System.out.println(fileOutput);

  }

}
