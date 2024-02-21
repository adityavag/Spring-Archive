package dewashish.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    CustomerRepository customerRepository;

    @SuppressWarnings("null")
    @PostMapping("/register")
    public String register(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
            return "Added !";
        } catch (Exception e) {
            return "Try Again !";
        }
    }

    @GetMapping("/")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
