package com.demo.poc.entrypoint.report.exceptions;

import com.demo.poc.commons.core.errors.exceptions.GenericException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class DocxReadException extends GenericException {

  private static final String EXCEPTION_CODE = "01.01.01";

  public DocxReadException(String message) {
    super(
        EXCEPTION_CODE,
        "Docx file is not readable: " + message,
        INTERNAL_SERVER_ERROR);
  }
}
