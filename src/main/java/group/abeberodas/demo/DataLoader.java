package group.abeberodas.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(String...strings) throws Exception{
        System.out.println("Loading data ....");
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("MANAGER"));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");
        Role managerrole = roleRepository.findByRole("MANAGER");

       User user = new
                User("dave@admin.com","beastmaster","Admin","Master", true,"DaveWolf");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);



    }
}