package com.navneet.mcp_server.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author navneet.prabhakar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeUtilResponse {

  private String currentTime;
  private String timeZone;
  private String format;
  private Long currentTimeMillis;

}
