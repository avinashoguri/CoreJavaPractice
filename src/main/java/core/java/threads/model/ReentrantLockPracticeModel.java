package core.java.threads.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPracticeModel {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    private void increment() {
	for (int i = 0; i < 10000; i++) {
	    count++;
	}
    }

    public void firstThread() {
	lock.lock();

	try {
	    increment();
	} finally {
	    lock.unlock();
	}
    }

    public void secondThread() {
	lock.lock();

	try {
	    increment();
	} finally {
	    lock.unlock();
	}
    }

    public int getCount() {
	return count;
    }
}
