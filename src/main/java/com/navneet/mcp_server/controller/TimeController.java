package com.navneet.mcp_server.controller;

import com.navneet.mcp_server.models.TimeUtilResponse;
import com.navneet.mcp_server.service.TimeUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author navneet.prabhakar
 */
@RestController
@RequestMapping("v1/time")
@Slf4j
public class TimeController {

  @Autowired
  private TimeUtilService timeUtilService;

  /**
   * This REST API is just to test the TimeUtilService independently.
   * MCP Client doesnot utilises this endpoint.
   *
   * @return TimeUtilResponse containing current time information.
   */
  @GetMapping("/current-time")
  public TimeUtilResponse currentTime() {
    log.info("Received request for current time");
    return timeUtilService.currentTime();
  }

}
