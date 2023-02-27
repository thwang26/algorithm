import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        float sum = 0; // 학점*과목평점
        int creditSum = 0; // 학점총합
        
        for(int n = 1 ; n <= 20 ; n++){
            String subject = scan.nextLine();

            int i = subject.indexOf(" "); //첫번째 공백의 위치
            int j = subject.indexOf(" ", i+1); //두번째 공백의 위치

            float credit = Float.parseFloat(subject.substring(i+1, i+4)); // 학점
            float gradeNum = 0; // 과목평점
            String grade;

            if(subject.substring(j+1, j+2).equals("P"))
                grade = "P";
            else if(subject.substring(j+1, j+2).equals("F"))
                grade = "F";
            else grade = subject.substring(j+1, j+3); // 등급

            if(grade.equals("A+"))
                gradeNum = 4.5f;
            else if(grade.equals("A0"))
                gradeNum = 4.0f;
            else if(grade.equals("B+"))
                gradeNum = 3.5f;
            else if(grade.equals("B0"))
                gradeNum = 3.0f;
            else if(grade.equals("C+"))
                gradeNum = 2.5f;
            else if(grade.equals("C0"))
                gradeNum = 2.0f;
            else if(grade.equals("D+"))
                gradeNum = 1.5f;
            else if(grade.equals("D0"))
                gradeNum = 1.0f;
            else if(grade.equals("F"))
                gradeNum = 0.0f;
            else if(grade.equals("P"))
            {
                gradeNum = 0.0f;
                credit = 0.0f;
            }
            
            sum += credit*gradeNum;
            creditSum += credit;

            if(n==20){
                System.out.printf("%.6f", sum/creditSum);
            }
        }
    }
}