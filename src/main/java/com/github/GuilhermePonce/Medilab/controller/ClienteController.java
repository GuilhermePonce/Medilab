package com.github.GuilhermePonce.Medilab.controller;


import com.github.GuilhermePonce.Medilab.model.Cliente;
import com.github.GuilhermePonce.Medilab.repositories.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Cliente cliente) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        clienteRepository.save(cliente);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", clienteRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cliente user = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cliente codigo:" + id));

        model.addAttribute("Cliente", user);
        return "update-user";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Cliente cliente,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            cliente.setCodigo(id);
            return "update-user";
        }

        clienteRepository.save(cliente);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
         Cliente cliente = clienteRepository.findByCodigoAndActive(id, true)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Cliente codigo:" + id));
        clienteRepository.delete(cliente);
        return "redirect:/index";
    }
}
