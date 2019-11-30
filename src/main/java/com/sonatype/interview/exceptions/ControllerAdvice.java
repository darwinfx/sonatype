package com.sonatype.interview.exceptions;

import com.sonatype.interview.shared.web.web.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.w3c.dom.ranges.RangeException;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public ResponseBody<NumberFormatException> numberFormatExceptionAdvice(NumberFormatException ex) {
    return ResponseBody.fromObject(null, HttpStatus.NOT_ACCEPTABLE, ex.toString());
  }
  @ExceptionHandler(RangeException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public ResponseBody<RangeException> numberFormatExceptionAdvice(RangeException ex) {
    return ResponseBody.fromObject(null, HttpStatus.NOT_ACCEPTABLE, ex.toString());
  }
}
