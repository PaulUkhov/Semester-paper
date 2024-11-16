class Parrot extends Pet {
    public Parrot(String name, int age) {
        super(name, age);
        addCommand("Повторять слова");
    }

    @Override
    public void makeSound() {
        System.out.println("Кррр!");
    }
}