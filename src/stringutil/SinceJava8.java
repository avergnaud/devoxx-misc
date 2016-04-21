package stringutil;

import java.util.StringJoiner;

public class SinceJava8 {

	public static void main(String[] args) {
//https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html
		StringJoiner sj = new StringJoiner(":", "[", "]");
		sj.add("George").add("Sally").add("Fred");
		String desiredString = sj.toString();
		System.out.println(desiredString);
	}

}
