import java.util.Scanner;

public class Main {

    public static boolean croatia(String alpha, int index){
        if(
            alpha.substring(index, index+2).equals("c=")||
            alpha.substring(index, index+2).equals("c-")||
            //alpha.substring(index, index+3).equals("dz=")||
            alpha.substring(index, index+2).equals("d-")||
            alpha.substring(index, index+2).equals("lj")||
            alpha.substring(index, index+2).equals("nj")||
            alpha.substring(index, index+2).equals("s=")||
            alpha.substring(index, index+2).equals("z=")
        )
        return true;
        else return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String alpha = scan.next();
        if(
            alpha.contains("c=")||
            alpha.contains("c-")||
            alpha.contains("dz=")||
            alpha.contains("d-")||
            alpha.contains("lj")||
            alpha.contains("nj")||
            alpha.contains("s=")||
            alpha.contains("z=")
        ){
            int index = 0;
            int cnt = 0;
            while(true){
                if(index == alpha.length()-1 ){
                    cnt++;
                    System.out.println(cnt);
                    return;
                }// 마지막 단어는 카운트업 후 종료
                else if(index > alpha.length()-1){
                    System.out.println(cnt);
                    return;
                }// 크로아티아로 인해 인덱스가 넘어가면 종료

                if(index <= alpha.length()-3){
                    if(alpha.substring(index, index+3).equals("dz="))
                        index += 2;
                } // "dz="면 인덱스 두개밀음
                
                if(index <= alpha.length()-2){
                    if(Main.croatia(alpha, index))
                        index++; 
                }// 크로아티아면 인덱스 한개 밀음
                index++;// 공통적으로 인덱스 한개 밀음
                cnt++; // 한개 카운트업
            }
        }
        else System.out.println(alpha.length()); 
        // 크로아티아가 하나도 없으면 그냥 길이 출력
    }
}