package com.sonatype.interview.converter.service;

import com.sonatype.interview.converter.model.Number;
import com.sonatype.interview.converter.web.model.ConverterResponse;

public interface ConverterService {
  ConverterResponse processNumber(Number number);
}
