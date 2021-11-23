package com.gabrego.citasapi.controller;

import com.gabrego.citasapi.entity.ClinicSchedule;
import com.gabrego.citasapi.service.ClinicScheduleService;
import com.gabrego.citasapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/appointment/clinicschedule")
public class ClinicScheduleRestController {

    @Autowired
    private ClinicScheduleService clinicScheduleService;


    @GetMapping("/")
    public List<ClinicSchedule> findAllClinicSchedules() {
        return clinicScheduleService.findAll();
    }

    @GetMapping("/clinic/{idClinic}")
    public List<ClinicSchedule> findAllClinicSchedulesByClinic(@PathVariable int idClinic) {
        return clinicScheduleService.findAllByClinicId(idClinic);
    }

    @GetMapping("/{scheduleId}")
    public ClinicSchedule getClinicScheduleById(@PathVariable int scheduleId){
        ClinicSchedule doctorSchedule = clinicScheduleService.findById(scheduleId);

        if(doctorSchedule == null) {
            return new ClinicSchedule();
        }
        //retornará al usuario con id pasado en la url
        System.out.println(doctorSchedule);
        return doctorSchedule;
    }
    

    @PostMapping("/")
    public ClinicSchedule addClinicSchedule(@RequestBody ClinicSchedule doctorSchedule) {
        doctorSchedule.setId(0);
        //User user = userService.findById(doctorSchedule.getDoctor_id().getId());
        //doctorSchedule.setDoctor_id(user);
        //Este metodo guardará al usuario enviado
        clinicScheduleService.save(doctorSchedule);

        return doctorSchedule;

    }

    @PutMapping("/")
    public ClinicSchedule updateClinicSchedule(@RequestBody ClinicSchedule doctorSchedule) {
        System.out.println(doctorSchedule);
        //User user = userService.findById(doctorSchedule.getDoctor_id().getId());
        //doctorSchedule.setDoctor_id(user);
        //Este metodo guardará al usuario enviado
        clinicScheduleService.save(doctorSchedule);
        return doctorSchedule;

    }

    @DeleteMapping("/{patientId}")
    public int deleteClinicScheduleById(@PathVariable int doctorScheduleId) {

        ClinicSchedule doctorSchedule = clinicScheduleService.findById(doctorScheduleId);

        if(doctorSchedule == null) {
            return 0;
        }

        return clinicScheduleService.deleteById(doctorScheduleId);
    }
    
}
