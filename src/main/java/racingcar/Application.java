package racingcar;
public class Application{
    public static void main(String[] args) {
        String inputName = System.console().readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String [] carNames = inputName.split("\\s*,\\s*");

        String inputStr = System.console().readLine("시도할 회수를 입력하세요");
        int inputCount = Integer.parseInt(inputStr);


        checkError.checkCarName(carNames);
        Car[] cars= new Car[carNames.length];

        for(int i=0; i<carNames.length; i++){
            cars[i] = new Car(carNames[i]);
        }


    }
}

class Car {

    private  int position;

    public Car(String name){
        this.position = 0;
    }
    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
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


