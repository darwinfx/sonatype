package com.sonatype.interview.converter.model.steps;

import com.sonatype.interview.converter.model.Relations;
import org.springframework.util.StringUtils;

public abstract class Transformable {

  private static final String HUNDRED = " hundred ";
  private static final String AND = " and ";
  protected static final String MASK = "000000000000000";

  public StringBuilder convertLessThanOneThousand(Integer number) {
    StringBuilder numberName = new StringBuilder();
    String strLessThanNineteen = "";

    if (number % 100 < 20) {
      numberName.append(Relations.getFromLessThanNineteen(number % 100));
      number /= 100;
    } else {
      strLessThanNineteen = Relations.getFromLessThanNineteen(number % 10);
      number /= 10;

      numberName.append(AND).append(Relations.getFromLessThanThousand(number % 10)).append(strLessThanNineteen);
      number /= 10;
    }

    if (number == 0) {
      return numberName;
    }

    if (StringUtils.isEmpty(numberName.toString())) {
      return numberName.insert(0, HUNDRED).insert(0, Relations.getFromLessThanNineteen(number));
    }

    return numberName.insert(0, AND).insert(0, HUNDRED).insert(0, Relations.getFromLessThanNineteen(number));

  }

  public abstract StringBuilder transform();

}
