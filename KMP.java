package GeneralString;

public class KMP {

	public static void main(String[] args) {
		String txt = "AACDAABAABA";//"ABABDABACDABABCABAB";
        String pat = "AABA";//"ABABCABAB";
        new KMP().seach(txt,pat);

	}

	private void seach(String txt, String pat) {
		int txtLength=txt.length();
		int patLength=pat.length();
		int[] lps=new int[patLength];
		computeLPSArray(pat,patLength,lps);
		int i=0,j=0;
		while(i<txtLength) {
			if(txt.charAt(i)==pat.charAt(j)) {
				i++;j++;
			}
			else {
				if(j!=0)
					j=lps[j-1];
				else
					i++;
			}
			if(j==patLength) {
				System.out.println("found match at index"+(i-j));
				j=lps[j-1];
			}
		}
	}

	private void computeLPSArray(String pat, int pLen, int[] lps) {
		int len=0;
		int i=1;
		lps[0]=0;
		while(i<pLen) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}
			else {
				if(len!=0) {
					len=lps[len-1];
				}
				else {
					lps[i]=len;
					i++;
				}
			}
		}
		
	}

}
