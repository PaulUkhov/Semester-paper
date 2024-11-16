class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
        addCommand("Мяукать");
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}


