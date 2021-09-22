package StringSplitandSwap;
public class StringSplit {
  public static String mergeParts(String dividedparts[],int n) {
    String s = "";
    //this arrays will contains swapped strings
    String dividParts[] = new String[n];
    int evenPosition = 0, oddPosition = 0;

    for (int i = 0; i < n; i++) {
    //for swapping of string at even position
      if (i % 2 == 0) {
        //for swapping from lower to higher index
        if (evenPosition % 2 == 0) {
          if (i + 2 < n) {
            //if there is next string available to swap
            dividParts[i] = dividedparts[i + 2];
          } else {
            //if there is no string available to swap
            dividParts[i] = dividedparts[i];
          }
          evenPosition += 1;
        }//for swapping from higher to lower index
        else {
          dividParts[i] = dividedparts[i - 2];
          evenPosition += 1;
        }
      } else {
        //for swapping of string at odd position
        if (oddPosition % 2 == 0) {
        //for swapping from lower to higher index
          if (i + 2 < n) {
            dividParts[i] = dividedparts[i + 2];
          } else {
          //if there is no string available to swap
            dividParts[i] = dividedparts[i];
          }
          oddPosition += 1;
        } //for swapping from higher to lower index
        else {
          dividParts[i] = dividedparts[i - 2];
          oddPosition += 1;
        }
      }
    }
    //will concat all string in dividParts array with string s
    for (int i = 0; i < n; i++) {
      s = s + dividParts[i];
    }
    return s;
  }
//this function is to divide string into n parts with nearly equal string
  public static String[] splitInput(String input, int parts) {
    String inputParts[] = new String[parts];
    int lengthOfinput = input.length();
    String singlePart = "";
    int indexOfInputPartsArray = 0;
    int lengthOfsinglepart = lengthOfinput / parts;//length of each part of string
    int extraChar = lengthOfinput - (lengthOfsinglepart * parts);
    int count = 0;

    for (int i = 0; i < lengthOfinput; i++) {
      int additionalChar = 0;
      //add char to string s uptill length of p
      if (count < lengthOfsinglepart) {
        singlePart = singlePart + input.charAt(i);
        count += 1;
      } else {
        //this is for those extra char that are left over when we divide length of string with parts
        if (extraChar > 0) {
          additionalChar = 1;
          singlePart = singlePart + input.charAt(i);
          extraChar -= 1;
        }
        inputParts[indexOfInputPartsArray++] = singlePart;
        count = 1;
        singlePart = "";
        if (additionalChar == 1)
          singlePart = singlePart + input.charAt(i += 1);
        else
          singlePart = singlePart + input.charAt(i);
      }
    }
    inputParts[indexOfInputPartsArray++] = singlePart;
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
    System.out.println("Result=" + result);
  }
}
