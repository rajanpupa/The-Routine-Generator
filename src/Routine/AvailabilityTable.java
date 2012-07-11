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
public class AvailabilityTable {
    
    List<String>[][] teachersAvailable=new List[6][8];
    
    public AvailabilityTable(){
        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                teachersAvailable[i][j]=new ArrayList<String>();
            }
        }
    }
    
    public void printListUsefulTimeSlots(){
        List <TimeSlot> t=getUsefulTimeSlot(new TimeSlot(0,0));
        System.out.println("The useful time slots are:"+t.size());
        for(int i=0;i<t.size();i++){
            t.get(i).printDetail("useful Timeslot");
        }
    }
    
    public List<String> getTeachersList(TimeSlot t){
        return teachersAvailable[t.day][t.period];
    }
    
    public List<TimeSlot> getUsefulTimeSlot(TimeSlot t1){
        List <TimeSlot> t=new ArrayList<TimeSlot>();
        int i=0;
        for(i=t1.day;i<=t1.day;i++){
            for(int j=t1.period;j<8;j++){
                if(teachersAvailable[i][j].size()>0){
                    t.add(new TimeSlot(i,j));
                }
            }
        }
        for(;i<6;i++){
            for(int j=0;j<8;j++){
                if(teachersAvailable[i][j].size()>0){
                    t.add(new TimeSlot(i,j));
                }
            }
        }
        return t;
    }
    
    public TimeSlot getNextUsefulTimeSlot(TimeSlot t){
        TimeSlot t1=t.getNext();
        t1.printDetail("in the availability table");
        TimeSlot t2 = null;
        int i=0;
        for(i=t1.day;i<=t1.day;i++){
            for(int j=t1.period;j<8;j++){
                int size=teachersAvailable[i][j].size();
                //System.out.println(i+""+j+"=>"+size);
                if(size>0){
                    t2=new TimeSlot(i,j);
                    return t2;
                }
            }
        }
        for(;i<6;i++){
            for(int j=0;j<8;j++){
                int size=teachersAvailable[i][j].size();
                //System.out.println(i+""+j+"=>"+size);
                if(size>0){
                    t2=new TimeSlot(i,j);
                    return t2;
                }
            }
        }
        //t2.printDetail("get next usefultimeslot is returning ");
        return t2;
    }
    
    public void setTimeSlot(TimeSlot t,List<String> teachers){
        teachersAvailable[t.day][t.period]=teachers;
    }
    
    public void addNewTeacherToList(TimeSlot t,String teacherName){
        this.teachersAvailable[t.day][t.period].add(teacherName);
    }
    
}
