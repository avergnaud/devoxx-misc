package npe;

import java.util.Optional;

class B {
}

class A {
	private B b;

	public B getB() {
		return b;
	}
}

public class Example {

	public static void main(String[] args) {
		// http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
		/*
		 * It is important to note that the intention of the Optional class is
		 * not to replace every single null reference. Instead, its purpose is
		 * to help design more-comprehensible APIs so that by just reading the
		 * signature of a method, you can tell whether you can expect an
		 * optional value. This forces you to actively unwrap an Optional to
		 * deal with the absence of a value.
		 */
		A a = new A();
		try {			
			System.out.println(a.getB().toString());
		} catch (NullPointerException e) {
			System.out.println("NPE");
		}
		
		C c = new C();
		System.out.println(c.getD().toString());
		if(c.getD().isPresent()) {
			System.out.println(c.getD().get());
		}
	}
}

class D {}

class C {
	private D d;

	//API prevents NPE
	public Optional<D> getD() {
		return Optional.ofNullable(d);
	}
}
