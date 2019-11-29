package com.sonatype.interview.converter.web;

import com.sonatype.interview.converter.service.ConverterService;
import com.sonatype.interview.converter.web.model.ConverterResponse;
import com.sonatype.interview.converter.web.shared.web.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/converter", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = { "Converter" }, value = "Converter")
public class ConverterController {

  @Autowired
  private ConverterService converterService;

  @PostMapping
  @ApiOperation(value = "Convert Number", notes = "Number conversor to words")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Converted.") })
  @ResponseStatus(value = HttpStatus.OK)
  @CrossOrigin(exposedHeaders = { HttpHeaders.LOCATION })
  public ResponseBody<ConverterResponse> create(String value) {
    ConverterResponse converterResponse = ConverterResponse.builder().value(value)
        .word(converterService.processNumber(value)).build();
    return ResponseBody.ok(converterResponse);
  }
}
