package thread;

import java.util.concurrent.Semaphore;

public class TestDemo {

	public static void main(String[] args) {
        // Number of permits 1 
        Semaphore sem = new Semaphore(1); 
          
        SemaphoreTest mt1 = new SemaphoreTest(sem, "A"); 
        SemaphoreTest mt2 = new SemaphoreTest(sem, "B"); 
          
        // stating threads A and B 
        mt1.start(); 
        mt2.start(); 
          
        // waiting for threads A and B  
        try {
			mt1.join();
			mt2.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
          
        // count will always remain 0 after 
        // both threads will complete their execution 
        System.out.println("count: " + SemaphoreTest.count); 
	}

}
