package com.sonatype.interview.converter.model.steps;

import com.sonatype.interview.converter.model.Number;
import java.text.DecimalFormat;

public class Trillion extends Million {

  private static final String TYPE = " trillion ";

  public Trillion(Long number) {
    super(number, TYPE);
    DecimalFormat df = new DecimalFormat(MASK);
    String strNumber = df.format(number);
    this.number = Integer.parseInt(strNumber.substring(0, 3));
  }
}
