import java.lang.Object;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public void changeEmployee(String name, String surname,
                               String lastname, int salary, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (name.equals(employees[i].getName())
                    && surname.equals(employees[i].getSurname())
                    && lastname.equals(employees[i].getPatronymic())) {
                if (department != 0) {
                    employees[i].setDepartment(department);
                }
                if (salary != 0) {
                    employees[i].setSalary(salary);
                }
            }
        }
        System.out.println("Данные сотрудника изменены");
    }

    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("В книге закончилось место, невозможно добавить сотрудника");
            return;
        }
        employees[size++] = employee;
        System.out.println("Сотрудник - " + employee.getName()
                + " записан в базу,его id - " + employee.getId());
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                System.out.println("Сотрудник - " + employees[i].getName()
                        + " с id - "
                        + employees[i].getId() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }

        }
    }

    public void getAllInfoAllEmployee() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            System.out.println(employees[i].toString());
        }
    }

    public int CalculateSumSalaries() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            sum += employees[i].getSalary();
        }
        System.out.println("Затраты на зарплату работникам - " + sum);
        return sum;
    }

    public void findMidSalary() {
        int mid = CalculateSumSalaries() / size;
        System.out.println("Средняя заработная плата по всем сотрудникам - " + mid);
    }

    public void findBigSalary() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (max < employees[i].getSalary()) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Максимальная зарплата - " + max);
    }

    public void findLittleSalary() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (min > employees[i].getSalary()) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Минимальная зарплата - " + min);
    }

    public void getInfoAllFIO() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            System.out.println("Имя - " + employees[i].getName()
                    + ", Фамилия - " + employees[i].getSurname()
                    + ", Отчество - " + employees[i].getPatronymic());
        }
    }

    public void findEmployeeOfDepartmentMinSalary(int department) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getDepartment() == department) {
                if (employees[i].getSalary() < min) {
                    min = employees[i].getSalary();
                }
            }
        }
        System.out.println("Самая маленка зарплата в отделе - " + department + ", - " + min);
    }

    public void printAllStaffDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getDepartment() == department) {
                System.out.println("name - " + employees[i].getName() + " "
                        + " surmane - " + employees[i].getSurname() + " "
                        + "patronymic - " + employees[i].getPatronymic() + " "
                        + " id - " + employees[i].getId() + " "
                        + "salary - " + employees[i].getSalary());
            }
        }
    }

    public void calculateIndexSalaryDepartment(int department, float index) {
        index = (index / 100) + 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * index));
            }
        }
    }

    public void calculateMidSumSalaryDepartment(int department) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                count++;
                sum += employee.getSalary();
            }
        }
        System.out.println("Средняя зарплата по отделу - "
                + department + ", составляет - " + (sum / count));
    }

    public void calculateSumSalaryDepartment(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в отделе - "
                + department + ", составляет - " + sum);
    }

    public void findDepartmentBigSalary(int department) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department && max < employee.getSalary()) {
                max = employee.getSalary();
            }
        }
        System.out.println("Самая большая зарплата в отделе - "
                + department + ", составляет - " + max);
    }

    public void findDepartmentLittleSalary(int department) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getDepartment() == department && min > employees[i].getSalary()) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Самая маленькая зарплата в отделе - "
                + department + ", составляет - " + min);
    }

    public void indexAllSalary(float index) {
        index = (index / 100) + 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            Employee employee = employees[i];
            employee.setSalary((int) (employee.getSalary() * index));
        }
    }

    public void getStaffMaxSalaryInt(int summa) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getSalary() > summa) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public void getStaffMinSalaryInt(int summa) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getSalary() < summa) {
                System.out.println(employees[i].toString());
            }
        }
    }
}
