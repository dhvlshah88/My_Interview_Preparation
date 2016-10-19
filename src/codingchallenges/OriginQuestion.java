package codingchallenges;
import java.util.PriorityQueue;

/* Describe your approach here.
	
	My approach here is to use heap 



 */


/* Enter your Big O Analysis here. */

/* Enter your code here. */

public class OriginQuestion {

	public static class Point {

		public double x;

		public double y;

		public double distance;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public Point(double x, double y, Point originPoint)
		{
			this.x = x;
			this.y = y;

			double diff_x = (x - originPoint.x);
			//diff_x *= diff_x; 

			double diff_y = (y - originPoint.y);
			//diff_y *= diff_y;

			this.distance = getSquare(diff_x * diff_x + diff_y * diff_y);
		}

		public int compareTo(Point point) {
			return Double.valueOf(point.distance).compareTo(distance);
		}

		@Override
		public String toString() {
			return "x: " + x + " y: " + y;
		}

		public double getSquare(double value)
		{

			if(value<0) return -1;
			if(value==0 || value==1 ) return value;

			double start=0;
			double end=value;
			double precision=0.00000001;
			double mid;

			while(end-start>precision)
			{
				mid=(start+end)/2;
				double modsquare=mid*mid;
				if(modsquare==value) 
					return mid;

				if(modsquare<value) 
					start=mid;
				else 
					end=mid;

			}

			return (start+end)/2;
		}


	} 



	public static Point[] closestk( Point  myList[], int k ) {
		PriorityQueue<Point> queue = new PriorityQueue<Point>();

		for(Point point : myList)
		{
			if(queue.size()<k)
			{
				queue.offer(point);
			}
			else
			{
				if(queue.peek().compareTo(point) < 0)
				{
					queue.poll();
					queue.offer(point);
				}
			}

		}

		Point[] closestPoints = new Point[k];
		int index = 0;
		while(queue.size() != 0)
		{
			closestPoints[index++] = queue.poll();   
		}


		return closestPoints;  
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
