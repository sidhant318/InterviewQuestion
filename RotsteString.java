package GeneralString;

public class RotsteString {

	public static void main(String[] args) {
		String val=transfrom("abc",2);
		System.out.println(val);
	}
	
	
	private static String transfrom(String str, int shift) {
		String output="";
		int val=shift%26;
		for(int i=0;i<str.length();i++) {
			char tmp=(char) (str.charAt(i)+val);
			char out= (char) (tmp>'z'?tmp-26:tmp);
			output+=out;
		}
		return output;
	}

}
