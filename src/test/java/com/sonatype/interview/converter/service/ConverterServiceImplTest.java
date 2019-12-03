package com.sonatype.interview.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.sonatype.interview.converter.model.Number;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConverterServiceImplTest {

  @Mock
  ConverterServiceImpl converterService;

  @Test
  public void processNumber() {
    when(converterService.processNumber(ArgumentMatchers.any())).thenCallRealMethod();
    assertEquals("one", converterService.processNumber(new Number("00000000001")).getWord());
    assertEquals("Negative one", converterService.processNumber(new Number("-00000000001")).getWord());
    assertEquals("one hundred twenty three billion one hundred twenty three million one hundred twenty "
        + "three thousand one hundred and twenty three",
        converterService.processNumber(new Number("123123123123")).getWord());
    assertEquals("one thousand and twenty three", converterService.processNumber(new Number("0001023")).getWord());
    assertEquals("one thousand one", converterService.processNumber(new Number("1001")).getWord());
    assertEquals("ninety one thousand two hundred and thirty one", converterService.processNumber(new Number(
        "000091231")).getWord());
    assertEquals("eighty three million four hundred eighty two thousand three hundred and seventy one",
        converterService.processNumber(new Number("83482371")).getWord());
    assertEquals("one hundred eleven million one hundred eleven thousand one hundred and eleven",
        converterService.processNumber(new Number("111111111")).getWord());
    assertEquals("eight hundred ninety seven million one hundred twenty three thousand seven hundred and twenty three",
        converterService.processNumber(new Number("897123723")).getWord());
    assertEquals("nine hundred eighty seven million six hundred fifty four thousand three hundred and twenty one",
        converterService.processNumber(new Number("0987654321")).getWord());
    assertEquals("Negative nine hundred eighty seven million six hundred fifty four thousand three hundred and twenty "
            + "one",
        converterService.processNumber(new Number("-0987654321")).getWord());
    assertEquals("Negative one hundred eleven million one hundred eleven thousand one hundred and eleven",
        converterService.processNumber(new Number("-111,    111, 111")).getWord());
    assertEquals("Negative one hundred eleven million one hundred eleven thousand one hundred and eleven",
        converterService.processNumber(new Number("-111 11 1 111")).getWord());
  }
}