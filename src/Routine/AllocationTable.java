/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Routine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author power
 */
public class AllocationTable {
    /*It's static instance should be defined somewhere
     * information about which period is allocated with which teacher
     * This is the final solution table
     */
    String[][] teachersAllocated;
    int remainingPeriodsToBeTaken;
    
    public AllocationTable(){
        teachersAllocated=new String[6][8];
        remainingPeriodsToBeTaken=InitialDatas.TotalTeachingPeriods;
    }

    public int getRemainingPeriodsToBeTaken() {
        int count=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                if(teachersAllocated[i][j]!=null){
                    count++;
                }
            }
        }
        return InitialDatas.TotalTeachingPeriods-count;
    }
    
    String getTeacher(TimeSlot t){
        return teachersAllocated[t.day][t.period];
    }
    
    boolean isAllocated(TimeSlot t){
        if(teachersAllocated[t.day][t.period]==null){
            return false;
        }else{
            return true;
        } 
    }
    
    void allocate(TimeSlot t,String teacherName){
        System.out.println("\tThe teacher "+teacherName+" received for allocation"+t.day+t.period);
        if(false){//isAllocated(t)
            System.out.println("The time slot is already allocate, deallocate it before allocating");
            System.out.println(t.day+" "+t.period);
            System.exit(5);
        }else{
            teachersAllocated[t.day][t.period]=teacherName;
            //this.remainingPeriodsToBeTaken--;
        }
    }
    
    void deallocate(TimeSlot t){
        System.out.println("\tThe timeslot "+t.day+t.period+"received for deallocation");
        teachersAllocated[t.day][t.period]=null;
        //this.remainingPeriodsToBeTaken--;
    }
    
    public void clearAll(){
        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                teachersAllocated[i][j]=null;
            }
        }
        remainingPeriodsToBeTaken=InitialDatas.TotalTeachingPeriods;
    }
    
    
}
