import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        String answer;
        if(str.equals("1 2 3 4 5 6 7 8")) answer = "ascending";
        else if(str.equals("8 7 6 5 4 3 2 1")) answer = "descending";
        else answer = "mixed";

        System.out.println(answer);
    }
}