package Baseball;


import java.util.Scanner;

public class Baseballpare {
    //랜덤한 숫자를 생성하는 메소드
    public int getRandomInt(int min, int max){
        int Random = (int) (Math.random() * (max - min + 1) + min);
        return Random;
    }

    //정답을 만드는? 메소드
    public String chooseNum() {
        String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String answer = "";
        // 첫번째 자리에 0이 나오지 않도록 처리
        int random = getRandomInt(1, arr.length - 1);
        answer += arr[random];
        //remove(arr,random)arr의 배열에서 random(생성한숫자)번째 있는 원소를제거
        arr = remove(arr, random);

        // 중복되지 않는 3개의 숫자를 뽑아서 answer에 저장
        for (int i = 0; i < 2; i++) {
            random = getRandomInt(0, arr.length - 1);
            answer += arr[random];
            arr = remove(arr, random);
        }

        return answer;
    }


    //배열에서 숫자를 제거하는 메소드
    public static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        String[] newArray = new String[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[j] = arr[i];
            j++;
        }

        return newArray;
    }
    public String Score(int strike, int ball) {
        if (strike == 3) {
            return "3s";
        } else {
            String result = "";
            if (strike > 0) {
                result += strike + "s";
            }
            if (ball > 0) {
                result += ball + "b";
            }
            return result;
        }
    }

    public String tryNum(String submit, String answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < submit.length(); i++) {//사용자에게 입력받은 길이만큼(숫자갯수)반복문을돌린다
            char s = submit.charAt(i);//사용자가 입력한값에서
            for (int j = 0; j < answer.length(); j++) {//정답의 길이만큼 반복문
                char a = answer.charAt(j);
                if (s == a) {//정답이 123이라고하고 사용자가 134라고한다면 사용자의 첫자리수s와 정답의 첫자리 a를 비교합니다
                    if (i == j) {//같다면 스트라이크
                        strike++;
                    } else {//틀리다면 볼
                        ball++;
                    }
                    break;
                }
            }
        }


        return strike + "," + ball;
    }
    public String mainGame() {
        Scanner sc = new Scanner(System.in);
        //입력값을 저장할 변수를 초기화
        String input = "";
        System.out.print("세자리숫자를 입력하세요: ");

        //사용자가 입력한 값이 수가아닐경우다시입력을받는다
        while (!sc.hasNextInt()) {
            System.out.print("정수를 입력하세요: ");
            //입력버퍼에 문자열이 남아있게되어서 sc.next()를넣어서 문자열을 제거해줘야한데요
            sc.next();
        }

        int num = sc.nextInt();
        //변수를 문자열로 변환하여 input 변수에 저장함
        input = String.valueOf(num);

        //사용자가 입력한 숫자가 3자리수가아닐경우다시입력을받는다
        while (input.length() != 3) {
            System.out.println("세 자리 숫자를 입력해주세요.");
            num = sc.nextInt();
            input = String.valueOf(num);
        }

        return input;
    }


}

