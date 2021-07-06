package ch.bbw.passwortsafe;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PasswordController {
    Login login = new Login();

    private final PasswordService service;

    PasswordController(PasswordService service) {
        this.service = service;
    }


    @PostMapping("/login")
    public List<PasswordTo> login(@RequestParam String user, @RequestParam String password) {
        if (login.isPasswordMatching(password) && login.isUserMatching(user)) {
            return service.getAll();
        }
        return null;
    }

    @PostMapping("/add")
    public void addPassword(@RequestParam PasswordCreateTo password) {
        service.addPassword(password);
    }

    @GetMapping("/getAll")
    public void getAll() {
        service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePassword(@PathVariable Long id) {
        service.deleteById(id);
    }


}
