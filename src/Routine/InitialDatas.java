/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Routine;

import FileHandler.FileUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author power
 */
public class InitialDatas {
    /*
     * This class contains Static Datas which donot change throughout the 
     * program
     */
    public static Subjects subjects=new Subjects();
    public static Teachers teachers=new Teachers();
    public static AvailabilityTable availabilityTable=new AvailabilityTable();
    public static int TotalTeachingPeriods;
    
    public static void printAllSubjectsDetails(){
        for(int i=0;i<subjects.size();i++){
            subjects.get(i).printDetails();
        }
    }
    public static void printAllTeachersDetails(){
        for(int i=0;i<teachers.size();i++){
            teachers.get(i).printDetails();
        }
    }
    
    public static List<String> getTeachersList(TimeSlot t){
        List<String> teachers=availabilityTable.getTeachersList(t);
        //teachers.add("break");
        
        return teachers;
    }
    
    public static void initializeForTest(){
        initializeSubjectsForTest();
        initializeTeachersForTest();
        initializeAvailabilityTableForTest();
        initializeTotalTeachingPeriodsForTest();
    }
    
    public static void initializeSubjectsForTest(){
        Subject sub1=new Subject();
        sub1.setName("a");
        sub1.setPeriodsToBeTaken(2);
        sub1.setTeacherName("a");
        
        Subject sub2=new Subject();
        sub2.setName("b");
        sub2.setPeriodsToBeTaken(2);
        sub2.setTeacherName("b");
        
        Subject sub3=new Subject();
        sub3.setName("c");
        sub3.setPeriodsToBeTaken(2);
        sub3.setTeacherName("c");
        
        Subject sub4=new Subject();
        sub4.setName("d");
        sub4.setPeriodsToBeTaken(2);
        sub4.setTeacherName("d");
        
        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        subjects.add(sub4);
    }
    
    public static void initializeTeachersForTest(){
        Teacher teacher1=new Teacher("a");
        List<String> subject1=new ArrayList();
        subject1.add("a");
        teacher1.setSubject(subject1);
        teacher1.setPeriodToTeach(2);
        List <TimeSlot> freetime1=new ArrayList();
        freetime1.add(new TimeSlot(0,0));
        freetime1.add(new TimeSlot(0,1));
        freetime1.add(new TimeSlot(0,2));
        freetime1.add(new TimeSlot(0,4));
        teacher1.setFreeTimeList(freetime1);
        
        Teacher teacher2=new Teacher("b");
        List<String> subject2=new ArrayList();
        subject2.add("b");
        teacher2.setSubject(subject2);
        teacher2.setPeriodToTeach(2);
        List <TimeSlot> freetime2=new ArrayList();
        freetime2.add(new TimeSlot(0,2));
        freetime2.add(new TimeSlot(0,3));
        freetime2.add(new TimeSlot(0,4));
        freetime2.add(new TimeSlot(0,5));
        teacher2.setFreeTimeList(freetime2);
        
        Teacher teacher3=new Teacher("c");
        List<String> subject3=new ArrayList();
        subject3.add("c");
        teacher3.setSubject(subject3);
        teacher3.setPeriodToTeach(2);
        List <TimeSlot> freetime3=new ArrayList();
        freetime3.add(new TimeSlot(0,1));
        freetime3.add(new TimeSlot(0,2));
        freetime3.add(new TimeSlot(0,4));
        freetime3.add(new TimeSlot(0,6));
        teacher3.setFreeTimeList(freetime3);
        
        Teacher teacher4=new Teacher("d");
        List<String> subject4=new ArrayList();
        subject4.add("d");
        teacher4.setSubject(subject4);
        teacher4.setPeriodToTeach(2);
        List <TimeSlot> freetime4=new ArrayList();
        freetime4.add(new TimeSlot(0,3));
        freetime4.add(new TimeSlot(0,4));
        freetime4.add(new TimeSlot(0,7));
        //freetime4.add(new TimeSlot(4,5));
        teacher4.setFreeTimeList(freetime4);
        
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        
        
    }
    
    public static void initializeAvailabilityTableForTest(){
        //not only for test but for general use also
        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                TimeSlot t=new TimeSlot(i,j);
                //the -1 is for the break teacher
                for(int k=0;k<teachers.size();k++){
                    if(teachers.get(k).isInFreeTimeList(t)){
                        InitialDatas.availabilityTable.addNewTeacherToList(t, teachers.get(k).name);
                    }
                }
            }
        }
    }
    
    public static void initializeTotalTeachingPeriodsForTest(){
        int count=0;
        for(int i=0;i<subjects.size();i++){
            count+=subjects.get(i).getPeriodsToBeTaken();
        }
        TotalTeachingPeriods=count;
    }

    public static void initialize() throws FileNotFoundException, IOException{
        //FileUtils fu=new FileUtils();
        List <String[]> listOfArray=FileUtils.getListArray("RG_DATA/rg_general.txt");
        initializeSubjects(listOfArray);
        initializeTeachers(listOfArray);
        initializeAvailabilityTableForTest();
        initializeTotalTeachingPeriodsForTest();
    }
    
    private static void initializeSubjects(List<String[]> list){
        for(int i=0;i<list.size();i++){
            Subject sub=new Subject();
            sub.setName(list.get(i)[0]);
            sub.setPeriodsToBeTaken(Integer.parseInt(list.get(i)[2].trim()));
            sub.setTeacherName(list.get(i)[1]);
            subjects.add(sub);
        }
    }
    
    private static void initializeTeachers(List<String[]> list1) throws FileNotFoundException, IOException{
        List<String> list=getUniqueTeachersList(list1);
        for(int i=0;i<list.size();i++){
            Teacher t=new Teacher(list.get(i));
            List<String> subject=getSubjectsTaughtList(list.get(i),list1);
            t.setSubject(subject);
            t.setPeriodToTeach(getTotalPeriodsToTeach(subject));
            List<TimeSlot> freetime=FileUtils.getFreeTimeList(list.get(i));
            t.setFreeTimeList(freetime);
            teachers.add(t);
        }
//        Teacher t=new Teacher("break");
//        t.addToSubjectList("break");
//        t.setPeriodToTeach(30);
//        List <TimeSlot> l=new ArrayList();
//        for(int i=0;i<6;i++){
//            for(int j=0;j<8;j++){
//                l.add(new TimeSlot(i,j));
//            }
//        }
//        t.setFreeTimeList(list);
//        teachers.add(t);
    }
    
    private static int getTotalPeriodsToTeach(List<String> subject){
        int count=0;
        for(int i=0;i<subject.size();i++){
            count+=subjects.getSubjectByName(subject.get(i)).getPeriodsToBeTaken();
        }
        return count;
    }
    
    private static List<String> getSubjectsTaughtList(String teacher, List<String[]> list){
        List <String> subjects=new ArrayList();
        for(int i=0;i<list.size();i++){
            if(list.get(i)[1].equals(teacher)){
                subjects.add(list.get(i)[0]);
            }
        }
        return subjects;
    }
    
    private static List<String> getUniqueTeachersList(List<String[]> list){
        List<String> l=new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!l.contains(list.get(i)[1])){
                l.add(list.get(i)[1]);
            }
        }
        return l;
    }
    
}
