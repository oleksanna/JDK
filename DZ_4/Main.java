package DZ_4;


import java.util.List;

//Создать справочник сотрудников
//Необходимо:
//Создать класс справочник сотрудников, который содержит внутри
//коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
//Табельный номер
//Номер телефона
//Имя
//        Стаж
//        Добавить метод, который ищет сотрудника по стажу (может быть список)
//        Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
//        Добавить метод, который ищет сотрудника по табельному номеру
//Добавить метод добавления нового сотрудника в справочник
public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory();
        Employee employee1 = new Employee(1, 902323546, "Иван", "Иванов", 5);
        Employee employee2 = new Employee(2, 924557894, "Светлана", "Матрасова", 3);
        Employee employee3 = new Employee(3, 916275643, "Кирилл", "Зайков", 5);
        Employee employee4 = new Employee(4, 911894235, "Марина", "Петрова", 5);
        Employee employee5 = new Employee(5, 924345287, "Анна", "Васечкина", 4);

        directory.employeesAdd(employee1);
        directory.employeesAdd(employee2);
        directory.employeesAdd(employee3);
        directory.employeesAdd(employee4);
        directory.employeesAdd(employee5);

        List<Employee> employeesByExperience = directory.employeesFindByExperience(5);
        for (Employee employee: employeesByExperience) {
            System.out.printf("Сотрудник со стажем %s лет %s\n " ,employee.getExperience() ,employee.getName() );
        }
        System.out.println();

        List<Employee> employeesByName = directory.employeesFindByName("Марина");
        for (Employee employee: employeesByName) {
            System.out.printf("Телефон сотрудника с именем %s фамилия %s - %s\n",employee.getName(),employee.getLastName(), employee.getPhoneNumber());
        }
        System.out.println();

        Employee employee = directory.employeesFindById(2);
        if (employee != null) {
            System.out.println("Сотрудник со ID 2 найден: " + employee.getName());
        } else {
            System.out.println("Сотрудник со ID 2 не найден:");
        }
    }
}