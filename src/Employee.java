import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private Integer department;
    private Integer salary;
    private static int count;

    public Employee(String name, String surname, String patronymic, Integer department, Integer salary) {
        id = increment();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
    }

    public int increment() {
        return count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + getId() +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Employee employee = (Employee) obj;
        return name.equals(employee.name)
                && surname.equals(employee.surname)
                && patronymic.equals(employee.patronymic);
    }
}
