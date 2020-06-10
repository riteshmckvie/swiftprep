package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        LinkedList list = new  LinkedList<>();
        list.add(new Integer(2));
        list.add(new Integer(8));
        list.add(new Integer(5));
        list.add(new Integer(1));
        Iterator i = list.iterator();
        Collections.reverse(list);
        Collections.sort(list);
        while(i.hasNext()) {
        	System.out.println(i.next()+" ");
        }
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<?> submit = executorService.submit(() -> System.out.println("I'm Runnable task."));
		System.out.println(submit.get());
		executorService.execute(() ->System.out.println("hi"));
		System.out.println(5+2+"2");
		 ArrayList<String> strings = new ArrayList<String>();
		    strings.add("Hello, World!");
		    strings.add("Welcome to CoderPad.");
		    strings.add("This pad is running Java ");
		    
		    strings = (ArrayList<String>) strings.stream().map(elem -> elem.toUpperCase()).collect(Collectors.toList());
		    
		    for (String string : strings) {
		        System.out.println(string);
		      }
		Future<Integer> futureTask1 = executorService.submit(() -> {
          System.out.println("I'm Callable task.");
            return 1 + 1;
      });
		Callable c = () -> {
	          System.out.println("I'm Callable task.");
	            return 1 + 1;
	      };
		
		executorService.shutdown();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		 List<Callable<Integer>> listOfCallable = Arrays.asList(
	                () -> 1,
	                () -> 2,
	                () -> 3);

	        try {

	            List<Future<Integer>> futures = executor.invokeAll(listOfCallable);

	            int sum = futures.stream().map(f -> {
	                try {
	                    return f.get();
	                } catch (Exception e) {
	                    throw new IllegalStateException(e);
	                }
	            }).mapToInt(Integer::intValue).sum();

	            System.out.println(sum);

	        } catch (InterruptedException e) {// thread was interrupted
	            e.printStackTrace();
	        } finally {

	            // shut down the executor manually
	            executor.shutdown();

	        }
	}

}
;