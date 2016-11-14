// Sortest job first non-preemptive priority 
import java.io.*;
public class SRTF {
 public static void main(String args[]) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n;
      System.out.println("Number Of Processes: ");
       n = Integer.parseInt(br.readLine());
       int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
       for(int i = 1; i <= n; i++)
       {
      System.out.println("Arrival Time For Process " + i + ": ");
      proc[i][0] = Integer.parseInt(br.readLine());
      System.out.println("Burst Time For Process " + i + ": ");
      proc[i][1] = Integer.parseInt(br.readLine());
     }
       System.out.println();
     
       //Calculation of Total Time and Initializatin of Time arry
     int total_time = 0;
     for(int i = 1; i <= n; i++)
     {
      total_time += proc[i][1];
     }
     int time_chart[] = new int[total_time];
     
     for(int i = 0; i < total_time; i++)
     {
      //Selection of shortest process which has arrived
      int sel_proc = 0;
      int min = 99999;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)//Condition to check if Process has arrived
       {
        if(proc[j][1] < min && proc[j][1] != 0)
        {
         min = proc[j][1];
         sel_proc = j;
        }
       }
      }
      time_chart[i] = sel_proc;
      proc[sel_proc][1]--;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] != 0)
        {
         proc[j][3]++;
         if(j != sel_proc)
              proc[j][2]++;
        }
        else if(j == sel_proc)
          proc[j][3]++;
       }
      }
      if(i != 0)
      {
       if(sel_proc != time_chart[i - 1])
       {
        System.out.print("--" + i + "--P" + sel_proc);
       }
      }
      else
        System.out.print(i + "--P" + sel_proc);
      if(i == total_time - 1)
        System.out.print("--" + (i + 1));
      
     }
     System.out.println();
     System.out.println();
     //Print
     System.out.println("P\t WT \t TT ");
     for(int i = 1; i <= n; i++)
     {
      System.out.printf("%d\t%2dms\t%2dms",i,proc[i][2],proc[i][3]);
      System.out.println();
     }
     
     System.out.println();
     
     //Printing aver WT & TT
     float WT = 0,TT = 0;
     for(int i = 1; i <= n; i++)
     {
      WT += proc[i][2];
      TT += proc[i][3];
     }
     WT /= n;
     TT /= n;
     System.out.println("The Average WT is: " + WT );
     System.out.println("The Average TT is: " + TT );
 }
    
}