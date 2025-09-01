package com.demo.service.entrypoint.report.rest;

import com.demo.commons.validations.BodyValidator;
import com.demo.commons.validations.headers.DefaultHeaders;
import com.demo.commons.validations.ParamValidator;

import java.util.Map;

import com.demo.service.entrypoint.report.dto.request.ReportRequestDto;
import com.demo.service.entrypoint.report.service.ReportGeneratorService;
import lombok.RequiredArgsConstructor;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReportGeneratorHandler {

  private final ParamValidator paramValidator;
  private final BodyValidator bodyValidator;
  private final ReportGeneratorService reportGeneratorService;

  public Mono<ServerResponse> generateReport(ServerRequest serverRequest) {
    return paramValidator.validateHeadersAndGet(serverRequest, DefaultHeaders.class)
        .zipWith(serverRequest.bodyToMono(ReportRequestDto.class))
        .flatMap(tuple -> {
          Map<String, String> headers = tuple.getT1().getValue();
          ReportRequestDto requestBody = tuple.getT2();

          return bodyValidator.validateAndGet(requestBody)
              .flatMap(body -> reportGeneratorService.generateReport(headers, body));
        })
        .flatMap(bytes -> {
          DataBuffer buffer = new DefaultDataBufferFactory().wrap(bytes);
          return ServerResponse.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=psicologia.docx")
              .contentType(MediaType.valueOf("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
              .bodyValue(buffer);
        });
  }
}
