package com.sonatype.interview.converter.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Relations {

  public static final List<String> LESS_THAN_NINETEEN;
  public static final List<String> LESS_THAN_THOUSAND;

  static {
    LESS_THAN_NINETEEN = new ArrayList<>();
    LESS_THAN_NINETEEN.add("");
    LESS_THAN_NINETEEN.add("one");
    LESS_THAN_NINETEEN.add("two");
    LESS_THAN_NINETEEN.add("three");
    LESS_THAN_NINETEEN.add("four");
    LESS_THAN_NINETEEN.add("five");
    LESS_THAN_NINETEEN.add("six");
    LESS_THAN_NINETEEN.add("seven");
    LESS_THAN_NINETEEN.add("eight");
    LESS_THAN_NINETEEN.add("nine");
    LESS_THAN_NINETEEN.add("ten");
    LESS_THAN_NINETEEN.add("eleven");
    LESS_THAN_NINETEEN.add("twelve");
    LESS_THAN_NINETEEN.add("thirteen");
    LESS_THAN_NINETEEN.add("fourteen");
    LESS_THAN_NINETEEN.add("fifteen");
    LESS_THAN_NINETEEN.add("sixteen");
    LESS_THAN_NINETEEN.add("seventeen");
    LESS_THAN_NINETEEN.add("eighteen");
    LESS_THAN_NINETEEN.add("nineteen");
  }

  static {
    LESS_THAN_THOUSAND = new ArrayList<>();
    LESS_THAN_THOUSAND.add(null);
    LESS_THAN_THOUSAND.add("ten");
    LESS_THAN_THOUSAND.add("twenty ");
    LESS_THAN_THOUSAND.add("thirty ");
    LESS_THAN_THOUSAND.add("forty ");
    LESS_THAN_THOUSAND.add("fifty ");
    LESS_THAN_THOUSAND.add("sixty ");
    LESS_THAN_THOUSAND.add("seventy ");
    LESS_THAN_THOUSAND.add("eighty ");
    LESS_THAN_THOUSAND.add("ninety ");
  }

}
