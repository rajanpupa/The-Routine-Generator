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
public class Main {
    public List <String> routinesTable=new ArrayList();
    public List<String> getRoutines(){
        /*
         * Returns a list of String, each String representing a Html Table
         * of The arranged Routines
         */
        this.generateRoutine(new TimeSlot(0,0));
        return routinesTable;
    }
    
    public boolean generateRoutine(TimeSlot t){
        if(t!=null)
        t.printDetail("The current active timeslot is");
        if(DynamicDatas.satisfied(t)){
            generateAndPushTable();
            System.out.println("the table is satisfied here");
            //System.exit(1);
            return true;
        }else if(DynamicDatas.unsatisfiable(t)){
            System.out.println("unsatisfiable");
            //System.exit(1);
            return false;
        }
        if(t==null){
            return false;
        }
        //List <String> teachersAvailable=InitialDatas.availabilityTable.getTeachersList(t);
        List <String> teachersAvailable=InitialDatas.getTeachersList(t);
        for(int i=0;i<teachersAvailable.size();i++){
           /* if(i==teachersAvailable.size()){
                DynamicDatas.DeallocateTimeSlot(t);
                TimeSlot t2=InitialDatas.availabilityTable.getNextUsefulTimeSlot(t);
                //System.out.println()
                //t2.printDetail("The Next time slot is ");
                if(t2!=null&&generateRoutine(t2)){
                    ///return true;
                    //generateAndPushTable();
                    return true;
                }else{
                    DynamicDatas.DeallocateTimeSlot(t);
                }
            }else */
                if(InitialDatas.teachers.getTeacherByName(teachersAvailable.get(i)).getRemainingPeriodToTeach()>0){
                DynamicDatas.AllocateTimeSlot(t, teachersAvailable.get(i));
                TimeSlot t2=InitialDatas.availabilityTable.getNextUsefulTimeSlot(t);
                //System.out.println()
                //t2.printDetail("The Next time slot is ");
                if(generateRoutine(t2)){
                    //return true;//limits to only one solution
                    continue;
                }else{
                    DynamicDatas.DeallocateTimeSlot(t);
                }
            }else{
                TimeSlot t2=InitialDatas.availabilityTable.getNextUsefulTimeSlot(t);
                //System.out.println()
                //t2.printDetail("The Next time slot is ");
                if(generateRoutine(t2)){
                    //return true;//limits to only one solution
                    continue;
                }
                //continue;
            }
            
        }
        System.out.println("This is unsolvable for "+t.day+t.period);
        return false;
    }
    
    private void generateAndPushTable(){
        
            String htmlTable="<table class=\"routine\">\n";
            for(int i=0;i<6;i++){
                htmlTable+="<tr>\n";
                for(int j=0;j<8;j++){
                    htmlTable+="\t<td>"+DynamicDatas.allocationTable.getTeacher(new TimeSlot(i,j))+"</td>\n";
                }
                htmlTable+="\n</tr>";
            }
            htmlTable+="</table>";
            if(!routinesTable.contains(htmlTable)){
                this.routinesTable.add(htmlTable);
            }
            
    }
}
