package com.mr.gof;

import static java.lang.System.Logger.Level.INFO;

public class Logger {

  private Logger() {
  }

  public static void log(String message) {
    System.getLogger("gof.logger").log(INFO, message);
  }
}
