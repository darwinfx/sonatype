package com.sonatype.interview.shared;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

@Getter
@Generated
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Range {
  MIN(-999999999999999L), MAX(999999999999999L);
  private final Long value;
}
