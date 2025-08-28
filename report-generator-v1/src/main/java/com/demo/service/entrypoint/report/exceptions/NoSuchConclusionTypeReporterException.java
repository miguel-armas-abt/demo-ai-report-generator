package com.demo.service.entrypoint.report.exceptions;

import com.demo.commons.errors.exceptions.GenericException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class NoSuchConclusionTypeReporterException extends GenericException {

  private static final String EXCEPTION_CODE = "01.01.03";

  public NoSuchConclusionTypeReporterException() {
    super(
        EXCEPTION_CODE,
        "No such conclusion type reporter",
        INTERNAL_SERVER_ERROR
    );
  }
}
