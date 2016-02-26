package com.app.trainingapp.client;
import com.app.trainingapp.client.Time;;

/**
 * Training Class
 * @author rafaellg8
 * Class for save a Daily Training
 * Include Time, and kms and place
 */

public class Training {
	private Time time;
	private String place;
	private float distance; //Distance KM
	private float speedAVG; //Average speed km/h
	private int pulseAVG; //Pulse AVG
	private int pulse; //Repose pulse
	
	public Training (Time t,String p, float d, float sAVG, int pAVG, int pulse){
		this.time = t;
		this.place = p;
		this.distance = d;
		this.speedAVG = sAVG;
		this.pulseAVG = pAVG;
		this.pulse = pulse;
	}

	@Override
	public String toString() {
		return "Training [time=" + time + ", place=" + place + ", distance="
				+ distance + ", speedAVG=" + speedAVG + ", pulseAVG="
				+ pulseAVG + ", pulse=" + pulse + "]";
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getSpeedAVG() {
		return speedAVG;
	}

	public void setSpeedAVG(float speedAVG) {
		this.speedAVG = speedAVG;
	}

	public int getPulseAVG() {
		return pulseAVG;
	}

	public void setPulseAVG(int pulseAVG) {
		this.pulseAVG = pulseAVG;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	
	/**
	 * Method to calculate AVG Time
	 */
	private void calculate(){
		assert this!=null;
		float avg;
		avg = this.distance / this.time.toHour();
		
		System.out.println(avg);
		this.speedAVG=avg;
	}
}
