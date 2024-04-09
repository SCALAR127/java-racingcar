package racingcar;
import java.util.ArrayList;
public class Application{
    public static void main(String[] args) {
        String inputName = System.console().readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String [] carNames = inputName.split("\\s*, \\s*");

        String inputStr = System.console().readLine("시도할 회수를 입력하세요");
        int inputCount = Integer.parseInt(inputStr);

        checkError.checkCarName(carNames);


    }
}
class checkError{
    public static void checkCarName(String [] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                System.out.println("IllegalArgumentException");
                return;
            }
        }
    }
}

