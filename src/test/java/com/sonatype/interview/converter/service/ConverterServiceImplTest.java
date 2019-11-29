package com.sonatype.interview.converter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
    assertEquals("one", converterService.processNumber("00000000001"));
    assertEquals("one hundred twenty three billion one hundred twenty three million one hundred twenty "
        + "three thousand one hundred and twenty three", converterService.processNumber("123123123123"));
    assertEquals("one thousand and twenty three", converterService.processNumber("0001023"));
    assertEquals("one thousand one", converterService.processNumber("1001"));
    assertEquals("ninety one thousand two hundred and thirty one", converterService.processNumber("000091231"));
    assertEquals("eighty three million four hundred eighty two thousand three hundred and seventy one",
        converterService.processNumber("83482371"));
    assertEquals("one hundred eleven million one hundred eleven thousand one hundred eleven",
        converterService.processNumber("111111111"));
    assertEquals("eight hundred ninety seven million one hundred twenty three thousand seven hundred and twenty three",
        converterService.processNumber("897123723"));
    assertEquals("nine hundred eighty seven million six hundred fifty four thousand three hundred and twenty one",
        converterService.processNumber("0987654321"));
  }
}