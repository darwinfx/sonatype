package com.sonatype.interview.converter.service;

import com.sonatype.interview.converter.model.Transform;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

  @Override
  public String processNumber(String number) {
    return Transform.transformNumber(number);
  }
}