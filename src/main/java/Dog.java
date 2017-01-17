public class Dog extends Animal{
    public static void main(String[] args)
    {
        Dog dog = new Dog();
        System.out.println(dog.sound());


        Animal animal = new Dog();
        System.out.println(animal.sound());

        Animal animal1 = new Animal();
        System.out.println(animal1.sound());

        System.out.println(Animal.sound1());


    }

    @Override
    String sound() {
        return "Dog";
    }

    static String sound1(){
        return "Animal Static";
    }
}

class Animal {
    String sound(){
        return "Animal";
    }

    static String sound1(){
        return "Animal Static";
    }
}