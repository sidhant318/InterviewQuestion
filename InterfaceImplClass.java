package Java;

interface Interface1 {
	public abstract void show();
	
	default void print() {
		System.out.println("Interface2");
	}
}

interface Interface2 {
	
	public abstract void show();
	
	default void print() {
		System.out.println("Interface2");
	}

}

class InterfaceImpl implements Interface1,Interface2{
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Interface1.super.print();
	}
	
}
public class InterfaceImplClass {

	public static void main(String[] args) {
		InterfaceImpl impl=new InterfaceImpl();
		impl.show();
		impl.print();

	}

}
