/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

//import distlab1.*;
import Routine.TimeSlot;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author msi3
 */
public class FileUtils {
    //Global global = new Global();
    public static List<String[]> getListArray(String fileName)
                        throws FileNotFoundException, IOException{
        List<String[]> arr=new ArrayList();
        //Map<String,String>inputMap=new HashMap<String,String>();
        FileInputStream fin = new FileInputStream(fileName);
        DataInputStream din = new DataInputStream(fin);
        BufferedReader read = new BufferedReader(new InputStreamReader(din));
        String line = null;
        int i = 0;
        while((line=read.readLine())!=null)
        {
            if(line.trim().indexOf("//")==0){
                //this line is a comment
                continue;
            }
            String disp[] = line.split(":");
            disp[0]=disp[0].trim();
            disp[1]=disp[1].trim();
            disp[2]=disp[2].trim();
            arr.add(disp);
            //inputMap.put(disp[a].trim(), disp[b].trim());
        }
        return arr;
    }
    
    public static List<TimeSlot> getFreeTimeList(String teacher) throws FileNotFoundException, IOException{
        List <TimeSlot> t=new ArrayList();
        FileInputStream fin = new FileInputStream("RG_DATA/RG_TEACHERS/"+teacher+".txt");
        DataInputStream din = new DataInputStream(fin);
        BufferedReader read = new BufferedReader(new InputStreamReader(din));
        String line = null;
        int i = 0;
        while((line=read.readLine())!=null)
        {
            if(line.trim().indexOf("//")==0){
                //this line is a comment
                continue;
            }
            String disp[] = line.split(":");
            disp[0]=disp[0].trim();
            disp[1]=disp[1].trim();
            t.add(new TimeSlot(Integer.parseInt(disp[0]),Integer.parseInt(disp[1])));
            //inputMap.put(disp[a].trim(), disp[b].trim());
        }
        return t;
    }
    
    public static Map<String,String>readSubjectTeacherRelation(String dirName) throws FileNotFoundException, IOException{
        return getMap(dirName+"/"+Global.GENERAL_INFO_FILE, 0, 1);
    }
    public static Map<String,String>subjectPPWRelation(String dirName) throws FileNotFoundException, IOException{
        return getMap(dirName+"/"+Global.GENERAL_INFO_FILE, 0, 2);
    }
    public static Map<String,String>subjectTPPRelation(String dirName) throws FileNotFoundException, IOException{
        return getMap(dirName+"/"+Global.GENERAL_INFO_FILE, 0, 3);
    }
    public static Map<String,String> getMap(String fileName, int a, int b) throws FileNotFoundException, IOException{
        Map<String,String>inputMap=new HashMap<String,String>();
        FileInputStream fin = new FileInputStream(fileName);
        DataInputStream din = new DataInputStream(fin);
        BufferedReader read = new BufferedReader(new InputStreamReader(din));
        String line = null;
        int i = 0;
        while((line=read.readLine())!=null)
        {
            if(line.trim().indexOf("//")==0){
                //this line is a comment
                continue;
            }
            String disp[] = line.split(":");
            inputMap.put(disp[a].trim(), disp[b].trim());
        }
        return inputMap;
    }

    static Map<String, List> teacherFreeTimeRelation(String dirName,List list) throws IOException {
        String ext=".txt";
        Map<String,List> inputMap=new HashMap<String,List>();
        int k=0;
        for(k=0;k<list.size();k++){
            String teacherName=(String) list.get(k);
            //MAKE A NEW MAP ENTRY FOR THE TEACHER NAME
            List n=new ArrayList();
            inputMap.put(teacherName, n);
            String fileName=dirName+"/"+teacherName+ext;
            //System.out.println(fileName);
            
            FileInputStream fin = new FileInputStream(dirName+"/"+teacherName+ext);
            DataInputStream din = new DataInputStream(fin);
            BufferedReader read = new BufferedReader(new InputStreamReader(din));
            String line = null;
            int i = 0;
            while((line=read.readLine())!=null)
            {
                String trimmed=line.trim();
                if(trimmed.indexOf("//")==0){
                    //this line is a comment
                    continue;
                }
                if(trimmed.isEmpty()){
                    continue;
                }
                String disp[] = line.split(":");//day: period
                //inputMap.put(disp[0].trim(), disp[1].trim());
                if(disp[0]!=null && disp[1]!=null){
                    inputMap.get(teacherName).add(String.format("(%s,%s)", disp[0].trim(),disp[1].trim()));
                }
            }
        }
        return inputMap;
    }
}
