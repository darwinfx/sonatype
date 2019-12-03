package com.sonatype.interview.converter.model;

import com.sonatype.interview.exceptions.OutOfRangeException;
import com.sonatype.interview.shared.Range;
import lombok.Getter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Number {
  @Getter
  private String strNumber;

  @Getter
  private Long value;
  private boolean isNegative = false;
  private static final String DECIMAL_SYMBOL = ",";
  private static final String NEGATIVE = "Negative ";
  private static final String EMPTY_SPACE = "";

  public Number(String number) {
    this.strNumber = number.trim().replace(" ", "");
  }

  public void validate() {
    if (this.strNumber.indexOf("-") == 0) {
      isNegative = true;
      this.strNumber = strNumber.replace("-", "").trim();
    }

    checkForDecimalSymbols();

    value = new Long(strNumber);

    if (value > Range.MAX.getValue()) {
      throw new OutOfRangeException("Value out of range, -999.999.999.999.999 < value > 999.999.999.999.999");
    }
    strNumber = Long.toString(value);
  }

  private void checkForDecimalSymbols() {
    AtomicInteger i = new AtomicInteger(0);
    if (strNumber.indexOf(",") >= 0) {
      Stream<String> decimalNumbers = Arrays.stream((" " + strNumber + " ").split(DECIMAL_SYMBOL));
      boolean wrongDecimalNumbers = decimalNumbers.map(String::trim).anyMatch(str -> {
        if (i.get() == 0) {
          i.incrementAndGet();
          return !(str.length() > 0 && str.length() <= 3);
        }
        return str.trim().length() != 3;
      });

      if (wrongDecimalNumbers) {
        throw new NumberFormatException("Decimal symbols in wrong position");
      }
      strNumber = strNumber.replace(DECIMAL_SYMBOL, EMPTY_SPACE);
    }
  }

  public void setStrNumber(String strNumber) {
    if (isNegative) {
      this.strNumber = NEGATIVE + strNumber.trim();
      return;
    }
    this.strNumber = strNumber.trim();
  }

}
