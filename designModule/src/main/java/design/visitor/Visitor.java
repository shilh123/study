package design.visitor;

/**
 * 
 * 访问者模式（Visitor）
 * 
 * @author Shilh
 *
 */
public class Visitor {
	public static void main(String[] args) {
		VisitorInterface vInterface = new Myvistor();
		Subject subject = new MySubject();
		subject.accept(vInterface);
	}
}

interface VisitorInterface {
	public void visit(Subject sub);
}

class Myvistor implements VisitorInterface {

	public void visit(Subject sub) {
		// TODO Auto-generated method stub
		System.out.println("visitor the subject:" + sub.getSubject());
	}

}

interface Subject {
	public void accept(VisitorInterface visitor);

	public String getSubject();
}

class MySubject implements Subject {

	public void accept(VisitorInterface visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public String getSubject() {
		// TODO Auto-generated method stub
		return "love";
	}

}
