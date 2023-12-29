import java.util.Objects;

public class JustClass {
    public static void main(String[] args) {

        //print somePerson person = new Person("John");
        Dog dog = new Dog("Buddy");
        Person person = new Person("Andriy");
        person.setInn(2);
        Person person1 = null;
        try {
            person1 = (Person) person.clone();
            System.out.println(person);
            System.out.println(person1);
        } catch (CloneNotSupportedException e) {


        }


        System.out.println(compare(person1,person));
    }

    public static boolean compare(Person a, Person b) {
        return a.equals(b);
    }
}

class Person {

    private String name;
    private int inn;
    private Dog dog;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = new Person(name);
        person.setInn(inn);
       // Dog dog = (Dog) this.dog.clone();
        person.setDog(dog);
        return person;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", inn=" + inn +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inn);
    }

    public Person(String name) { this.name = name; }

    public void greet() { System.out.println("Hello, my name is " + name); }

}

class Dog {

    private String name;
    private Duck duck;
    private int age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog(String name) { this.name = name; }

    public void bark() { System.out.println("Woof! My name is " + name); }

}
class Duck{

}