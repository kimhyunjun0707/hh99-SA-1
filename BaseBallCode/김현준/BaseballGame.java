package Baseball;

import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        int[] AnswerArr = new int[3];
        //사용자가 입력한 숫자를 넣을 배열 생성
        int inputArr[] = new int[3];

        //입력한 strike
        int strike = 0;
        //입력한값의 ball
        int ball = 0;

        for (int i = 0; i < AnswerArr.length; i++) {
            AnswerArr[i] = (int) (Math.random() * 9 + 1);
            //2.중복확인
            for (int j = 0; j < i; j++) {
                if (AnswerArr[j] == AnswerArr[i]) {
                    i--;
                    //중복이 빠져나가고 윗단계로 이동
                    break;
                }
            }
        }
        for (int x : AnswerArr) {
            System.out.print(x + " ");
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < inputArr.length; i++) {
                System.out.println("숫자입력");
                inputArr[i] = sc.nextInt(); // scanner메서드를 이용해 inputArr에 유저가 입력한 숫자 넣기
                for (int j = 0; j < i; j++) {
                    if (inputArr[j] == inputArr[i]) {
                        //유저가 입력한 i인덱스에 들어갈 숫자가 중복된 숫자인지 확인
                        System.out.println("중복된 값을 입력했습니다.");
                        i--;
                        break;
                    }
                }
            }

        }


    }
}
