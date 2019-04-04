package lesson_1;


import lesson_1.animal.Cat;
import lesson_1.animal.Dog;
import lesson_1.animal.Human;
import lesson_1.animal.Robot;
import lesson_1.course.Course;
import lesson_1.course.Cross;
import lesson_1.course.Wall;
import lesson_1.course.Water;
import lesson_1.enums.Color;

public class Application {

    public static void main(String[] args) {
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 10),
                new Dog("Скуби", Color.BROWN, 6, 500, 20, 250),
                new Human("Валера", Color.YELLOW, 35, 250, 2, 150),
                new Robot( 999, 999)

        );

        Course course = new Course(
                new Cross(50),
                new Wall(10),
                new Water(150)
        );

        course.doIt(team);
    }
}
