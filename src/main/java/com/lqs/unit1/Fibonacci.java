package com.lqs.unit1;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author lqs
 * @describe 斐波拉契数列求和
 * @date 2021/10/15
 */
@Slf4j
public class Fibonacci {

  public static long recursion(long num) {
    if (num == 0 || num == 1) {
      return num;
    }
    return recursion(num - 1) + recursion(num - 2);
  }

  public static long iteration(long num) {
    if (num == 0 || num == 1) {
      return num;
    }
    long result = 0, pre = 0, next = 1;
    for (long i = 0; i < num - 1; i++) {
      result = pre + next;
      pre = next;
      next = result;
    }
    return result;
  }

  public static void main(String[] args) {
    long num = 10;
    long times = 2;
    long start = System.nanoTime();
    for (long i = 0; i < times; i++) {
      log.info("recursion: {}", recursion(num));
    }
    long center = System.nanoTime();
    for (long i = 0; i < times; i++) {
      log.info("iteration: {}", iteration(num));
    }
    long last = System.nanoTime();
    long recursion = center - start;
    long iteration = last - center;
    log.info("循环[{}]次递归求[{}]的斐波拉契和时间消耗为:{}", times, num, recursion);
    log.info("递归求[{}]的斐波拉契和平均时间消耗为:{}", num, (recursion) / times);
    log.info("循环[{}]次迭代求[{}]的斐波拉契和时间消耗为:{}", times, num, iteration);
    log.info("迭代求[{}]的斐波拉契和平均时间消耗为:{}", num, (iteration) / times);
    log.info("{}次求和，递归和迭代相差{{}}倍",num, recursion / iteration);
  }
}
