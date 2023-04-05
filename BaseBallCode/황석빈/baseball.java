package week02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baseball {
    String correct;                 // 정답 생성
    String user_answer;             // 유저의 답안
    int cnt;                        // 시도 횟수
    boolean flag;                   // 성공여부
    Map<String, Integer> check;     // 판정
    Scanner sc;                     // 입력스트림

    //초기화 init 메소드
    private void init() {
        this.cnt = 0;
        this.correct = "";
        this.user_answer = "";
        this.check = new HashMap<>();
        this.check.put("ball", 0);
        this.check.put("strike", 0);
        this.sc = new Scanner(System.in);
        this.correct = create_Num();
        this.flag = false;
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
    }

    //랜덤으로 수를 생성해주는 메서드
    public String create_Num() {
        int[] result = new int[3];
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < result.length; i++) {
                result[i] = (int) ((Math.random() * 1000) % 10);  // 배열에 0~9사이 입력
            }
            flag = (result[0] == result[1] || result[0] == result[2] || result[2] == result[1]) ? false : true;       // 중복값 비교
            flag = ( result[0] == 0 ) ? false : true;                                       // 첫번째 숫자 0이면 false
        }
        return String.valueOf(result[0]) + String.valueOf(result[1]) + String.valueOf(result[2]);
    }

    //유저 입력 메서드
    public String user_Input() {
        boolean state = false;
        while (!state) {
            user_answer = sc.nextLine();
            // 아무것도 입력하지않음.
            if (user_answer.equals(""))
                System.out.println("값을 입력해주세요");
            else // 뭔갈 입력했어;
                { // 첫번째 자리에 0이 오면 false
                if(user_answer.charAt(0) == '0'){
                    System.out.println("첫번째 자리에 0은 올 수 없습니다.");
                } // 중복 입력 거부
                else if (user_answer.charAt(0) == user_answer.charAt(1) ||
                        user_answer.charAt(0) == user_answer.charAt(2) ||
                        user_answer.charAt(1) == user_answer.charAt(2))
                {
                    System.out.println("중복된 수를 입력하셨습니다.");
                } else if (user_answer.length()!=3) {
                    System.out.println("세자리 수 입력하세요 룰파괴자야");
                }else
                {
                    state = !state;
                }
            }
        }
        return user_answer;
    }

    //야구게임 동작 로직 메서드
    public void game() {
        while (!flag) {
            cnt += 1;
            System.out.print(cnt + "번째 시도 : ");
            user_Input();                // 유저 정답 입력
            int b = 0;                                  // ball count
            int s = 0;                                  // strike count
            for (int i = 0; i < 3; i++) {
                String num = Character.toString(user_answer.charAt(i));
                //첫번째 자리수가 정답에 포함되어있느냐?
                if (correct.contains(num)) {
                    if (correct.indexOf(num) == i) {            // 포함되어 있고 자리도 맞다 -> strike count ++
                        s += 1;
                        check.put("strike", s);
                    } else {                                    // 포함되어 있지만 자리가 안맞다 -> ball count ++
                        b += 1;
                        check.put("ball", b);
                    }
                }
            }

            String str = "";
            // 둘다 0일경우
            if (check.get("ball") == 0 && check.get("strike") == 0)
                str = "0B0S";
                // 한쪽이 3일경우
            else if (check.get("ball") == 3)
                str = "3S";
            else if (check.get("strike") == 3)
                str = "3B";
                // 둘다 존재할 경우
            else
                str = check.get("ball") + "B" + check.get("strike") + "S";
            System.out.println(str);

            // 3S면 종료
            if (s == 3) {
                System.out.println(cnt + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                flag = true;
            }
            // 초기화
            b = 0;
            s = 0;
            check.put("ball", b);
            check.put("strike", s);
        }
    }

    public static void main(String[] args) {
        baseball bb = new baseball();
        bb.init();
        bb.game();

        // 외부에 메서드 만듬
        // main메서드에서 클래스 선언
        // 클래스.메서드()사용
    }
}
