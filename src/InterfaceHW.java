import java.util.*;

public class InterfaceHW {
    public static void main(String args[]) {
        interface Dish {
            void cook();
        }

        class Soup implements Dish {
            @Override
            public void cook() {
                System.out.println("I cooked soup");
            }
        }

        class Steak implements Dish {
            @Override
            public void cook() {
                System.out.println("I cooked steak");
            }
        }

        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Soup());
        dishes.add(new Steak());

        for (Dish dish : dishes) {
            if (dish instanceof Soup) {
                Soup soup = (Soup) dish;
                soup.cook();
            }
        }

        for (Dish dish : dishes) {
            if (dish instanceof Steak) {
                Steak steak = (Steak) dish;
                steak.cook();
            }
        }
///////////////////////////////////////////////////////////////////

        interface Vehicle {
            void start();

            void stop();
        }

        class Car implements Vehicle {
            @Override
            public void start() {
                System.out.println("Car is starting.");
            }

            @Override
            public void stop() {
                System.out.println("Car is stopping.");
            }
        }

        class Motorcycle implements Vehicle {
            @Override
            public void start() {
                System.out.println("Motorcycle is starting.");
            }

            @Override
            public void stop() {
                System.out.println("Motorcycle is stopping.");
            }
        }


        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Motorcycle());
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.start();
                car.stop();
            }
            if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.start();
                motorcycle.stop();
            }
        }
///////////////////////////////////////////////////////////////////////////////
        interface Electronics {
            void turnOn();

            void turnOf();
        }
        class PC implements Electronics {

            @Override
            public void turnOn() {
                System.out.println("PC on");

            }

            @Override
            public void turnOf() {
                System.out.println("PC of");

            }
        }
        class TV implements Electronics {

            @Override
            public void turnOn() {
                System.out.println("TV on");
            }

            @Override
            public void turnOf() {
                System.out.println("TV of");
            }
        }
        List<Electronics> electronics = new ArrayList<>();
        electronics.add(new PC());
        electronics.add(new TV());
        for (Electronics electronics1 : electronics) {
            if (electronics1 instanceof PC) {
                PC pc = new PC();
                pc.turnOn();
                pc.turnOf();
            }
        }
        for (Electronics electronics1 : electronics) {
            if (electronics1 instanceof TV) {
                TV tv = new TV();
                tv.turnOn();
                tv.turnOf();
            }
        }
////////////////////////////////////////////////////////////////////////////////

    }
}


