/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package routinegenerator2;

import FileHandler.WriteToFile;
import Routine.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author power
 */
public class RoutineGenerator2 {

    /**
     * @param args the command line arguments
     */
    public void test1(){
        Teacher t=new Teacher("rajan");
        List<TimeSlot> freetime=new ArrayList();
        
        TimeSlot i=new TimeSlot(1,1);
        TimeSlot j=new TimeSlot(1,1);
        freetime.add(i);
        freetime.add(new TimeSlot(1,2));
        t.addFreeTimeList(freetime);
        t.allocate(i);
        System.out.println(t.isInFreeTimeList(j));
    }
    public void test2(){
        Teacher teacher=new Teacher("ram");
        Teachers list=new Teachers();
        list.add(teacher);
        list.getTeacherByName("ram").setName("rajan");
        System.out.println(teacher.getName());
    }
    public void test3(){
        //InitialDatas.initializeForTest();
        Frame frame=new Frame();
        frame.setVisible(true);
    }
    public void test4(){
        WriteToFile.writeToFile("rajan.txt", "hello world,\ni am robot");
        System.out.println("writing completed");
    }
    public static void main(String[] args) {
        try {
            InitialDatas.initialize();
            Frame frame1=new Frame();
            frame1.setVisible(true);
            
    //        System.out.println(InitialDatas.TotalTeachingPeriods);
    //        Main main=new Main();
    //        System.out.println(DynamicDatas.remainingPeriodsToBeTaken());
    //        System.out.println(DynamicDatas.remainingPeriodsToBeTaken());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RoutineGenerator2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RoutineGenerator2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
