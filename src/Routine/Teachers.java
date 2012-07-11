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
public class Teachers {
    List<Teacher> teachers;
    
    public Teachers(){
        teachers=new ArrayList();
    }
    
    public void add(Teacher teacher){
        this.teachers.add(teacher);
    }
    
    public int size(){
        return teachers.size();
    }
    
    public Teacher get(int index){
        if(index>teachers.size()){
            System.err.println("Class Teachers: The index is greater for subject :"+index);
            System.exit(5);
            return null;
        }else{
            return teachers.get(index);
        }
    }
    
    public Teacher getTeacherByName(String teacherName){
        Teacher teacher = null;
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).name.equals(teacherName)){
                teacher= teachers.get(i);
                break;
            }
        }
        return teacher;
    }
}
