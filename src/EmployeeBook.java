public class EmployeeBook {
    private Employee[] employees;
    private int size;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public void changeEmployee(String name, String surname,
                               String lastname, Integer salary, Integer department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (name.equals(employees[i].getName())
                    && surname.equals(employees[i].getSurname())
                    && lastname.equals(employees[i].getPatronymic())) {
                if (department != null) {
                    employees[i].setDepartment(department);
                }
                if (salary != null) {
                    employees[i].setSalary(salary);
                }
            }
        }
    }

    public void changeEmployeeSalary(String name, String surname,
                                     String lastname, Integer salary) {
        changeEmployee(name, surname, lastname, salary, null);

    }

    public void changeEmployeeDepartment(String name, String surname,
                                         String lastname, Integer department) {
        changeEmployee(name, surname, lastname, null, department);

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
                employees[--size] = null;
                return;
            }
        }
    }

    public void getAllInfoAllEmployee() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            System.out.println(employees[i]);
        }
    }

    public int calculateSumSalaries() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public int findMidSalary() {
        int mid = calculateSumSalaries() / size;
        return mid;
    }

    public int findBigSalary() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (max < employees[i].getSalary()) {
                max = employees[i].getSalary();
            }
        }
        return max;
    }

    public int findLittleSalary() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (min > employees[i].getSalary()) {
                min = employees[i].getSalary();
            }
        }
        return min;
    }

    public void printEmployeeNSP() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
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
                break;
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
                break;
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

    public void calculateIndexSalaryByDepartment(int department, float index) {
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

    public int calculateMidSalaryByDepartment(int department) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                count++;
                sum += employee.getSalary();
            }
        }
        return sum / count;
    }

    public int calculateSumSalaryDepartment(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public int findBigSalaryByDepartment(int department) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            Employee employee = employees[i];
            if (employee.getDepartment() == department && max < employee.getSalary()) {
                max = employee.getSalary();
            }
        }
        return max;
    }

    public int findLittleSalaryByDepartment(int department) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            }
            if (employees[i].getDepartment() == department && min > employees[i].getSalary()) {
                min = employees[i].getSalary();
            }
        }
        return min;
    }

    public void getStaffMaxSalaryInt(int summa) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getSalary() > summa) {
                System.out.println(employees[i]);
            }
        }
    }

    public void getStaffMinSalaryInt(int summa) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return;
            }
            if (employees[i].getSalary() < summa) {
                System.out.println(employees[i]);
            }
        }
    }
}
