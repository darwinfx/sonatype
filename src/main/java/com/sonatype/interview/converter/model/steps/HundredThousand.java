package com.sonatype.interview.converter.model.steps;

import java.text.DecimalFormat;

public class HundredThousand extends Transformable {

  private static final String ONE_THOUSAND = "one thousand ";
  private static final String THOUSAND = " thousand ";
  private Integer number;

  public HundredThousand(Long number) {
    DecimalFormat df = new DecimalFormat(MASK);
    String strNumber = df.format(number);
    this.number = Integer.parseInt(strNumber.substring(9, 12));
  }

  @Override
  public StringBuilder transform() {
    StringBuilder hundredThousand = new StringBuilder();
    if (number == 0) {
      return hundredThousand;
    }
    if (number == 1) {
      return hundredThousand.append(ONE_THOUSAND);
    }
    return hundredThousand.append(convertLessThanOneThousand(number)).append(THOUSAND);
  }
}
