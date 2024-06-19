import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class randombaseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Set<Integer> numberSet = new HashSet<>();
        int[] computerNumbers = new int[3];

        // 컴퓨터의 숫자 생성
        while (numberSet.size() < 3) {
            int randomNumber = random.nextInt(10);
            numberSet.add(randomNumber);
        }

        int index = 0;
        for (Integer num : numberSet) {
            computerNumbers[index++] = num;
        }

        System.out.println("컴퓨터가 숫자를 선택했습니다. 0과 9 사이의 서로 다른 숫자 3개를 맞춰보세요!");

        int attempts = 0;

        while (true) {
            attempts++;
            System.out.print("세 자리 숫자를 입력하세요: ");
            String userInput = scanner.nextLine();

            // 입력값 검증
            if (userInput.length() != 3 || !userInput.matches("[0-9]+")) {
                System.out.println("잘못된 입력입니다. 0과 9 사이의 서로 다른 세 자리 숫자를 입력하세요.");
                continue;
            }

            // 문자열을 정수 배열로 변환
            int[] userNumbers = new int[3];
            for (int i = 0; i < 3; i++) {
                userNumbers[i] = Character.getNumericValue(userInput.charAt(i));
            }

            // 스트라이크와 볼 계산
            int strikes = 0;
            int balls = 0;
            for (int i = 0; i < 3; i++) {
                if (userNumbers[i] == computerNumbers[i]) {
                    strikes++;
                } else if (numberSet.contains(userNumbers[i])) {
                    balls++;
                }
            }

            // 피드백 제공
            System.out.println(strikes + "S " + balls + "B");

            // 정답 여부 확인
            if (strikes == 3) {
                System.out.println("축하합니다! " + attempts + "번 만에 맞추셨습니다.");
                break;
            }
        }

        scanner.close();
    }
}
