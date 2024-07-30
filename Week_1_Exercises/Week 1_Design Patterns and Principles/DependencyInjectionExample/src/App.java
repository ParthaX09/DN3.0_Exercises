interface CustomerRepository {
    Customer findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // For simplicity, let's return a dummy customer
        return new Customer(id, "John Doe");
    }
}

class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}

public class App {
    public static void main(String[] args) {
        // Create a repository instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById(1);
        System.out.println(customer);
    }
}