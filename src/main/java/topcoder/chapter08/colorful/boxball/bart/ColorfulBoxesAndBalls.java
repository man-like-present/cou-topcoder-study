package topcoder.chapter08.colorful.boxball.bart;

public class ColorfulBoxesAndBalls {

	public static void main(String[] args) {
		System.out.println(getMaximum(2,3,100,400,200));
		System.out.println(getMaximum(2,3,100,400,300));
		System.out.println(getMaximum(5,5,464,464,464));
		System.out.println(getMaximum(1,4,20,-30,-10));
		System.out.println(getMaximum(9,1,-1,-10,4));
	}

	public static int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		boolean redIsBiggerThanBlue= false;
		if(numRed > numBlue) {
			redIsBiggerThanBlue = true;
		}

		int all = numBlue + numRed;
		int count = Math.min(numRed, numBlue);
		int result = 0;
		for(int i=0; i <= count; i++) {
			int point = redIsBiggerThanBlue?
				(onlyBlue * i) +  (onlyRed * (numRed - numBlue + i)) + (bothColors * (all - numRed + numBlue - 2*i)) :
				(onlyRed * i) +  (onlyBlue * (numBlue - numRed + i)) + (bothColors * (all - numBlue + numRed - 2*i));

			if(i == 0) {
				result = point;
			}else {
				result = Math.max(point, result);
			}
		}

		return result;
	}
}
