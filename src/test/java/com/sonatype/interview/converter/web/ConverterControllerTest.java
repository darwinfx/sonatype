package com.sonatype.interview.converter.web;

import com.sonatype.interview.converter.model.Number;
import com.sonatype.interview.converter.service.ConverterServiceImpl;
import com.sonatype.interview.converter.web.model.ConverterResponse;
import com.sonatype.interview.shared.web.web.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

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
    Number number = new Number(value);
    number.validate();

    doReturn(ConverterResponse.fromModel(number)).when(converterService).processNumber(any());
    ResponseBody<ConverterResponse> response = converterController.create(value);
    assertEquals(200, response.getStatus().value());
  }
}