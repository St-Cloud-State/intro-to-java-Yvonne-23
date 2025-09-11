public class Person {
    private String firstName;
    private String lastName;
    private String id;

    // Constructor
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getId() { return id; }

    // toString
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName;
    }
}