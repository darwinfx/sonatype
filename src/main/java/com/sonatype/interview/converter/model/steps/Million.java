package com.sonatype.interview.converter.model.steps;

import java.text.DecimalFormat;

public class Million extends Tranformable {

  private String type = " million ";
  protected Integer number;

  public Million(Long number) {
    DecimalFormat df = new DecimalFormat(MASK);
    String strNumber = df.format(number);
    this.number = Integer.parseInt(strNumber.substring(6, 9));
  }

  protected Million(Long number, String type) {
    this(number);
    this.type = type;
  }

  @Override
  public StringBuilder transform() {
    StringBuilder million = new StringBuilder();
    if (number != 0) {
      return million.append(convertLessThanOneThousand(number)).append(type);
    }
    return million;
  }
}
