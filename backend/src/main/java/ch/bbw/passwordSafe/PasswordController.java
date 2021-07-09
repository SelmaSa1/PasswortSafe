package ch.bbw.passwordSafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPassword(@RequestBody PasswordCreateTo password) {
        System.out.println("New Password " + password.getRemarks());
        service.addPassword(password);
        return ResponseEntity.ok(password);
    }

    @GetMapping("/getAll")
    public List<PasswordTo> getAll() {
        System.out.println("getall");
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePassword(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
