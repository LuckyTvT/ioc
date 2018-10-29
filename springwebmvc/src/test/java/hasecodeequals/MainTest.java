package hasecodeequals;

import java.util.HashSet;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/13 21:34
 * @since 1.0.0
 */

public class MainTest {

    public static void main(String[] args) {

        HashSet<Person> people = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person("张三", "male", 15, "125561");
            people.add(person);
        }
        for (int i = 0; i < 5; i++) {
            Person person = new Person("李四", "female", 151, "125561");
            people.add(person);
        }
        for (int i = 0; i < 5; i++) {
            Person person = new Person("王老五", "female", 151, "125561");
            people.add(person);
        }

        for (Person person : people) {
            System.out.println(person);
        }

        int h;
        Person person1 = new Person("王老五", "female", 151, "125561");
        h = 1;
        System.out.println(h);
        int p = h >>>16;
        System.out.println(p);
        int i = h ^ p;
        System.out.println(i);

    }
}
