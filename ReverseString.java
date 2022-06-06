package Recursion;

public class ReverseString {

	public static void main(String[] args) {
		String a="My Name Is Sidhant";
		//System.out.println(reverse(a,a.length()-1,""));
		System.out.println(reverse(a));
	}

	private static String reverse(String a) {
		if(a.equals(""))
			return a;
		return reverse(a.substring(1))+a.charAt(0);
	}

//	private static String reverse(String a,int len,String b) {
//		if(len<0)
//			return b;
//		return reverse(a,len-1,b+a.charAt(len));
//	}

}
