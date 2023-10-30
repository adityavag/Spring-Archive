package wf.adt.ouathspringsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String publicPage() {
        return "<h1>Public Page</h1>" ;
    }
    @GetMapping("/private")
    public String privatePage(Authentication authentication) {
        return "<h1>Welcome To The Private Room ~["+
                authentication.getName()
                + "]~ </h1>" ;
    }
}
