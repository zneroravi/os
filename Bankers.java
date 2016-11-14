//for max matrix give input in form of a 2d matrix with the value of a,b,c for x,y,z (eg:[[2,2,0],[0,2,2],[2,0,2]])
//give input without brackets commas separated by spaces
//for available matrix give the instances of resources i.e. how many resources are available
//allocation matrix me kitne resources allocated hai already vo dalna hai
//for part c already modified won't let deadlocks occour if possible is resources are less then program will terminate without causing a deadlock
//for part a input- allocate[1 1 0 0 1 3 0 0 0], max[1 3 0 0 3 3 0 0 0], avail[3 1 3]
//for part b input- allocate[1 1 0 0 1 1 1 0 1], max[3 3 0 0 3 3 3 0 3], avail[1 1 1]

import java.util.Scanner;
public class Bankers{
  
    private int need[][],allocate[][],max[][],avail[][],np,nr;
     
    private void input(){
     Scanner sc=new Scanner(System.in);
     //System.out.print("Enter no. of processes and resources : ");
     //np=sc.nextInt();  //no. of process
     //nr=sc.nextInt();  //no. of resources
     need=new int[3][3];  //initializing arrays
     max=new int[3][3];
     allocate=new int[3][3];
     avail=new int[1][3];
      
     System.out.println("Enter allocation matrix -->");
     for(int i=0;i<3;i++)
          for(int j=0;j<3;j++)
         allocate[i][j]=sc.nextInt();  //allocation matrix
       
     System.out.println("Enter max matrix -->");
     for(int i=0;i<3;i++)
          for(int j=0;j<3;j++)
         max[i][j]=sc.nextInt();  //max matrix
       
        System.out.println("Enter available matrix -->");
        for(int j=0;j<3;j++)
         avail[0][j]=sc.nextInt();  //available matrix
         
        sc.close();
    }
     
    private int[][] calc_need(){
       for(int i=0;i<3;i++)
         for(int j=0;j<3;j++)  //calculating need matrix
          need[i][j]=max[i][j]-allocate[i][j];
        
       return need;
    }
  
    private boolean check(int i){
       //checking if all resources for ith process can be allocated
       for(int j=0;j<3;j++) 
       if(avail[0][j]<need[i][j])
          return false;
    
    return true;
    }
 
    public void isSafe(){
       input();
       calc_need();
       boolean done[]=new boolean[3];
       int j=0;
 
       while(j<3){  //until all process allocated
       boolean allocated=false;
       for(int i=0;i<3;i++)
        if(!done[i] && check(i)){  //trying to allocate
            for(int k=0;k<3;k++)
            avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
         System.out.println("Allocated process : "+i);
         allocated=done[i]=true;
               j++;
             }
          if(!allocated) break;  //if no allocation
       }
       if(j==3)  //if all processes are allocated
        System.out.println("\nSafely allocated");
       else
        System.out.println("All proceess cant be allocated safely");
    }
     
    public static void main(String[] args) {
       new Bankers().isSafe();
    }
}