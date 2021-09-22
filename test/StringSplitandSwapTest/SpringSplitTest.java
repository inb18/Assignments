package StringSplitandSwapTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import StringSplitandSwap.StringSplit;

class SpringSplitTest {
  static StringSplit stringsplit = null;

  @BeforeAll
  public static void beforeAll() {
    stringsplit = new StringSplit();
  }

  @Test
  public void TestCase1withLongInput() {
    String expectedResult =
        "arIamthedevilofmyownworlmynameislucifermorningstIamleaderofworldsbiggestdandMynameispeakyblindercriminalgang";
    String result = stringsplit.splitAndSwapString(
        "my name is lucifer morning star I am the devil of my own world and My name is peaky blinder I am leader of worlds biggest criminal gang",
        9);
    assertEquals(expectedResult, result);

  }

  @Test
  public void TestCase2withLeftOverChar() {
    String expectedResult ="wnworldvilofmyoysiamade";
    String result = stringsplit.splitAndSwapString("ys i am a devil of my own world", 3);
    assertEquals(expectedResult, result);

  }

  @Test
  public void TestCase3withEqualChar() {
    String expectedResult = "ownworldevilofmyyesiamad";
    String result = stringsplit.splitAndSwapString("yes i am a devil of my own world", 3);
    assertEquals(expectedResult, result);
  }


  @Test
  public void TestCase4withShortInput() {
    String expectedResult = "sey";
    String result = stringsplit.splitAndSwapString("yes", 3);
    assertEquals(expectedResult, result);
  }
  

  @Test
  public void TestCase5withLengthofStringLessThenNum() {
    int num=4;
    String expectedResult = "Enter a string with at least "+num+" characters";
    String result = stringsplit.splitAndSwapString("yes", num);
    assertEquals(expectedResult, result);
  }
  
  /*
  @Test
  public void mergeParts_withProperAlternateArray() {
    String expectedResult = "ownworldevilofmyyesiamad";
    String result = stringsplit.splitAndSwapString("yes i am a devil of my own world", 3);
    assertEquals(expectedResult, result);
  }
  

  @Test
  public void mergeParts_withProperAlternateArray() {
    String expectedResult = "ownworldevilofmyyesiamad";
    String result = stringsplit.splitAndSwapString("yes i am a devil of my own world", 3);
    assertEquals(expectedResult, result);
  }
  

  @Test
  public void mergeParts_withProperAlternateArray() {
    String expectedResult = "ownworldevilofmyyesiamad";
    String result = stringsplit.splitAndSwapString("yes i am a devil of my own world", 3);
    assertEquals(expectedResult, result);
  }
  */
}
