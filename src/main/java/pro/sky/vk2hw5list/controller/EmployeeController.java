package pro.sky.vk2hw5list.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.vk2hw5list.model.Employee;
import pro.sky.vk2hw5list.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee add(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.add(name,lastName);
}
    @GetMapping("/remove")
    public Employee remove(@RequestParam String name, @RequestParam String lastName)  {
        return employeeService.remove(name,lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.find(name,lastName);
    }
}

