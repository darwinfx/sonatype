package com.sonatype.interview.converter.model.steps;

import java.text.DecimalFormat;

public class Trillion extends Million {

  private static final String BILLION = " trillion ";

  public Trillion(Long number) {
    super(number, BILLION);
    DecimalFormat df = new DecimalFormat(MASK);
    String strNumber = df.format(number);
    this.number = Integer.parseInt(strNumber.substring(0, 3));
  }
}
