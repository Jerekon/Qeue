import java.util.*;

public class Main {
    public static void main(String[] args) {

        Deque<Person> attraction = new ArrayDeque<>();
        for (Person nextPerson : generateClients()) {
            attraction.offerLast(nextPerson);
        }
        while (!attraction.isEmpty()) {
            Person nextClient = attraction.pollFirst();
            nextClient.setTickets(nextClient.getTickets() - 1);
            System.out.print(nextClient.getName() + " " + nextClient.getLastName() + " - raid on attraction, ");
            System.out.println(nextClient.getTickets() > 0 ? ("Left tickets: " + nextClient.getTickets()) : "tickets end.");
            if (nextClient.getTickets() > 0) {
                attraction.offerLast(nextClient);
            }
//            System.out.println(attraction.isEmpty() ? "Queue is empty." : ("in line: " + attraction));
        }
    }

    public static List<Person> generateClients() {
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("Ivan", "Gentle", 2));
        listPerson.add(new Person("Alex", "Impudent", 6));
        listPerson.add(new Person("Olya", "Ambulance", 4));
        listPerson.add(new Person("Petr", "Ober", 5));
        listPerson.add(new Person("Vasya", "Normal", 3));
        return listPerson;
    }
}