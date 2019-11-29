package com.sonatype.interview.converter.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.sonatype.interview.converter.service.ConverterServiceImpl;
import com.sonatype.interview.converter.web.model.ConverterResponse;
import com.sonatype.interview.converter.web.shared.web.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConverterControllerTest {

  @InjectMocks
  ConverterController converterController;

  @Mock
  ConverterServiceImpl converterService;

  @Before
  public void createMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCreateMethod() {
    String value = "001";
    when(converterService.processNumber(value)).thenReturn("one");
    ResponseBody<ConverterResponse> response = converterController.create(value);
    assertEquals(200, response.getStatus().value());
    assertEquals("one", response.getResult().getWord());
  }
}