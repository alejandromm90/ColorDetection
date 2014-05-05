
public class Angles {
	public static final double ARM_LENGTH_SHOULDER = 10.0;
	public static final double ARM_LENGTH_ELBOW = 10.0;

	public static void main(String[] args) {			
		Angles a = new Angles();
	}
	
	public Angles() {
		run();
	}

	public void run() {
//		while (true) {
//			Point point = Window.getPoint();

//			double x = point.getX();
//			double y = point.getY();

			double x = 5.0;
			double y = 5.0;
			//theta= ELBOW angle
			double theta = 2 *  Math.atan(-Math.sqrt(((ARM_LENGTH_ELBOW + ARM_LENGTH_SHOULDER) * (ARM_LENGTH_ELBOW + ARM_LENGTH_SHOULDER) - (x * x + y * y)) / ((x * x + y * y) - (ARM_LENGTH_ELBOW - ARM_LENGTH_SHOULDER) * (ARM_LENGTH_ELBOW - ARM_LENGTH_SHOULDER)))); 

//thi= SHOULDER angle
			double thi = Math.atan2(y, x) - Math.atan2(ARM_LENGTH_ELBOW * Math.sin(theta), ARM_LENGTH_SHOULDER + ARM_LENGTH_ELBOW * Math.cos(theta));
						
			System.out.println("x : " + x);
			System.out.println("y : " + y);			
			System.out.println("thi : " + Math.toDegrees(thi));
			System.out.println("theta : " + Math.toDegrees(theta));// + thi));
//		}
	}
}
