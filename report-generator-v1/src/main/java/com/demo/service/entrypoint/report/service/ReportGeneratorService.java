package com.demo.service.entrypoint.report.service;

import com.demo.service.entrypoint.report.dto.request.ReportRequestDto;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ReportGeneratorService {

  Mono<byte[]> generateReport(Map<String, String> headers, ReportRequestDto reportRequest);
}
