/**
 * 
 */
package algorithms.search;

/**
 * @author Dhaval
 *
 */
public class BinarySearch {

	public static class NumberRange {

        private int lowerIndex;
        private int upperIndex;

        public NumberRange (int lIndex, int uIndex){
            this.lowerIndex = lIndex;
            this.upperIndex = uIndex;
        }

        public int getLowerIndex() {
            return lowerIndex;
        }

        public int getUpperIndex() {
            return upperIndex;
        }

        public void setLowerIndex(int lowerIndex) {
            this.lowerIndex = lowerIndex;
        }

        public void setUpperIndex(int upperIndex) {
            this.upperIndex = upperIndex;
        }
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int[] a = {12, 20, 32, 40, 52};
        NumberRange nr = searchRange(a, 22);

        if (nr == null)
            System.out.println("Undefined");
        else
            System.out.println("Lower = " + nr.getLowerIndex() + " Upper = " + nr.getUpperIndex());

//        nr = searchRange(a, 22);
//
//        if (nr == null)
//            System.out.println("Undefined");
//        else
//            System.out.println("Lower = " + nr.getLowerIndex() + " Upper = " + nr.getUpperIndex());
//
//        nr = searchRange(a, 40);
//
//        if (nr == null)
//            System.out.println("Undefined");
//        else
//            System.out.println("Lower = " + nr.getLowerIndex() + " Upper = " + nr.getUpperIndex());
	}

	private static NumberRange searchRange(int[] rangeArray, int numberToFind) {

        if (rangeArray.length == 0 || rangeArray[rangeArray.length-1] < numberToFind) {
            return null;
        }

        int low = 0;
        int upper = rangeArray.length - 1;
        int mid = low + (upper - low)/2;

        NumberRange currentNR = new NumberRange(low, upper);

        while (low < upper - 1) {
            if (rangeArray[mid] == numberToFind){
                currentNR.setLowerIndex(mid);
                return currentNR;
            }

            if (rangeArray[mid] > numberToFind) {
                upper = mid;
                currentNR.setUpperIndex(upper);
            } else {
                low = mid;
                currentNR.setLowerIndex(low);
            }

            mid = low + (upper - low)/2;

        }

        return currentNR;
	}

}
