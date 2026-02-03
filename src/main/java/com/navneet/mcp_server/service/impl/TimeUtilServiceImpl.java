package com.navneet.mcp_server.service.impl;

import com.navneet.mcp_server.models.TimeUtilResponse;
import com.navneet.mcp_server.service.TimeUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

/**
 * @author navneet.prabhakar
 */
@Service
@Slf4j
public class TimeUtilServiceImpl implements TimeUtilService {

  private static final String TIME_FORMAT= "yyyy-MM-dd HH:mm:ss";

  @McpTool(name = "fetch_current_time",
      description = "Fetches the current time details including formatted time, timezone, and milliseconds since epoch.")
  @Override
  public TimeUtilResponse currentTime() {
    Long currentTimeMillis = System.currentTimeMillis();
    log.info("Current Time Millis: {}", currentTimeMillis);
    return TimeUtilResponse.builder()
        .currentTimeMillis(currentTimeMillis)
        .currentTime(new java.text.SimpleDateFormat(TIME_FORMAT)
            .format(new java.util.Date(currentTimeMillis)))
        .format(TIME_FORMAT)
        .timeZone(java.util.TimeZone.getDefault().getID())
        .build();
  }
}
