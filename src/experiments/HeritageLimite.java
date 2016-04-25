package experiments;

class Parent {
	int i;
	private Parent(int i){this.i = i;}
	
	static class AuthorizedCHild1 extends Parent {
		AuthorizedCHild1(int i) {super(i);}
	}
	
	static class AuthorizedCHild2 extends Parent {
		AuthorizedCHild2(int i) {super(i);}
	}
}

class Tentative /*extends Parent*/ {
	/*Implicit super constructor Parent() is undefined for default constructor. Must define an explicit constructor*/
	
	/*Tentative() {}
	 * Implicit super constructor Parent() is undefined. Must explicitly invoke another constructor
	 */
	
	/*Tentative(int i) {super(i);}
	 * The constructor Parent(int) is not visible
	 */
}

public class HeritageLimite {

	public static void main(String[] args) {
		Parent monObjet = new Parent.AuthorizedCHild1(1);
		Parent autre = new Parent.AuthorizedCHild1(2);
	}

}
