package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application{
    public static void main(String[] args) {
        String inputName = System.console().readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String [] carNames = inputName.split("\\s*,\\s*");

        String inputStr = System.console().readLine("시도할 회수를 입력하세요");
        int inputCount = Integer.parseInt(inputStr);

        checkError.checkCarName(carNames);

        Car[] cars= new Car[carNames.length];

        makeRandom num1 = new makeRandom();
        //System.out.println(num1.randomNum());

        for(int i=0; i<carNames.length; i++){
            cars[i] = new Car(carNames[i]);
        }

        for(int i=0; i<inputCount; i++) {
            startRacing.goOrStay(cars);
        }

        printWinner win = new printWinner();
        win.printChampion(cars);
    }
}

class Car {
    private  int position;
    private String name;
    public Car(String name){
        this.position = 0;
        this.name = name;
    }
    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
class checkError{
    public static void checkCarName(String [] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 한다.");
            }
        }
    }
}

class makeRandom{
    public int randomNum(){
        int number = Randoms.pickNumberInRange(0,9);
        //int number = (int) (Math.random() * 10);
        if(number >= 4) {
            return 1;
        }
        else{
            return 0;
        }
    }
}
class startRacing{
    private static makeRandom ran = new makeRandom();
    private static printRacing pR = new printRacing();
    public static void goOrStay(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (ran.randomNum() == 1) {
                cars[i].setPosition(cars[i].getPosition() + 1);
            }
        }
        pR.printCarPosition(cars);
    }
}

class printRacing{
    public void printCarPosition(Car[] cars){
        for(int i=0; i<cars.length; i++) {
            System.out.print(cars[i].getName() + ": ");
            for(int j =0; j<cars[i].getPosition(); j++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}

class printWinner{
    public void printChampion(Car [] cars){
        int maxPosition = -1;
        List<String> champions = new ArrayList<>();

        for (Car car : cars){
            int position = car.getPosition();
            if(position > maxPosition){
                maxPosition = position;
                champions.clear();
                champions.add(car.getName());
            }
            else if (position == maxPosition){
                champions.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", champions));

    }
}



