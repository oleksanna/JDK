package DZ_4;


public class Employee {
    private final int idNumber;
    private final int phoneNumber;
    private final String name;
    private final String lastName;
    private final int experience;

    public Employee(int idNumber, int phoneNumber, String name, String lastName, int experience) {

        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.lastName = lastName;
        this.experience = experience;
    }


    public int getIdNumber() {
        return idNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperience() {
        return experience;
    }
}