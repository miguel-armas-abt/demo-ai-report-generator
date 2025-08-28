package com.demo.service.entrypoint.report.exceptions;

import com.demo.commons.errors.exceptions.GenericException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class NoSuchAreaTypeReporterException extends GenericException {

  private static final String EXCEPTION_CODE = "01.01.02";

  public NoSuchAreaTypeReporterException() {
    super(
        EXCEPTION_CODE,
        "No such area type reporter",
        INTERNAL_SERVER_ERROR
    );
  }
}
