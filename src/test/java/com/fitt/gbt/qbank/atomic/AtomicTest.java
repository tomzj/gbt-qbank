package com.fitt.gbt.qbank.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>@Description: Atomic原子自增运算测试</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-08-09</p>
 * <p>@version: 1.0</p>
 */
public class AtomicTest {
	public static AtomicInteger race = new AtomicInteger(0);

	public static void increase() {
		race.incrementAndGet();
	}

	private static final int THREADS_COUNT = 20;

	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];

		for (int i = 0; i < THREADS_COUNT; i ++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i ++) {
						increase();
					}
				}
			});
			threads[i].start();
		}

		while (Thread.activeCount() > 1) {
			Thread.yield();
			System.out.println(race);
		}
	}
}
