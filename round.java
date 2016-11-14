// Round Robin 
import java.io.*; 
class round 
{ 
public static void main(String args[])throws IOException 
{ 
DataInputStream in=new DataInputStream(System.in); 
int i,j,k,tq,add=0; 
System.out.println("Enter number of process:"); 
int n=Integer.parseInt(in.readLine()); 
int burst[]=new int[n]; 
int wait[]=new int[n]; 
int total[]=new int[n]; 
int arr[]=new int[n]; 
System.out.println("Enter brust Time:"); 
for(i=0;i<n;i++) 
{ 
System.out.println("Enter brust Time for   "+(i+1)); 
burst[i]=Integer.parseInt(in.readLine()); 
} 
System.out.println("Enter Time quantum:"); 
tq=Integer.parseInt(in.readLine()); 
for(i=0;i<n;i++) 
arr[i]=burst[i]; 
for(i=0;i<n;i++) 
wait[i]=0; 
do 
{ 
for(i=0;i<n;i++) 
{ 
if(burst[i]>tq) 
{ 
burst[i]-=tq; 
for(j=0;j<n;j++) 
{ 
if((j!=i)&&(burst[j]!=0)) 
wait[j]+=tq; 
} 
} 
else 
{ 
for(j=0;j<n;j++) 
{ 
if((j!=i)&&(burst[j]!=0)) 
wait[j]+=burst[i]; 
} 
burst[i]=0; 
} 
} 
add=0; 
for(k=0;k<n;k++) 
add=add+burst[k]; 
} 
while(add!=0); 
for(i=0;i<n;i++) 
total[i]=wait[i]+arr[i]; 
System.out.println("Process\t\tBurst\tWait\tCompleteTime"); 
for(i=0;i<n;i++) 
{ 
System.out.println("Process"+(i+1)+"\t"+arr[i]+"\t"+wait[i]+"\t"+total[i]); 
} 
float avg_wait=0; 
float avg_total=0; 
for(j=0;j<n;j++) 
{ 
avg_wait+=wait[j]; 
} 
for(j=0;j<n;j++) 
{ 
avg_total+=total[j];
} 
System.out.println("Average Wating Time "+(avg_wait/n)+"\n Average Turn Around Time"+(avg_total/n)); 
} 
} 