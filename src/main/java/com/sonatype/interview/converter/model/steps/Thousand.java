package com.sonatype.interview.converter.model.steps;

import java.text.DecimalFormat;

public class Thousand extends Tranformable {

  private Integer number;

  public Thousand(Long number) {
    DecimalFormat df = new DecimalFormat(MASK);
    String strNumber = df.format(number);
    this.number = Integer.parseInt(strNumber.substring(12, 15));
  }

  @Override
  public StringBuilder transform() {
    return convertLessThanOneThousand(number);
  }
}
