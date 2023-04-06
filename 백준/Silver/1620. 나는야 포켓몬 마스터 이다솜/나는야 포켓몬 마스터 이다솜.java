
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

// 백준
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int BSearch(String arr[], String target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if (arr[mid].split(" ")[0].compareTo(target) == 0) {
                return Integer.parseInt(arr[mid].split(" ")[1])+1;
            }
            else if (arr[mid].split(" ")[0].compareTo(target) > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[] pokemon = new String[n];
        String[] pokemonCopy = new String[n];

        String mob;
        for(int i = 0 ; i < n ; i++){
            mob = br.readLine();
            pokemon[i] = mob;
            pokemonCopy[i] = mob.toLowerCase()+" "+i;
        }

        Arrays.sort(pokemonCopy);

        String findMob = "";
        String answerMob = "";
        int answerMobNum = 0;

        for(int i = 0 ; i < m ; i++){
            findMob = br.readLine();
            if(findMob.charAt(0)>='0' && findMob.charAt(0)<= '9'){
                answerMob = pokemon[Integer.parseInt(findMob)-1];
                bw.write(answerMob+"\n");
            }// 번호로 이름찾기
            else {
                answerMobNum = BSearch(pokemonCopy, findMob.toLowerCase());
                bw.write(answerMobNum+"\n");
                //이름순으로 정렬한 배열
            }// 이름으로 번호찾기
        }
        bw.flush();
        bw.close();
        br.close();
    }
}