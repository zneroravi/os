// first come first serve 
import java.io.*;

class Fcfs
    {
    public static void main(String args[]) throws Exception
    {
        int n,AT[],BT[],WT[],CT[];
        float AVG=0;

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

            System.out.println( "Number Of Process" );

        n=Integer.parseInt(br.readLine());
        BT=new int[n];
        WT=new int[n];
        CT=new int[n];
        AT=new int[n];
            System.out.println( "Enter Burst Time For Each                                                                                                                   process\n______________________________");
            for(int i=0;i<n;i++)
        {
            System.out.println( "Burst Time For Process " +(i+1));
        BT[i]=Integer.parseInt(br.readLine());
        }
        System.out.println( "______________________________" );
    for(int i=0;i<n;i++)
    {
        System.out.println( "Arrival Time For Process" +i );
    AT[i]=Integer.parseInt(br.readLine());
    }
        System.out.println( "______________________________" );
    WT[0]=0;

    for(int i=1; i<n; i++)
    {
        WT[i]=WT[i-1]+BT[i-1];
        WT[i]=WT[i]-AT[i];
    }

    for(int i=0; i<n; i++)
    {
        CT[i]=WT[i]+BT[i];
        AVG=AVG+WT[i];
    }
        System.out.println("  Process   BT      WT    TotalTime     ");

    for(int i=0; i<n; i++)
    {
        System.out.println("    "+ i + "       "+BT[i]+"       "+WT[i]+"       "+CT[i]);}
        AVG=AVG/n;
        System.out.println("___________________________________________");
        System.out.println("Average Waiting Time="+AVG+" \n___________________________________________");
    }
 }