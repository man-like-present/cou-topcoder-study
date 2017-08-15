package topcoder.chapter08.circles.country.bart;

public class CirclesCountry {

	public int leastBorders(int[] X,int[] Y,int[] R, int x1, int y1, int x2, int y2) {
		int count = 0;
		for(int i = 0; i < X.length; i++) {
			boolean pointOneIsIncluded = isIncludedPoint(x1,y1,X[i],Y[i],R[i]);
			boolean pointTwoIsIncluded = isIncludedPoint(x2,y2,X[i],Y[i],R[i]);
			if(pointOneIsIncluded && !pointTwoIsIncluded) {
				count++;
			} else if(!pointOneIsIncluded && pointTwoIsIncluded) {
				count++;
			}
		}
		return count;
	}

	private boolean isIncludedPoint(int xPoint, int yPoint, int X, int Y, int R) {
		return Math.sqrt(Math.pow(xPoint - X, 2) + Math.pow(yPoint - Y, 2)) < R;
	}
}
