package week02;

import java.util.Scanner;

public class randombaseball {

    public static void main(String[] args) {
        int comFirstNum = (int) (Math.random() * 10);
        int comSecondNum = (int) (Math.random() * 10);
        if (comFirstNum == comSecondNum) {
            while (comFirstNum == comSecondNum) {
                comSecondNum = (int) (Math.random() * 10);
            }
        }
        int comThirdNum = (int) (Math.random() * 10);
        if ((comThirdNum == comFirstNum) || (comThirdNum == comSecondNum)) {
            while (true) {
                if((comThirdNum != comFirstNum) && (comThirdNum != comSecondNum)){
                    break;
                }
                comThirdNum = (int) (Math.random() * 10);
            }
        }
        int computerNum = comFirstNum * 100 + comSecondNum * 10 + comThirdNum;
        computerNum=76;
        comFirstNum=0;
        comSecondNum=7;
        comThirdNum=6;
        System.out.println(computerNum);

        Number[] comNumber = new Number[3];
        Number[] userNumber = new Number[3];
        for(int i=0; i<comNumber.length;i++){
            comNumber[i] = new Number();
        }
        for(int i=0; i<userNumber.length;i++){
            userNumber[i] = new Number();
        }

        comNumber[0].num = comFirstNum;
        comNumber[1].num = comSecondNum;
        comNumber[2].num = comThirdNum;
        comNumber[0].digit = 0;
        comNumber[1].digit = 1;
        comNumber[2].digit = 2;

        boolean flag = true;
        int userNum = 0;
        int userUnitsNum = 0;
        int userTensNum = 0;
        int userHundredsNum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int tryNum = 0;
        while (flag == true) {
            System.out.print(tryNum++ + 1 + "번째 시도 : ");
            int ballCnt = 0;
            int strikeCnt = 0;
            userNum = sc.nextInt();
            userHundredsNum = userNum / 100;
            userTensNum = (userNum / 10) % 10;
            userUnitsNum = userNum % 10;

            userNumber[0].num = userHundredsNum;
            userNumber[1].num = userTensNum;
            userNumber[2].num = userUnitsNum;
            userNumber[0].digit = 0;
            userNumber[1].digit = 1;
            userNumber[2].digit = 2;

            for(int i=0;i<3;i++) {
                for (int j = 0; j < 3; j++) {
                    if(userNumber[i].num==comNumber[j].num){
                        if(userNumber[i].digit==comNumber[j].digit) {
                            strikeCnt++;
                        }
                        else{
                            ballCnt++;
                        }
                    }
                }
            }
            if(strikeCnt==3){
                flag=false;
            }
            System.out.println(ballCnt+"B"+strikeCnt+"S");
        }
        System.out.println(tryNum+"번만에 맞히셨습니다.");

    }
}
