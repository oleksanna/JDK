package DZ_4;


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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> employeesFindByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> employeesFindByName (String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (Objects.equals(employee.getName(), name)) {
                result.add(employee);
            }
        }
        return result;
    }

    public Employee employeesFindById (int employeeId) {
        for (Employee employee : employees) {
            if (employee.getIdNumber() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void employeesAdd (Employee employee) {
        employees.add(employee);
    }
}