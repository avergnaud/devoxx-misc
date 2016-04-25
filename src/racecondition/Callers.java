package racecondition;

public class Callers {

	public static void main(String[] args) {
		
		Runnable job = new Runnable() {

			@Override
			public void run() {
				for(int i= 0; i<5_000_000; i++) {					
					Counter.increment();
				}
			}
			
		};
		
		Thread first = new Thread(job);
		Thread second = new Thread(job);
		first.start();
		second.start();
		
		try {
			//wait for the threads to finish
			first.join();
			second.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/* expected : 10000000 */
		System.out.println(Counter.getCountValue());
		
	}

}
