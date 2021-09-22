package Read5line;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class FileReaderClass implements Runnable {
  // file name of output file
  final static String outputPath = "C:\\Users\\naman.batra\\output10.txt";
  String line;
  HashMap<String, String> mapLineWithHex = new HashMap<>();


  public FileReaderClass(String line) {
    this.line = line;

  }
  //defined run method here which will be executed by every 5 thread consequently
  public void run() {
    String hexString = "";
    line = line.replaceAll("\\s+", "");
    //this is converting string to its hex value
    for (int i = 0; i < line.length(); i++) {
      char character = line.charAt(i);
      int asciiValue = (int) character;
      String hexCharacter = Integer.toHexString(asciiValue);
      hexString += hexCharacter;
    }
    //will write string and its hexvalue in output file
    writeToFile(line, hexString);
  }
//will write string and its hexvalue in output file
  private void writeToFile(String line, String hexString) {
    String text = line + ":" + hexString;
    File file = new File(outputPath);
    FileWriter fwriter = null;

    try {
      fwriter = new FileWriter(file, true);
      fwriter.write(text + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fwriter.close();

      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }
}

public class Readbymultiplethreads {
  final static String inputPath = "C:\\Users\\naman.batra\\readit.txt";

  public static void main(String[] args) throws IOException {
    //created a thread pool of 5 thread
    ExecutorService read5Line = Executors.newFixedThreadPool(5);

    BufferedReader bf = new BufferedReader(new FileReader(inputPath));
    String line = bf.readLine();
    while (line != null) {
      Runnable reader = new FileReaderClass(line);
      read5Line.execute(reader);
      line = bf.readLine();
    }
    read5Line.shutdown();
    while (!read5Line.isTerminated()) {

    }
  }
}


