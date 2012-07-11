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
public class Subjects {
    //initial record of all the subject
    List<Subject> subjects;
    
    public Subjects(){
        subjects=new ArrayList();
    }
    
    public void add(Subject subject){
        this.subjects.add(subject);
    }
    
    public int size(){
        return subjects.size();
    }
    
    public Subject get(int index){
        if(index>subjects.size()){
            System.err.println("Class Subjects: The index is greater for subject :"+index);
            System.exit(5);
            return null;
        }else{
            return subjects.get(index);
        }
    }
    
    public Subject getSubjectByName(String subName){
        Subject s = null;
        for(int i=0;i<subjects.size();i++){
            if(subjects.get(i).getName().equals(subName)){
                s=subjects.get(i);
                break;
            }
        }
        return s;
    }
}
