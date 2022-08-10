package com.bobocode.hw23;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Worker implements Runnable {

  private final Object lock1;
  private final Object lock2;

  @SneakyThrows
  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.printf("%s: trying to lock '%s' %n", name, lock1);

    synchronized (lock1) {
      System.out.printf("%s: successfully locked '%s' %n", name, lock1);

      Thread.sleep(3000);

      System.out.printf("%s trying to lock '%s' %n", name, lock2);
      synchronized (lock2) {
        System.out.printf("%s: successfully locked '%s' %n", name, lock2);
      }
    }
  }
}
