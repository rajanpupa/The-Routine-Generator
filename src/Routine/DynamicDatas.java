/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Routine;

import java.util.List;

/**
 *
 * @author power
 */
public class DynamicDatas {
    /*
     * This class contains static datas which change with the change of state
     * of the program
     */
    public static AllocationTable allocationTable=new AllocationTable();
    
    public static int remainingPeriodsToBeTaken(){
        return allocationTable.getRemainingPeriodsToBeTaken();
    }
    
    public static void AllocateTimeSlot(TimeSlot t, String teacherName){
        //properly update information about the action in all the parts
        allocationTable.allocate(t, teacherName);
        InitialDatas.teachers.getTeacherByName(teacherName).allocate(t);
    }
    
    public static void DeallocateTimeSlot(TimeSlot t){
        if(allocationTable.getTeacher(t)==null){
            //doing nothing
        }else{
            String teacher=allocationTable.getTeacher(t);
            allocationTable.deallocate(t);
            InitialDatas.teachers.getTeacherByName(teacher).deallocate(t);
        }
    }
    
    public static void DeallocateTimeSlotFrom(TimeSlot t){
        TimeSlot t2=t.getNext();
        for(int i=t2.day;i<6;i++){
            for(int j=t2.period;j<8;j++){
                DeallocateTimeSlot(new TimeSlot(i,j));
            }
        }
    }
    
    public static boolean satisfied(TimeSlot t){
        if(DynamicDatas.allocationTable.getRemainingPeriodsToBeTaken()==0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean unsatisfiable(TimeSlot t){
        //System.out.println("timeslot "+t.day+t.period);
        if(t==null)return false;
        List<TimeSlot> timeslot= InitialDatas.availabilityTable.getUsefulTimeSlot(t);
//        for(int i=0;i<timeslot.size();i++){
//            timeslot.get(i).printDetail("\t in the middle o f:");
//        }
        int usefulTimeSlotsSize=timeslot.size();
        int remainingPeriodsToBeTaken=remainingPeriodsToBeTaken();
        if (usefulTimeSlotsSize<remainingPeriodsToBeTaken){
            System.out.println("\treturning true "+usefulTimeSlotsSize+"<"+remainingPeriodsToBeTaken);
            return true;
        }else{
            System.out.println("\treturning false usefulTimeSlotSize:"
                    + ""+usefulTimeSlotsSize+"!< remaining periodstoTeach:"+remainingPeriodsToBeTaken);
            return false;
        }
    }
    
}
