package week02;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

public class BaseballGame {
    int [] userNum = new int[3];
    String[] arr = new String[3];
    int [] newArr = new int[3];
    int strike;
    int ball;
    int TRY = 0;

    //무작위로 숫자를 생성하는 함수(0~9)
    public int randomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    // 정답을 생성하는 메서드
    private String chooseNum() {
        // 1.랜덤값을 하나 만들고
        // 2.랜던값을 인덱스로 써서 배열에서 값을 하나 뽑아오고
        // 3.값을 String 변수에 저장하고
        // 4. 그값을 배열에서 삭제
        String number = "";
        String[] arrnum = {"0","1","2","3","4","5","6","7","8","9"};

        for (int i = 0; i < 3; i++) {
            int index;
            while (true) {
                index = randomNum();
                if (i == 0 && index == 0)
                    continue;
                if (index < arrnum.length)
                    break;
            }
            number += arrnum[index];

            // 중복되는 것 삭제
            arrnum = numRemove(arrnum, index);
        }
        arr = number.split("");
        for(int i = 0; i < arr.length; i++){
            newArr[i] = Integer.parseInt(arr[i]);
        }
        return number;
    }

    // 배열 삭제 메서드
    private static String[] numRemove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        List<String> result = new ArrayList<>(Arrays.asList(arr));
        result.remove(index);
        return result.toArray(new String[0]);
    }

    // 사용자로부터 받은 입력 값과 정답을 비교해서 점수를 계산해주는 메서드
    // int score += 1  b
    // int score += 10 s
    // strike = score/10
    // ball = score%10
//    private int tryNum(int submint, int answer){
//
//        return 0;
//    }

    // 사용자로부터 입력을 받아내는 메서드
    public void userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요.");
        while(true) {
            for (int i = 0; i < 3; i++) {
                userNum[i] = sc.nextInt();
                for (int j = 0; j < i; j++) {
                    if (userNum[j] == userNum[i]) {
                        System.out.println("중복된 값 입력");
                        i--;
                        break;
                    }
                }
            }


            for (int i = 0; i < newArr.length; i++) {
                for (int j = 0; j < userNum.length; j++) {
                    if (newArr[i] == userNum[j] && i == j) {
                        strike++;

                    }else if(newArr[i] == userNum[j] && i != j){
                        ball++;
                    }
                }
            }
            TRY++;
            System.out.println(TRY+"시도 : "+ userNum[0]+userNum[1]+userNum[2]);
            System.out.println(strike+"S"+ball+"B");
            if(strike==3){
                System.out.println(TRY+"번 만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다");

                break;
            }

            strike = 0;
            ball = 0;
        }
    }


    public static void main(String[] args){
        BaseballGame game = new BaseballGame();
        game.chooseNum();
        game.userInput();
    }
}
