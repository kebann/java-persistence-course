package com.bobocode.hw23;

import lombok.SneakyThrows;

public class Printer implements Runnable {

  private final Thread[] threads;

  public Printer(Thread... threads) {
    this.threads = threads;
  }

  @SneakyThrows
  @Override
  public void run() {
    while (true) {
      for (Thread thread : threads) {
        System.out.println(thread.getName() + "-" + thread.getState());
        Thread.sleep(1000);
      }
    }
  }
}
