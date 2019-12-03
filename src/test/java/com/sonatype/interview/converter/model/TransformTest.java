package com.sonatype.interview.converter.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformTest {

  @Test
  public void transformNumber() {
    assertEquals("five hundred and sixty seven", Transform.transformNumber("567"));
    assertEquals("one", Transform.transformNumber("0000001"));
    assertEquals("ninety two million three hundred forty eight thousand seven hundred and thirty ",
        Transform.transformNumber("92348730"));
    assertEquals("one hundred twenty three thousand four hundred and fifty six", Transform.transformNumber("123456"));
    assertEquals(
        "one billion two hundred thirty four million five hundred sixty seven thousand eight hundred and ninety ",
        Transform.transformNumber("1234567890"));
    assertEquals("one billion one", Transform.transformNumber("1000000001"));
    assertEquals(
        "seventy one trillion two hundred thirty four billion one hundred twenty two million two hundred thirty four "
            + "thousand one hundred and twenty three",
        Transform.transformNumber("071234122234123"));
    assertEquals("twenty thousand ", Transform.transformNumber("0000020000"));
    assertEquals("four million four", Transform.transformNumber("4000004"));

    assertEquals("one million ", Transform.transformNumber("1000000"));
    assertEquals("seven million ", Transform.transformNumber("0000007000000"));
  }

  @Test
  public void whenWrongDecimalSimbolPosition_thenNumberFormatException() {
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber("1,000,00"));
    Assertions.assertThrows(NumberFormatException.class, () -> Transform.transformNumber("--1,000,000"));
    Assertions.assertThrows(NumberFormatException.class, () -> Transform.transformNumber("-1,000,000-"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber("1,000,0000"));
    Assertions.assertThrows(NumberFormatException.class, () -> Transform.transformNumber("-1,000,0000"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber(",1,000,00"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber("1,0"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber("1,"));
    Assertions.assertThrows(NumberFormatException.class, () -> Transform.transformNumber("-1,"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber(",1"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber("1,000,"));
    Assertions.assertThrows(NumberFormatException.class, () -> Transform.transformNumber("-1,000,"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber("00000,07,000,000"));
    Assertions.assertThrows(NumberFormatException.class,  () -> Transform.transformNumber(",100,000"));
  }
}