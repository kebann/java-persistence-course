package com.bobocode.hw23;

import lombok.SneakyThrows;

public class DeadLockDemo {

  @SneakyThrows
  public static void main(String[] args) {
    var lock1 = "lock1";
    var lock2 = "lock2";

    Thread w1 = new Thread(new Worker(lock1, lock2), "worker-1");
    Thread w2 = new Thread(new Worker(lock2, lock1), "worker-2");
    Thread printer = new Thread(new Printer(w1, w2), "printer");

    w1.start();
    w2.start();
    printer.start();

    w1.join();
    w2.join();
    printer.join();
  }
}
