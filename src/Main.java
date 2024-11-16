import java.util.Scanner;
//13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
//14. Написать программу, имитирующую работу реестра домашних животных.
//В программе должен быть реализован следующий функционал:
//14.1 Завести новое животное
//14.2 определять животное в правильный класс
//14.3 увидеть список команд, которое выполняет животное
//14.4 обучить животное новым командам
//14.5 Реализовать навигацию по меню
//15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
//значение внутренней̆ int переменной̆ на 1 при нажатие “Завести новое
//животное” Сделайте так, чтобы с объектом такого типа можно было работать в
//блоке try-with-resources. Нужно бросить исключение, если работа с объектом
//типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
//считать в ресурсе try, если при заведения животного заполнены все поля.

public class Main {
    public static void main(String[] args) {
        PetRegistry registry = new PetRegistry();
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter();
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Показать всех животных");
            System.out.println("3. Посмотреть команды животного");
            System.out.println("4. Обучить животное новой команде");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка ввода

            switch (choice) {
                case 1:
                    System.out.print("Введите тип животного (dog/cat/parrot): ");
                    String type = scanner.nextLine().trim();
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();

                    // Проверка заполненности всех полей
                    if (!type.isEmpty() && !name.isEmpty() && age > 0) {
                        switch (type.toLowerCase()) {
                            case "dog":
                                registry.addPet(new Dog(name, age));
                                break;
                            case "cat":
                                registry.addPet(new Cat(name, age));
                                break;
                            case "parrot":
                                registry.addPet(new Parrot(name, age));
                                break;
                            default:
                                System.out.println("Неизвестный тип животного!");
                                continue;
                        }
                        counter.add(); // Увеличиваем счетчик, если все поля заполнены
                    } else {
                        System.out.println("Ошибка: Все поля должны быть заполнены корректно!");
                    }
                    break;
                case 2:
                    registry.listPets();
                    break;
                case 3:
                    System.out.print("Введите номер животного: ");
                    int petIndex = scanner.nextInt() - 1;
                    registry.showCommands(petIndex);
                    break;
                case 4:
                    System.out.print("Введите номер животного: ");
                    petIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Очистка ввода
                    System.out.print("Введите новую команду: ");
                    String newCommand = scanner.nextLine();
                    registry.trainPet(petIndex, newCommand);
                    break;
                case 5:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}


