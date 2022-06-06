package Java;
class EqualHash{
	String name;
	EqualHash(String name){
		this.name=name;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
//		EqualHash e=(EqualHash)o;
//		return this.name==e.name;
		
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
}
public class EqualHashCode {

	public static void main(String[] args) {
		EqualHash equalHash=new EqualHash("Sidhant");
		EqualHash equalHash1=new EqualHash("Sidhant");
		System.out.println(equalHash.hashCode()==equalHash1.hashCode());
		System.out.println(equalHash.equals(equalHash1));
		System.out.println(equalHash.hashCode());
		System.out.println(equalHash1.hashCode());
	}

}
