/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Routine;

/**
 *
 * @author power
 */
public class Subject {
    String name;
    String teacherName;
    int periodsToBeTaken;

    public String getName() {
        return name;
    }

    public int getPeriodsToBeTaken() {
        return periodsToBeTaken;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeriodsToBeTaken(int periodsToBeTaken) {
        this.periodsToBeTaken = periodsToBeTaken;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
    public void printDetails(){
        System.out.println("\nThe subject name is "+this.name);
        System.out.println("\tThe teacher name is "+this.teacherName);
        System.out.println("\tThe ppw is "+this.periodsToBeTaken+"\n");
        
    }
}
