/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Routine;

/**
 *
 * @author power
 */
public class TimeSlot {
    public int day;// 0 to 5
    public int period;//0 to 7

    public TimeSlot(int day, int period) {
        this.day = day;
        this.period = period;
    }
    public TimeSlot(String str){
        //( day , period )
        str=str.trim();
        str=str.substring(1, str.length()-1);
        //System.out.println(str);
        String[] b=str.split(",");
        int a=Integer.parseInt(b[0].trim());
        int c=0;
        c=Integer.parseInt(b[1].trim());
        this.day=a;
        this.period=c;
        
    }
    public boolean equals(TimeSlot t1){
        if(t1.day==day&&t1.period==period){
            return true;
        }else{
            return false;
        }
    }
    
    public void printDetail(String str){
        System.out.println(str+" "+this.day+":"+this.period);
    }
    public TimeSlot getNext(){
        int nextDay;
        int nextPeriod;
        if(this.period<7){
            nextDay=day;
            nextPeriod=this.period+1;
        }else{
            nextDay=day+1;
            nextPeriod=0;
        }
        TimeSlot n=new TimeSlot(nextDay,nextPeriod);
        //n.printDetail(this.day+":"+this.period+" Returning Next");
        return n;
    }
}
