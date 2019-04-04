package lesson_1.animal;

import lesson_1.Participant;
import lesson_1.enums.Color;

public class Dog extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Dog(String name, Color color, int age, int runDistance, int jumpHeight, int swimDistance) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
    }


    @Override
    public void voice() {
        System.out.println("Гав");
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if(!isOnDistance){
            return;
        }
        if(distance>runDistance){
            isOnDistance=false;
            return;
        }
        System.out.println(String.format("\n%s пробежал кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("%s пругнул на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        if(!isOnDistance){
            return;
        }
        if(distance>swimDistance){
            isOnDistance=false;
            return;
        }
        System.out.println(String.format("%s проплыла дистанцию %d",getName(), distance));
    }
}
