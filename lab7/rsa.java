import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.math.*;
public class rsa{
    private static BigInteger p,q,n,phi,e,d;
    private int bitlength=1024;
    private Random r;
    public rsa(){
        r=new Random();
        p=BigInteger.probablePrime(bitlength,r);
        q=BigInteger.probablePrime(bitlength, r);
        System.out.println("p:"+p);
        System.out.println("q:"+q);
        n=p.multiply(q);
        phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e=BigInteger.probablePrime(bitlength/2,r);
        while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0){
            e=e.add(BigInteger.ONE);
        }
        System.out.println("Public key:"+e);
        d=e.modInverse(phi);
        System.out.println("Private key:"+d);
    }
    public static void main(String args[]) throws IOException{
        rsa r=new rsa();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plain text:");
        String sentence=br.readLine();
        System.out.println("Encrypting string:"+sentence);
        System.out.println("In Bytes:"+bytesToString(sentence.getBytes()));
        byte encrypted[]=rsa.encrypt(sentence.getBytes());
        byte decrypted[]=rsa.decrypt(encrypted);
        System.out.println("Decrypted bytes:"+bytesToString(decrypted));
        System.out.println("Decrypted string:"+new String(decrypted,StandardCharsets.UTF_8));
    }
    private static String bytesToString(byte encrypted[]){
        StringBuilder str=new StringBuilder();
        for(byte b:encrypted){
            str.append(Byte.toString(b));
        }
        return str.toString();
    }
    public static byte[] encrypt(byte message[]){
        return (new BigInteger(message)).modPow(e,n).toByteArray();
    }
    public static byte[] decrypt(byte message[]){
        return (new BigInteger(message)).modPow(d,n).toByteArray();
    }
}
