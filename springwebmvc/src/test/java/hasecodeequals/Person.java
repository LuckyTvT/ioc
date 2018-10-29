package hasecodeequals;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/13 21:34
 * @since 1.0.0
 */

public class Person {

    private String name;
    private String gender;
    private int age;
    private String planeNo;

    public Person(String name, String gender, int age, String planeNo) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.planeNo = planeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaneNo() {
        return planeNo;
    }

    public void setPlaneNo(String planeNo) {
        this.planeNo = planeNo;
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + gender.hashCode();
        result = 31 * result + planeNo.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return person.name.equals(name) &&
                person.age == age &&
                person.gender.equals(gender) &&
                person.planeNo.equals(planeNo);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", planeNo='" + planeNo + '\'' +
                '}';
    }
}
