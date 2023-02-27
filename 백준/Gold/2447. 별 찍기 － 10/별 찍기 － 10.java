import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void star(int x, int y, int n) throws IOException{
        if((x/n)%3 == 1 && (y/n)%3 == 1){
            //System.out.print(" ");
            bw.write(" ");
        }else{
            if(n/3==0){
                //System.out.print("*");
                bw.write("*");
            }else{
                star(x,y,n/3);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //long start = System.currentTimeMillis();
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                star(x,y,n);
            }
            bw.write("\n");
            //System.out.println();
        }  
        bw.flush();
        bw.close();
        //long end = System.currentTimeMillis();
        //System.out.println("실행시간 : " + (end - start)/1000.0+"s");
    }
}