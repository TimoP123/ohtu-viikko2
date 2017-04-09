package ohtu;

import java.util.ArrayList;

public class Submission {
    private String student_number;
    private int week;
    private int hours;
    private int done;
    private String exercises;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;


    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getDone() {
        calculateExercises();
        return done;
    }

    
    
    
    
    private void calculateExercises() {
        this.done = 0;
        this.exercises = "";
        if(a1) {
            done++;
            exercises += "1 ";
        }
        if(a2) {
            done++;
            exercises += "2 ";
        }
        if(a3) {
            done++;
            exercises += "3 ";
        }
        if(a4) {
            done++;
            exercises += "4 ";
        }
        if(a5) {
            done++;
            exercises += "5 ";
        }
        if(a6) {
            done++;
            exercises += "6 ";
        }
        if(a7) {
            done++;
            exercises += "7 ";
        }
        if(a8) {
            done++;
            exercises += "8 ";
        }
        if(a9) {
            done++;
            exercises += "9 ";
        }
        if(a10) {
            done++;
            exercises += "10 ";
        }
        if(a11) {
            done++;
            exercises += "11 ";
        }
        if(a12) {
            done++;
            exercises += "12";
        }   
    }
    
    @Override
    public String toString() {
        calculateExercises();
        return "Viikko " + week + ": tehtyjä tehtäviä yhteensä: " + done +
                ", aikaa kului " + getHours() + ", tehdyt tehtävät " + exercises;
    }
}