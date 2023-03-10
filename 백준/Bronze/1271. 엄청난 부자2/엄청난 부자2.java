import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        BigInteger a = new BigInteger(str.split(" ")[0]);
        BigInteger b = new BigInteger(str.split(" ")[1]);

        System.out.println(a.divide(b));
        System.out.println(a.mod(b));
    }
}