import java.io.*;
import java.net.*;

public class tcps{
    public static void main(String args[]) throws Exception{
        ServerSocket sersock=new ServerSocket(4000);
        System.out.println("SERVER ready for connection");
        Socket sock=sersock.accept();
        System.out.println("Connection successful ready for client");
        InputStream istream=sock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        BufferedReader contentRead=new BufferedReader(new FileReader(fname));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        String str;
        while((str=contentRead.readLine())!=null){
            pwrite.println(str);
        }
        sock.close();
        sersock.close();
        contentRead.close();
        pwrite.close();
        contentRead.close();
    }
}
