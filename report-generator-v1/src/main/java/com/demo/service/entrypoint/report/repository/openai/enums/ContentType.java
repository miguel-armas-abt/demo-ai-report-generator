package com.demo.service.entrypoint.report.repository.openai.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContentType {


  TEXT("text"),
  IMAGE("image_url");

  private final String label;
}
