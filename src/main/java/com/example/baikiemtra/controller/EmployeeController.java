package com.example.baikiemtra.controller;

import com.example.baikiemtra.model.Employee;
import com.example.baikiemtra.service.impl.DepartmentService;
import com.example.baikiemtra.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    @GetMapping
    private String showAllEmployee(Model model) {
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("department", departmentService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    private String findByEmployeeById(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("department", departmentService.findAll());
            return "employee";
        } else {
            redirectAttributes.addFlashAttribute("message", "Employee Not Found");
            return "redirect:/employee";
        }
    }

    @GetMapping("create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("department", departmentService.findAll());
        return "create";
    }

    @PostMapping("create")
    public String createEmployee( @ModelAttribute Employee employee, Model model, RedirectAttributes redirectAttributes) {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Employee Created Successfully");
            return "redirect:/employee";

    }

    @GetMapping("update/{id}")
    public String updateEmployee(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("department", departmentService.findAll());
            return "update";
        } else {
            redirectAttributes.addFlashAttribute("message", "Employee Not Found");
            return "redirect:/employee";
        }
    }

    @PostMapping("update")
    public String updateEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Employee Updated Successfully");
        return "redirect:/employee";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Employee Deleted Successfully");
        return "redirect:/employee";
    }
}
