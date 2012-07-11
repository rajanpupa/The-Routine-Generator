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
public class Teacher {
    String name;
    List<String> subject;
    int periodToTeach;
    List<TimeSlot> freeTimeList;
    List<TimeSlot> AllocatedTimeList;
    
    public void printDetails(){
        System.out.println("Teacher : "+this.name);
        System.out.println("\tsubjects taught:");
        for(int i=0;i<subject.size();i++){
            System.out.println("\t\t\t"+subject.get(i));
        }
        System.out.println("\tperiods To Teach : "+this.periodToTeach);
        System.out.println("\tFreeTimeList is: ");
        for(int i=0;i<freeTimeList.size();i++){
            System.out.println("\t\t\t"+freeTimeList.get(i).day+":"+freeTimeList.get(i).period);
        }
    }
    
    public Teacher(String name){
        this.name=name;
        subject=new ArrayList();
        //freeTimeList=new ArrayList();
        AllocatedTimeList=new ArrayList();
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void addToSubjectList(String subject){
        this.subject.add(subject);
    }
    
    public void setSubject(List subject){
        this.subject=subject;
    }
    
    public void setPeriodToTeach(int i){
        this.periodToTeach=i;
    }
    
    public void setFreeTimeList(List freeTimeList){
        this.freeTimeList=freeTimeList;
    }
    
    public List<String> getSubjectList(){
        return subject;
    }
    
    public int getPeriodToTeach(){
        return this.periodToTeach;
    }
    
    public int getRemainingPeriodToTeach(){
        return this.periodToTeach-this.AllocatedTimeList.size();
    }
    
    public String getName(){
        return this.name;
    }
    
    public void addFreeTimeList(List<TimeSlot> tl){
        freeTimeList=tl;
    }
    
    public boolean isInFreeTimeList(TimeSlot t){
        for(int i=0;i<freeTimeList.size();i++){
            if(freeTimeList.get(i).equals(t)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isInAllocatedTimeList(TimeSlot t){
        for(int i=0;i<AllocatedTimeList.size();i++){
            if(AllocatedTimeList.get(i).equals(t)){
                return true;
            }
        }
        return false;
    }
    
    public void allocate(TimeSlot t){
        if(!this.isInAllocatedTimeList(t)){
            AllocatedTimeList.add(t);
        }
    }
    
    public void deallocate(TimeSlot t){
        if(true){
            for(int i=0;i<AllocatedTimeList.size();i++){
                if(AllocatedTimeList.get(i).equals(t)){
                    AllocatedTimeList.remove(i);
                    break;
                }
            }
        }
    }
    
    
}
