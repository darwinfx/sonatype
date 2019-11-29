package com.sonatype.interview.converter.model.steps;

import com.sonatype.interview.converter.model.Relations;

public abstract class Tranformable {

  private static final String HUNDRED = " hundred ";
  private static final String AND = " and ";
  protected static final String MASK = "000000000000000";

  public StringBuilder convertLessThanOneThousand(Integer number) {
    StringBuilder numberName = new StringBuilder();
    String strLessThanNineteen = "";

    if (number % 100 < 20) {
      numberName.append(Relations.LESS_THAN_NINETEEN.get(number % 100));
      number /= 100;
    } else {
      strLessThanNineteen = Relations.LESS_THAN_NINETEEN.get(number % 10);
      number /= 10;

      numberName.append(AND).append(Relations.LESS_THAN_THOUSAND.get(number % 10)).append(strLessThanNineteen);
      number /= 10;
    }
    if (number == 0) {
      return numberName;
    }
    return numberName.insert(0, HUNDRED).insert(0, Relations.LESS_THAN_NINETEEN.get(number));
  }

  public abstract StringBuilder transform();

}
