package com.gabrego.citasapi.controller;

import com.gabrego.citasapi.entity.Appointment;
import com.gabrego.citasapi.entity.Clinic;
import com.gabrego.citasapi.service.AppointmentService;
import com.gabrego.citasapi.service.ClinicService;
import com.gabrego.citasapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/appointment/clinic") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/usersapi/
public class ClinicRestController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Clinic> findAll() {
        return clinicService.findAll();
    }

    @GetMapping("/{clinicId}")
    public Clinic getClinicById(@PathVariable int clinicId){
        Clinic clinic = clinicService.findById(clinicId);

        if(clinic == null) {
            new Clinic();
        }
        //retornará al usuario con id pasado en la url
        return clinic;
    }

    @GetMapping("/department/{departmentId}")
    public List<Clinic> findAllByDepartment(@PathVariable int departmentId){

        //retornará al usuario con id pasado en la url
        return clinicService.findByDepartment(departmentId);
    }

    @PostMapping("/")
    public Clinic addClinic(@RequestBody Clinic clinic) {
        clinic.setId(0);

        //Este metodo guardará al usuario enviado
        clinicService.save(clinic);

        return clinic;

    }

    @PutMapping("/")
    public Clinic updateClinic(@RequestBody Clinic clinic) {

        clinicService.save(clinic);

        //este metodo actualizará al usuario enviado

        return clinic;
    }

    @DeleteMapping("/{clinicId}")
    public int deleteAppointment(@PathVariable int clinicId) {

        Clinic clinic = clinicService.findById(clinicId);

        if(clinic == null) {
            return 0;
        }

        return clinicService.deleteById(clinicId);
    }

    
}
