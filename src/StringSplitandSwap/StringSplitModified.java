package StringSplitandSwap;
public class StringSplitModified {
  public static String mergeParts(String dividedparts[],int n) {
    String s = "";
    String dividParts[] = new String[n];
    int evenTime = 0, oddTime = 0;

    for (int i = 0; i < n; i++) {
      
        if (evenTime % 2 == 0) {
          if (i + 2 < n) {
            dividParts[i] = dividedparts[i + 2];
          } else {
            dividParts[i] = dividedparts[i];
          }
          evenTime += 1;
        }
        else 
        {
          dividParts[i] = dividedparts[i - 2];
          evenTime += 1;
        }
     
    }
    for (int i = 0; i < n; i++) {
      s = s + dividParts[i];
    }
    return s;
  }

  public static String[] splitInput(String input, int parts) {
    String inputParts[] = new String[parts];
    int length = input.length();
    String s = "";
    int a = 0;
    int p = length / parts;
    int extraChar = length - (p * parts);
    int count = 0;

    for (int i = 0; i < length; i++) {
      int additionalChar = 0;
      if (count < p) {
        s = s + input.charAt(i);
        count += 1;
      } else {
        if (extraChar > 0) {
          additionalChar = 1;
          s = s + input.charAt(i);
          extraChar -= 1;
        }
        inputParts[a++] = s;
        count = 1;
        s = "";
        if (additionalChar == 1)
          s = s + input.charAt(i += 1);
        else
          s = s + input.charAt(i);
      }
    }
    inputParts[a++] = s;
    return inputParts;
  }

  public static String splitAndSwapString(String str, Integer num) {
    System.out.println("Input string is " + str);
    str=str.replaceAll("\\s+", "");
    System.out.println("Input string after removing spaces is " + str);
    if(str.length()<num)
    return "Enter a string with at least "+num+" characters";
    String[] dividedparts = splitInput(str, num);
    return mergeParts(dividedparts,num);
  }

  public static void main(String args[]) {
    String str = "yes i am a devil of my own world";
    Integer num = 8;
    String result = splitAndSwapString(str, num);
    System.out.println("Resultant string after manipulation is " + result);
  }
}
