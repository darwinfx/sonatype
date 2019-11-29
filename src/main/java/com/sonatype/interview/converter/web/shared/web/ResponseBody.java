package com.sonatype.interview.converter.web.shared.web;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.io.Serializable;

@Generated
@Getter
@NoArgsConstructor
public final class ResponseBody<T> implements Serializable {
  /**
   * Serial UUID.
   */
  private static final long serialVersionUID = 5342432809977871430L;

  private T result;

  private HttpStatus status;

  private String message;

  private ResponseBody(T result, HttpStatus status) {
    this.result = result;
    this.status = status;
  }

  private ResponseBody(T result, HttpStatus status, String message) {
    this.result = result;
    this.status = status;
    this.message = message;
  }

  public static <E> ResponseBody<E> ok(E object) {
    return new ResponseBody<>(object, HttpStatus.OK);
  }

  public static <E> ResponseBody<E> fromObject(E object, HttpStatus status, String message) {
    return new ResponseBody<>(object, status, message);
  }

}
