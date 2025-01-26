import java.util.*;
public class leaky{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rem=0,sent,received;
        System.out.println("Enter bucket capacity:");
        int capacity=sc.nextInt();
        System.out.println("Enter bucket rate:");
        int rate=sc.nextInt();
        System.out.println("Enter total packets");
        int n=sc.nextInt();
        int buf[]=new int[30];
        System.out.println("Enter packets");
        for(int i=0;i<n;i++){
            buf[i]=sc.nextInt();
        }
        System.out.println("Time\tpsize\taccepted\tsent\trem");
        for(int i=0;i<n;i++){
            if(buf[i]!=0){
                if(rem+buf[i]>capacity){
                    received=-1;
                }else{
                    received=buf[i];
                    rem+=buf[i];
                }
            }else{
                received=0;
            }

            if(rem!=0){
                if(rem<rate){
                    sent=rem;
                    rem=0;
                }else{
                    sent=rate;
                    rem-=rate;
                }
            }else{
                sent=0;
            }


            if(received==-1){
                System.out.println((i+1)+"\t"+buf[i]+"\tdropped\t"+sent+"\t"+rem);
            }else{
                System.out.println((i+1)+"\t"+buf[i]+"\t"+received+"\t"+sent+"\t"+rem);
            }
        }
    }
}
