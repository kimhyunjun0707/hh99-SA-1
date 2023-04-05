import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baseball {
    public static int getRandomInt() {
        return (int) (Math.random() * 10);
    }

    public static String chooseNum() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String result = "";

        for (int i = 0; i < 3; i++) {
            int tmp = getRandomInt();
            if( i==0 && tmp==0 ) // 0번째 자리에 0이 들어갈 경우
                i--;
            else if(arr[tmp] == -1) // 이미 참조한 숫자였을 경우
                i--;
            else { // 통과
                result += Integer.toString(arr[tmp]);
                arr[tmp] = -1; // 이 숫자는 이제 사용했음을 표시
            }
        }
        return result;
    }

    public static int tryNum(String submit, String answer) {
        int cnt = 0;
        for(int i =0; i<3;i++){
            int idx = answer.indexOf(submit.charAt(i));
            if(idx==i)
                cnt += 10;
            else if (idx!=-1)
                cnt ++;
        }
        return cnt;
    }

    public static void maingame(int count, String answer) {
        Scanner sc = new Scanner(System.in);
        System.out.print(count+"번째 시도 : ");
        String submit = sc.nextLine();
        if(submit.length()==3){
            int result = tryNum(submit, answer);

            int strike = result / 10;
            int ball = result % 10;
            if(strike == 0 && ball != 0)
                System.out.println(ball+"B");
            else if(strike != 0 && ball == 0)
                System.out.println(strike+"S");
            else System.out.println(ball+"B "+strike+"S");

            if(strike==3){
                System.out.println(count+ "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                return;
            } else{
                maingame(++count, answer);
            }
        } else {
            System.out.println("세자릿수를 입력해주세요.");
            maingame(count, answer);
        }
    }

    public static void main(String[] args) {
        String answer = chooseNum();
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        maingame(1, answer);
    }
}
