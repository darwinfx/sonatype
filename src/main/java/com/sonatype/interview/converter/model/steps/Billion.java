package com.sonatype.interview.converter.model.steps;

import java.text.DecimalFormat;

public class Billion extends Million {

  private static final String TYPE = " billion ";

  public Billion(Long number) {
    super(number, TYPE);
    DecimalFormat df = new DecimalFormat(MASK);
    String strNumber = df.format(number);
    this.number = Integer.parseInt(strNumber.substring(3, 6));
  }
}
