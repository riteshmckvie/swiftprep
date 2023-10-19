package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreTest extends Thread {

	Semaphore semaphore;

	String threadName;

	static AtomicInteger count = new AtomicInteger(0);

	public SemaphoreTest(Semaphore sem, String threadName) {
		super(threadName);
		this.semaphore = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		if (this.getName().equalsIgnoreCase("A")) {

			System.out.println("started A");

			try {
				this.semaphore.acquire();
				System.out.println(this.getName() + " gets a permit.");
				for (int i = 0; i < 5; i++) {
					count.set(count.incrementAndGet());
					System.out.println(threadName + ": " + count);

					//Thread.sleep(10);
				}
				this.semaphore.release();
			} catch (InterruptedException e) {
				System.out.println("exception " + e.getMessage());
			}
		} else {
			System.out.println("Starting " + threadName);
			try {
				// First, get a permit.
				System.out.println(threadName + " is waiting for a permit.");

				// acquiring the lock
				this.semaphore.acquire();

				System.out.println(threadName + " gets a permit.");

				// Now, accessing the shared resource.
				// other waiting threads will wait, until this
				// thread release the lock
				for (int i = 0; i < 5; i++) {
					count.set(count.decrementAndGet());
					System.out.println(threadName + ": " + count);

					// Now, allowing a context switch -- if possible.
					// for thread A to execute
					Thread.sleep(10);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			// Release the permit.
			System.out.println(threadName + " releases the permit.");
			this.semaphore.release();
		}
	}
}
