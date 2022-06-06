package Java;

abstract class MyAbstract{
	private int val;
	
	public MyAbstract(int val) {
		this.val=val;
	}
	
	abstract void show();
	void print() {
		System.out.println(val);
	}
}

class AbstractExtend extends MyAbstract{

	public AbstractExtend(int val) {
		super(val);
	}

	@Override
	void show() {
		System.out.println("AbstractExtend");
	}
	
}
public class AbstractIMpl {

	public static void main(String[] args) {
		AbstractExtend abstractExtend=new AbstractExtend(10);
		abstractExtend.print();

	}

}
