

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import gab.opencv.*;

public class FindContours extends PApplet {

	PImage src, dst;
	OpenCV opencv;

	ArrayList<Contour> contours;
	ArrayList<Contour> polygons;

	public void setup() {
		size(600, 400, P2D);  
		src = loadImage("marker_rect.jpg"); 
//	  size(src.width, src.height/2, P2D);
	  opencv = new OpenCV(this, src);

	  opencv.gray();
	  opencv.threshold(70);
	  dst = opencv.getOutput();

	  contours = opencv.findContours();
	  println("found " + contours.size() + " contours");
	}

	public void draw() {
	  scale((float) 0.5);
	  image(src, 0, 0);
	  image(dst, src.width, 0);

	  noFill();
	  strokeWeight(3);
	  
	  for (Contour contour : contours) {
	    stroke(0, 255, 0);
	    contour.draw();
	    
	    stroke(255, 0, 0);
	    beginShape();
	    for (PVector point : contour.getPolygonApproximation().getPoints()) {
	      vertex(point.x, point.y);
	    }
	    endShape();
	  }
	}
	
//
//	PImage dst; //,src;
//	OpenCV opencv;
//	Capture video;
//
//	ArrayList<Contour> contours;
//	ArrayList<Contour> polygons;
//
//	public void setup() {
//	  video = new Capture(this, 640, 480);//loadImage("marker_rect.jpg"); 
//	  size(video.width, video.height, P2D);
//	  opencv = new OpenCV(this, video);
//	  
//	  video.start();
//	  
//	  opencv.gray();
//	  opencv.threshold(70);
//	  dst = opencv.getOutput();
//
//	  contours = opencv.findContours();
//	  println("found " + contours.size() + " contours");
//	}
//
//	public void draw() {
//	  scale(0.5);
//	  
//	  opencv.loadImage(video);
//	  
//	  image(video, 0, 0);
//	  image(dst, video.width, 0);
//
//	  noFill();
//	  strokeWeight(3);
//	  
//	  for (Contour contour : contours) {
//	    stroke(0, 255, 0);
//	    contour.draw();
//	    
//	    stroke(255, 0, 0);
//	    beginShape();
//	    for (PVector point : contour.getPolygonApproximation().getPoints()) {
//	      vertex(point.x, point.y);
//	    }
//	    endShape();
//	  }
//	}
//
//	public void captureEvent(Capture c) {
//	  c.read();
//	}

}
