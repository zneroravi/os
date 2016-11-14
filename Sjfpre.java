// Sortest job first preemptive priority 
import java.util.*;
class Sjfpre
{
int bt,at,pr,ct,wt,temp;
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println("enter no. of processes : ");
int n=sc.nextInt();
Sjfpre op[] = new Sjfpre[n+1];    // creatng array of objects
for(int i=0;i<=n;i++)
    op[i]= new Sjfpre();
int sum=0;
for(int m=1;m<=n;m++)
{
op[m].pr=m;
System.out.println("enter burst time and arrival time of process "+m);
op[m].bt=sc.nextInt();
op[m].at=sc.nextInt();
sum+=op[m].bt;
op[m].temp=op[m].bt; //copy of burst time


}


for(int t=1;t<=sum;t++)
    {
    
    int min=9999,index=0;    
    
    for(int j=1;j<=n;j++)
        {
        
        if(op[j].at<t && op[j].bt<min && op[j].bt>0)
            {
            
            min=op[j].bt;
            index=j;
            
            }
        }
    
        op[index].bt-=1;
        
        if(op[index].bt==0)
            {
            
            op[index].ct=t-op[index].at;
            op[index].wt=op[index].ct-op[index].temp;
            
            }
    
    }
        
int tot_turn=0,tot_wait=0;    


for(int i=1;i<=n;i++)
    {
    
    tot_turn+=op[i].ct;
    tot_wait+=op[i].wt;
    
    }


float avg_turn=(float)tot_turn/n;
float avg_wait=(float)tot_wait/n;


for(int m=1;m<=n;m++)
    {


    System.out.println("\nprocess "+op[m].pr);
    System.out.print("turn around time : "+op[m].ct);
    System.out.print("     waiting time : "+op[m].wt);


    }


System.out.println("\ntotal turn around time : "+tot_turn);
System.out.println("total waiting time : "+tot_wait);    
System.out.println("avg turn around time : "+avg_turn);
System.out.println("avg waiting time : "+avg_wait);


}


}