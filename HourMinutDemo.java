package General;

public class HourMinutDemo {

	public static void main(String[] args) {
		System.out.println(print(9,00));

	}

	private static int print(int i, int j) {
		int h=(i*360)/12+(j*360)/(12*60);
		int m=(j*360)/60;
		int angle=Math.abs(h-m);
		if(angle>180)
			angle=360-angle;
		return angle;
	}

}
