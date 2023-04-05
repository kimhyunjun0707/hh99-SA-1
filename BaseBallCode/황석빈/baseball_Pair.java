package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class baseball_Pair {
    // 무작위로 숫자를 생성하는 함수(1~9사이)
    private int getRandomInt(){
        int rand = (int)(Math.random()*10000)%10;
        return rand;
    }

    // 정답을 생성하는 메서드
    private String chooseNum(){
        String[] arr = {"0","1","2","3","4","5","6","7","8","9"};
        String answer = new String();                      // 정답 String

        for(int i=0; i<3; i++){
            // 배열에서 하나 뽑기
            int r;
            while(true){
                r = getRandomInt();
//                첫번째 숫자가 0일경우 continue
                if(i==0 && r==0)
                    continue;
//                랜덤 숫자가 arr의 size보다 작으면 break;
                if(r < arr.length)
                    break;
            }
            // String 에 저장
            answer += arr[r];
            // 배열에서 삭제
            arr = remove(arr, r);
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        return answer;
    }

    // 배열 요소 삭제 메서드
    private static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        List<String> result = new ArrayList<>(Arrays.asList(arr));
        result.remove(index);
        return result.toArray(new String[0]);
    }

    //사용자로부터 받은 입력 값과 정답을 비교해서 점수를 계산해주는 메서드
    private int tryNum(String submit, String answer){
        // strike = 10점 , ball = 1점
        int score = 0;
        for(int i=0; i<3; i++){
            String sub = Character.toString(submit.charAt(i));
            // 입력받은 수가 정답에 있다면?
            if(answer.contains(sub)){
                // 위치도 같다면?
                if(answer.indexOf(sub)==i) {
                    score += 10;
                } else {
                    score += 1;
                }
            }
        }
        return score;
    }

    // 사용자로부터 입력을 받아내는 메서드
    public void maingame(){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;                // 시도 회수
        int score = 0;              // 점수판정
        int strike ,ball = 0;       // 스트라이크, 볼 횟수
        String comment = new String();
        String submit = new String();      // 유저가 입력한 값
        String answer = chooseNum();       // 컴퓨터가 생성한 값

        while(true){
            cnt++;
            System.out.print(cnt+"번째 시도 : ");
            submit = sc.nextLine();

            score = tryNum(submit, answer);

            strike = (int)score/10;
            ball = (int)score%10;

            if(strike == 3) {
               comment = "3S";
                System.out.println(cnt+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
               break;
            } else if (ball == 3) {
                comment = "3B";
            } else {
                comment = Integer.toString(ball)+"B"+Integer.toString(strike)+"S";
            }
            System.out.println(comment);
        }
    }
    public static void main(String[] args){
        baseball_Pair bb = new baseball_Pair();
        bb.maingame();
    }
}
