public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public EmployeeManagementSystem() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            // Resize array if needed
            resize();
        }
        employees[size++] = employee;
    }

    // Search for an employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; // Not found
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Remove last element
                return true; // Successfully deleted
            }
        }
        return false; // Not found
    }

    // Resize the array
    private void resize() {
        Employee[] newArray = new Employee[employees.length * 2];
        System.arraycopy(employees, 0, newArray, 0, size);
        employees = newArray;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // Add employees
        system.addEmployee(new Employee("E001", "Alice", "Manager", 75000));
        system.addEmployee(new Employee("E002", "Bob", "Developer", 60000));
        system.addEmployee(new Employee("E003", "Charlie", "Designer", 55000));

        // Traverse employees
        System.out.println("All Employees:");
        system.traverseEmployees();

        // Search for an employee
        Employee foundEmployee = system.searchEmployee("E002");
        System.out.println("Search Result: " + (foundEmployee != null ? foundEmployee : "Not found"));

        // Delete an employee
        boolean deleted = system.deleteEmployee("E003");
        System.out.println("Delete Result: " + (deleted ? "Deleted successfully" : "Not found"));

        // Traverse employees again
        System.out.println("All Employees After Deletion:");
        system.traverseEmployees();
    }
}
