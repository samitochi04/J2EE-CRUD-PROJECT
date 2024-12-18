package com.example.demo.controller;

import com.example.demo.exception.NoSuchComputerExistsException;
import com.example.demo.model.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/computers")
public class UserViewController {

    private final ComputerService computerService;

    @Autowired
    public UserViewController(ComputerService computerService) {
        this.computerService = computerService;
    }

    // Display all users
    @GetMapping
    public String viewUserList(Model model) {
        model.addAttribute("computers", computerService.getAllComputers());
        return "computer_list";
    }

    // Show form for creating a new user
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("computer", new Computer());
        return "computer_form";
    }

    // Display details for a specific user
    @GetMapping("/{id}")
    public String viewUser(@PathVariable("id") Long id, Model model) {
        Computer computer = computerService.getComputerById(id)
                               .orElseThrow(() -> new NoSuchComputerExistsException("User not found"));
        model.addAttribute("computer", computer);
        return "computer_details";
    }

    // Show form for updating an existing user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Computer computer = computerService.getComputerById(id)
                               .orElseThrow(() -> new NoSuchComputerExistsException("User not found"));
        model.addAttribute("computer", computer);
        return "computer_form";
    }

    // Create or update user based on form data
    @PostMapping
    public String createUser(@ModelAttribute Computer computer) {
    	computerService.saveComputer(computer);
        return "redirect:/view/computers";
    }

    // Update an existing user
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute Computer computer) {
    	computer.setId(id);
    	computerService.updateComputer(computer);
        return "redirect:/view/computers";
    }

    // Delete a user by ID
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
    	computerService.deleteComputerById(id);
        return "redirect:/view/computers";
    }
}
