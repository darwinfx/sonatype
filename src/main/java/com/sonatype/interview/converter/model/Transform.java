package com.sonatype.interview.converter.model;

import com.sonatype.interview.converter.model.steps.Billion;
import com.sonatype.interview.converter.model.steps.HundredThousand;
import com.sonatype.interview.converter.model.steps.Million;
import com.sonatype.interview.converter.model.steps.Thousand;
import com.sonatype.interview.converter.model.steps.Tranformable;
import com.sonatype.interview.converter.model.steps.Trillion;
import com.sonatype.interview.exceptions.OutOfRangeException;
import com.sonatype.interview.shared.Range;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transform {
  private static final String DECIMAL_SIMBOL = ",";
  private static final String AND_WORD = " and ";
  private static final String WHITE_SPACE = " ";
  private static final String EMPTY_SPACE = "";
  private static String prefix;

  private static Long number;

  private Transform() {
  }

  public static String transformNumber(String strNumber) {
    prefix = "";

    validateNumber(strNumber);

    if (number == 0) {
      return "Zero";
    }

    List<Tranformable> transformSteps = new ArrayList<>();
    transformSteps.add(new Trillion(number));
    transformSteps.add(new Billion(number));
    transformSteps.add(new Million(number));
    transformSteps.add(new HundredThousand(number));
    transformSteps.add(new Thousand(number));

    String numberName = transformSteps.stream().map(Tranformable::transform).collect(Collectors.joining());
    return cleanNumberName(prefix + numberName);
  }

  private static void validateNumber(String strNumber) {
    AtomicInteger i = new AtomicInteger(1);
    Stream<String> decimalNumbers = Arrays.stream((" " + strNumber + " ").split(DECIMAL_SIMBOL));
    boolean wrongDecimaNumbers = decimalNumbers.anyMatch(str -> {
      if (i.get() == 1) {
        i.incrementAndGet();
        return false;
      }
      return str.trim().length() != 3;
    });

    if (wrongDecimaNumbers) {
      throw new NumberFormatException("Decimal simbols in wrong position");
    }

    strNumber = strNumber.replace(DECIMAL_SIMBOL, EMPTY_SPACE);

    number = new Long(strNumber);

    if (number < 0) {
      number = Math.abs(number);
      prefix = "Negative ";
    }

    if (number < Range.MIN.getValue() || number > Range.MAX.getValue()) {
      throw new OutOfRangeException("Value out of range, -999.999.999.999.999 < value > 999.999.999.999.999");
    }

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