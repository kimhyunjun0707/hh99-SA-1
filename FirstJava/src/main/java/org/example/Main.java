package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        내가 좋아하는 요리 제목을 먼저 입력합니다.
        String title = scan.nextLine();
//        요리 별점을 1~5사이의 소수점이 있는 실수로 입력해주세요.
//        nextdouble, nextfloat, nextint 등 정수의 입력에는 개행문자가 처리가 안되서 바로 다음에 오는 문자열 입력에서 바로 개행문자를 받아버림..
//        해결방법
//       1. nextLine()으로 개행문자를 처리한다
          double score = scan.nextDouble();
          scan.nextLine();

//        2. nextline으로 문자를 입력은후 숫자로 변경한다.
//        double score = Double.parseDouble(scan.nextLine());

//        3. Scanner 객체를 두개 선언해서 따로 사용한다.
//        Scanner scan_Num = new Scanner(System.in);
//        double score = scan_Num.nextDouble();

////      4. next()사용
//        정수형 입력으로 버퍼에 남은 개행문자를 해결할 수는 있지만 next()는 띄어쓰기를 기준으로 잡기때문에 문장에 적용하기엔 적합하지않다.
//        String test_Str = scan.next();
//        System.out.println(test_Str);

//        이어서 내가 좋아하는 요리 레시피를 한문장씩 10문장을 입력합니다.

        int int_Score = (int)score;
//        별점 퍼센트
        double per = (int_Score / 5.0) * 100;

        String[] content = new String[10];
        String str = "";

        System.out.println("[ "+ title +" ]");
        System.out.println("별점 : " + int_Score + "("+ per +"%)");


        for(int i=0; i<content.length; i++){
            str = scan.nextLine();
            content[i] = str;
            System.out.println((i+1)+". "+content[i]);
        }
    }
}