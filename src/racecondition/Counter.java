package racecondition;

public class Counter {
	private static Integer value = 0;
	
	static /*synchronized*/ void increment() {
		value++;
	}
	static int getCountValue() {
		return value;
	}
}
