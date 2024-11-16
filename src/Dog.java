// Дочерние классы
class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age);
        addCommand("Сидеть");
        addCommand("Голос");
    }

    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
}

