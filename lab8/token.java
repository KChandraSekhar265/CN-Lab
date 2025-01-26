import java.util.*;
public class token {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rem=0,req,sent;
        System.out.println("Enter capacity");
        int capacity=sc.nextInt();
        System.out.println("Enter Rate");
        int rate=sc.nextInt();
        System.out.println("Enter total cycles");
        int n=sc.nextInt();
        System.out.println("Time\tRequested\tsent\trem");
        for(int i=0;i<n;i++){
            req=rate;
            if(req+rem>capacity){
                sent=capacity-rem;
                rem=capacity;
            }else{
                sent=req;
                rem+=req;
            }
            System.out.println((i+1)+"\t"+req+"\t"+sent+"\t"+rem);
        }
    }
}
