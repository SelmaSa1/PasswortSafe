package ch.bbw.passwordSafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PasswordController {

    Login login = new Login();

    private final PasswordService service;

    @Autowired
    public PasswordController(PasswordService service) {
        this.service = service;
    }


    @PostMapping("/login")
    public List<PasswordTo> login(@RequestBody UserPasswordCredentials userPasswordCredentials) {
        if (login.isPasswordMatching(userPasswordCredentials.getPassword()) && login.isUserMatching(userPasswordCredentials.getUser())) {
            return service.getAll();
        }
        return null;
    }

    @PostMapping("/add")
    public void addPassword(@RequestBody PasswordCreateTo password) {
        System.out.println("New Password " + password.getRemarks());
        service.addPassword(password);
    }

    @GetMapping("/getAll")
    public List<PasswordTo> getAll() {
        System.out.println("getall");
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePassword(@PathVariable Long id) {
        service.deleteById(id);
    }
}
