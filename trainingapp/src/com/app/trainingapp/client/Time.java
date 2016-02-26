package com.app.trainingapp.client;

/**
 * Auxiliar class Form Timing
 * @author rafaellg8
 *
 */
public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time(int h,int m,int s){
		this.hour=h;
		this.minute=m;
		this.second=s;
	}

	public Time getTime(){
		return this;
	}
	
	public void setTime(int h,int m,int s){
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	
	public int toSecond(){
		// Assert, null Pointer
		assert this!=null;
		
		int time;
		
		time = this.hour*3600+this.minute*60+this.second;
		
		return time;
	}
	
	/**
	 * Calculate the time in hours
	 * @return time in hours
	 */
	public float toHour(){
		assert this!=null;
		float time;
		time = this.hour+(this.minute/60)+(this.second/3600);
		return time;
	}
}
