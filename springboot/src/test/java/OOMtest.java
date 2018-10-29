import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/15 20:43
 * @since 1.0.0
 */

public class OOMtest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        while(true){
            Person person = new Person();
            list.add(person);
        }
    }
}

class Person{

    private String name;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
