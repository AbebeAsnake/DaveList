package group.abeberodas.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ListsRepository listsRepository;
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
    public String addList(Lists lists, BindingResult result){

        listsRepository.save(lists);
       return "redirect:/";
    }
    @RequestMapping("/rent/{id}")
    public String rentStatus(@PathVariable("id") long id,Model model){
        Lists list = listsRepository.findOne(id);
        list.isRented = true;
        listsRepository.save(list);
        return "redirect:/";
    }
}
