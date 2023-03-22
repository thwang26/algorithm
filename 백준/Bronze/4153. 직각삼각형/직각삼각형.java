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
import java.util.function.IntToLongFunction;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import java.util.Arrays;

public class Main {

    //백준
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        while(true){
            String str = scan.nextLine();
            int[] tri = Stream.of(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            if(tri[0]==0) break;
            Arrays.sort(tri);
            if(Math.pow(tri[2], 2)==Math.pow(tri[0], 2)+Math.pow(tri[1], 2)) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}