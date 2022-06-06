package Recursion;

public class Palindrom {

	public static void main(String[] args) {
		String a="kayaka";
		System.out.println(palindrom(a,0,a.length()-1));
		System.out.println(palindrom(a));
	}

	private static boolean palindrom(String a) {
		if(a.length()==0 || a.length()==1)
			return true;
		if(a.charAt(0)==a.charAt(a.length()-1)) {
			return palindrom(a.substring(1,a.length()-1));
		}
		return false;
	}

	private static boolean palindrom(String a,int i,int j) {
		if(i>=j) {
			return true;
		}
		if(a.charAt(i)!=a.charAt(j))
			return false;
		
		return palindrom(a,i+1,j-1);
	}

}

