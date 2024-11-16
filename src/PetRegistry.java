import java.util.ArrayList;
import java.util.List;

public class PetRegistry {
    private List<Pet> pets;

    public PetRegistry() {
        pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        System.out.println("Добавлено новое животное: " + pet.getName());
    }

    public void listPets() {
        if (pets.isEmpty()) {
            System.out.println("В реестре пока нет животных.");
            return;
        }

        System.out.println("Список животных в реестре:");
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.printf("%d. %s (%s), возраст: %d%n", i + 1, pet.getName(), pet.getClass().getSimpleName(), pet.getAge());
        }
    }

    public void showCommands(int petIndex) {
        if (petIndex < 0 || petIndex >= pets.size()) {
            System.out.println("Неверный индекс!");
            return;
        }

        Pet pet = pets.get(petIndex);
        System.out.println("Команды, которые знает " + pet.getName() + ":");
        for (String command : pet.getCommands()) {
            System.out.println("- " + command);
        }
    }

    public void trainPet(int petIndex, String newCommand) {
        if (petIndex < 0 || petIndex >= pets.size()) {
            System.out.println("Неверный индекс!");
            return;
        }

        Pet pet = pets.get(petIndex);
        pet.addCommand(newCommand);
        System.out.println(pet.getName() + " выучил новую команду: " + newCommand);
    }
}
