package com.ozgur.clockAngle;

public class ClockAngleSolution {

    public static void main(String[] args) {

        calculateAngle(21,60);
        calculateAngle(3,55);
        calculateAngle(12,60);
        calculateAngle(3,30);
        calculateAngle(9,60);

    }

    public static void calculateAngle(double hour,double minute){
        if (hour == 12) {
            hour = 0;
        }
        if (minute == 60){
            minute = 0;
            hour = hour + 1 ;
        }
        hour = hour > 12 ? (hour-12) : hour;
        double result = Math.abs( (360/12*hour) + (minute/2) - (360/60*minute) );
        double narrowAngle = Math.min(result,360-result);
        double wideAngle =Math.max(result,360-result);
        System.out.println("Between the hour and minute hands narrow angle: " +narrowAngle+ " degree" + " wide angle: "+wideAngle+" degree");
    }
}
