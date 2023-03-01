package com.github.GuilhermePonce.Medilab.controller;


import com.github.GuilhermePonce.Medilab.model.Telefone;
import com.github.GuilhermePonce.Medilab.repositories.TelefoneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TelefoneController {

    private final TelefoneRepository telefoneRepository;

    public TelefoneController(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Telefone telefone) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(Telefone telefone, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        telefoneRepository.save(telefone);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", telefoneRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid telefone codigo:" + id));

        model.addAttribute("user", telefone);
        return "update-user";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Telefone telefone,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            telefone.setCodigo(id);
            return "update-user";
        }

        telefoneRepository.save(telefone);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        Telefone telefone = telefoneRepository.findByCodigoAndActive(id, true)
                .orElseThrow(() -> new IllegalArgumentException("Invalid telefone codigo:" + id));
        telefoneRepository.delete(telefone);
        return "redirect:/index";
    }

}
