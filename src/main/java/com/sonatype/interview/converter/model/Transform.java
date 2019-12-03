package com.sonatype.interview.converter.model;

import com.sonatype.interview.converter.model.steps.Billion;
import com.sonatype.interview.converter.model.steps.HundredThousand;
import com.sonatype.interview.converter.model.steps.Million;
import com.sonatype.interview.converter.model.steps.Thousand;
import com.sonatype.interview.converter.model.steps.Transformable;
import com.sonatype.interview.converter.model.steps.Trillion;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Transform {
  private static final String DECIMAL_SYMBOL = ",";
  private static final String AND_WORD = " and ";
  private static final String WHITE_SPACE = " ";
  private static final String EMPTY_SPACE = "";
  private static String prefix;

  private Transform() {
  }

  public static String transformNumber(String strNumber) {
    prefix = "";

    if (strNumber.equals("0")) {
      return "Zero";
    }
    Long number = new Long(strNumber);

    List<Transformable> transformSteps = new ArrayList<>();
    transformSteps.add(new Trillion(number));
    transformSteps.add(new Billion(number));
    transformSteps.add(new Million(number));
    transformSteps.add(new HundredThousand(number));
    transformSteps.add(new Thousand(number));

    String numberName = transformSteps.stream().map(Transformable::transform).collect(Collectors.joining());
    return cleanNumberName(prefix + numberName);
  }

  private static String cleanNumberName(String numberName) {
    numberName = removeAdditionalAndWord(numberName);
    return numberName.replaceAll("^\\s+", EMPTY_SPACE).replaceAll("\\b\\s{2,}\\b", " ");
  }

  private static String removeAdditionalAndWord(String numberName) {
    if (numberName.indexOf(AND_WORD) == 0) {
      numberName = numberName.replaceFirst(AND_WORD, EMPTY_SPACE);
    }
    if (StringUtils.countOccurrencesOf(numberName, AND_WORD) >= 2) {
      return removeAdditionalAndWord(numberName.replaceFirst(AND_WORD, WHITE_SPACE));
    }
    return numberName;
  }

}