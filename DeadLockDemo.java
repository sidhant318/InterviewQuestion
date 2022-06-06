package MT;

public class DeadLockDemo {
	static Object o1=new Object();
	static Object o2=new Object();

	public static void main(String[] args) throws InterruptedException {
		DeadLockDemo deadLockDemo=new DeadLockDemo();
		Thread t=new Thread(()->deadLockDemo.first());
		Thread t1=new Thread(()->deadLockDemo.second());
		t.start();
		//t.join();
		t1.start();
	}

	private void second() {
		synchronized (o2) {
			System.out.println("I am inside second object1");
			synchronized (o1) {
				System.out.println("I am inside second object2");
			}
			System.out.println("I am out from second object2");
		}
		System.out.println("I am out from second object1");
	}

	private void first() {
		synchronized (o1) {
			System.out.println("I am inside first object2");
			synchronized (o2) {
				System.out.println("I am inside first object1");
			}
			System.out.println("I am out from first object1");
		}
		System.out.println("I am out from first object2");
	}

}
