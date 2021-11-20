package com.gabrego.citasapi.controller;

import com.gabrego.citasapi.entity.Department;
import com.gabrego.citasapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/appointment/department") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/usersapi/
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId){
        Department department = departmentService.findById(departmentId);

        if(department == null) {
            new Department();
        }
        //retornará al usuario con id pasado en la url
        return department;
    }


    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department) {
        department.setId(0);

        //Este metodo guardará al usuario enviado
        departmentService.save(department);

        return department;

    }

    @PutMapping("/")
    public Department updateDepartment(@RequestBody Department clinic) {

        departmentService.save(clinic);

        //este metodo actualizará al usuario enviado

        return clinic;
    }

    @DeleteMapping("/{departmentId}")
    public int deleteAppointment(@PathVariable int departmentId) {

        Department clinic = departmentService.findById(departmentId);

        if(clinic == null) {
            return 0;
        }

        return departmentService.deleteById(departmentId);
    }

    
}
