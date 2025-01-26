import java.util.*;
public class crc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("AT SENDER:");
        System.out.println("Enter message");
        String msg=sc.nextLine();
        System.out.println("Enter generator");
        String gen=sc.nextLine();
        int data[]=new int[msg.length()+gen.length()-1];
        int divisor[]=new int[gen.length()];

        for(int i=0;i<msg.length();i++){
            data[i]=Integer.parseInt(msg.charAt(i)+"");
        }

        for(int i=0;i<gen.length();i++){
            divisor[i]=Integer.parseInt(gen.charAt(i)+"");
        }

        for(int i=0;i<msg.length();i++){
            if(data[i]==1){
                for(int j=0;j<divisor.length;j++){
                    data[i+j]^=divisor[j];
                }
            }
        }

        for(int i=0;i<msg.length();i++){
            data[i]=Integer.parseInt(msg.charAt(i)+"");
        }

        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }

        System.out.println();
        System.out.println("AT RECEIVER:");
        System.out.println("Enter message");
        msg=sc.nextLine();
        System.out.println("Enter generator");
        gen=sc.nextLine();
        sc.close();
        for(int i=0;i<msg.length();i++){
            data[i]=Integer.parseInt(msg.charAt(i)+"");
        }

        for(int i=0;i<gen.length();i++){
            divisor[i]=Integer.parseInt(gen.charAt(i)+"");
        }

        for(int i=0;i<msg.length();i++){
            if(data[i]==1){
                for(int j=0;j<divisor.length;j++){
                    data[i+j]^=divisor[j];
                }
            }
        }

        for(int i=0;i<data.length;i++){
            if(data[i]==1){
                System.out.println("INVALID");
                return;
            }
        }
        System.out.println("VALID");
        
    }
}
