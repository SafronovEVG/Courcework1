public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(new Employee("Vladimir", "Volkov",
                "Mikchailovich"
                , 3, 20000));
        employeeBook.addEmployee(new Employee("Евгений", "Сафронов",
                "Владимирович"
                , 2, 12345));
        employeeBook.addEmployee(new Employee("Виктория", "Мамина",
                "Подруговна"
                , 1, 123405));
        employeeBook.addEmployee(new Employee("Федор", "Простоквашинский",
                "Федорович"
                , 4, 22345));
        employeeBook.addEmployee(new Employee("Владимир", "Ульянов",
                "Ильич"
                , 5, 52345));
        employeeBook.addEmployee(new Employee("Юлий", "Цезарь",
                "Гав"
                , 1, 62345));
        employeeBook.addEmployee(new Employee("Дмитрий", "Машонкин",
                "Пиздыкович"
                , 3, 25421));
        employeeBook.addEmployee(new Employee("Кожубей", "Кефиров",
                "Васильевич"
                , 4, 162345));
        employeeBook.addEmployee(new Employee("Чай", "Улонов",
                "Максимович"
                , 5, 92345));
        employeeBook.addEmployee(new Employee("Дыня", "Спелова",
                "Узбековна"
                , 1, 512345));
        employeeBook.removeEmployee(1);
        employeeBook.addEmployee(new Employee("Шейкер", "Протеиновый",
                "Дочевский"
                , 2, 312335));
        System.out.println(employeeBook.findMidSalary());
    }

}