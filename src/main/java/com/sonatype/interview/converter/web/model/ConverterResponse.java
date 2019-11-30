package com.sonatype.interview.converter.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConverterResponse implements Serializable {
  /**
   * Serial UUID.
   */
  private static final long serialVersionUID = 5342432849977871430L;

  private String value;
  private String word;
}
