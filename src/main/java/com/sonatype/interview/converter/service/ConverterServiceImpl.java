package com.sonatype.interview.converter.service;

import com.sonatype.interview.converter.model.Number;
import com.sonatype.interview.converter.model.Transform;
import com.sonatype.interview.converter.web.model.ConverterResponse;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

  @Override
  public ConverterResponse processNumber(Number number) {
    number.validate();
    number.setStrNumber(Transform.transformNumber(number.getStrNumber()));
    return ConverterResponse.fromModel(number);
  }
}