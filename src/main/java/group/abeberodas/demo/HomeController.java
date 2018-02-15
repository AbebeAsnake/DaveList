package group.abeberodas.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller

public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ListsRepository listsRepository;
    @Autowired
    RoleRepository role;
    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("lists",listsRepository.findAll());
        return "index";
    }
    @RequestMapping("/admin")
    public String showAdmin(Model model){
        return "admin";
    }
    @RequestMapping("/login")
    public String showLogin(Model model){
        return "login";
    }
    @GetMapping("/add")
    public String getList(Model model){
        model.addAttribute("lists", new Lists());
        return "listform";
    }
    @PostMapping("/process")
    public String addList(Lists lists, BindingResult result, Model model, Principal p){

     model.addAttribute("role", new Role());
       userService.saveLists(lists);
       return "redirect:/";
    }

    @RequestMapping("/rent/{id}")
    public String rentStatus(@PathVariable("id") long id,Model model) {
        User user = new User();
        Lists list = listsRepository.findOne(id);
        list.isRented = true;

        listsRepository.save(list);
        return "redirect:/";
    }
   @GetMapping("/register")
        public String showRegistration(Model model){
       model.addAttribute("registration", new User());
       return "registration";

       }

    @RequestMapping("/register")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

        model.addAttribute("user", user);

        if(result.hasErrors()){
            return "registration";
        }

        userService.saveUser(user);
        model.addAttribute("message", "User account successfully created");

        return "redirect:/";

    }

}
