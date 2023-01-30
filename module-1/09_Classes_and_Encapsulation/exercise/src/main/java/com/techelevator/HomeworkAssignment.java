package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public int getEarnedMarks(){
        return earnedMarks;
    }
    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks=earnedMarks;
    }

    public int getPossibleMarks(){
        return possibleMarks;
    }

    public String getSubmitterName(){
        return submitterName;
    }

    public String getLetterGrade(){
        if(1.0*earnedMarks/possibleMarks*100>=90){
            letterGrade="A";
        }else if(1.0*earnedMarks/possibleMarks*100>=80){
            letterGrade="B";
        }else if(1.0*earnedMarks/possibleMarks*100>=70){
            letterGrade="C";
        }else if(1.0*earnedMarks/possibleMarks*100>=60){
            letterGrade="D";
        }else{
            letterGrade="F";
        }
        return letterGrade;
    }




    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;

    }




}
