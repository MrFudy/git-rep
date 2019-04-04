package lesson_1.animal;

import lesson_1.Participant;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private String name;
    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Robot(int runDistance, int jumpHeight) {
        this.name = "Чаппи";
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
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
            System.out.println(String.format(name+"не смог пробежать дистанцию %d и выбыл", distance));
            return;
        }
        System.out.println(String.format("\n"+name+" пробежал дистанцию %d", distance));
    }

    @Override
    public void jump(int height) {
        if(!isOnDistance){
            return;
        }
        if(height>jumpHeight){
            isOnDistance=false;
            System.out.println(String.format(name+"не смог перепрыгнуть высоту %d и выбыл", height));
            return;
        }
        System.out.println(String.format(name+" перепрыгнул высоту %d", height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance=false;
        System.out.println("У "+name+" случилось короткое замыкание из-за воды и он выбыл");
    }
}
