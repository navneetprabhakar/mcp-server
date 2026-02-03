package com.navneet.mcp_server.service;

import com.navneet.mcp_server.models.TimeUtilResponse;

/**
 * @author navneet.prabhakar
 */
public interface TimeUtilService {


  /**
   * Get the current time details.
   *
   * @return TimeUtilResponse containing current time information.
   */
  TimeUtilResponse currentTime();

}
