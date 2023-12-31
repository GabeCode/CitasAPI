package com.gabrego.citasapi.controller;

import com.gabrego.citasapi.entity.Doctor;
import com.gabrego.citasapi.entity.DoctorSchedule;
import com.gabrego.citasapi.service.DoctorScheduleService;
import com.gabrego.citasapi.service.DoctorService;
import com.gabrego.citasapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/appointment/doctorschedule")
public class DoctorScheduleRestController {

    @Autowired
    private DoctorScheduleService doctorScheduleService;

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public List<DoctorSchedule> findAllDoctorSchedules() {
        return doctorScheduleService.findAll();
    }

    @GetMapping("/availability/{doctorId}/{aDate}")
    public List<DoctorSchedule> findAvailabilityByDoctorAndDate(@PathVariable int doctorId, @PathVariable Date aDate) {
        return doctorScheduleService.findAvailabilityByDoctorAndDate(doctorId, aDate);
    }

    @GetMapping("/doctor/{doctorID}")
    public List<DoctorSchedule> findAllDoctorSchedules(@PathVariable int doctorID) {
        return doctorScheduleService.findByDoctorId(doctorID);
    }

    @GetMapping("/{scheduleId}")
    public DoctorSchedule getDoctorScheduleById(@PathVariable int scheduleId){
        DoctorSchedule doctorSchedule = doctorScheduleService.findById(scheduleId);

        if(doctorSchedule == null) {
            return new DoctorSchedule();
        }
        //retornará al usuario con id pasado en la url
        System.out.println(doctorSchedule);
        return doctorSchedule;
    }


    @PostMapping("/")
    public DoctorSchedule addDoctorSchedule(@RequestBody DoctorSchedule doctorSchedule) {
        doctorSchedule.setId(0);
        Doctor doctor = doctorService.findById(doctorSchedule.getDoctor_id().getId());
        doctorSchedule.setDoctor_id(doctor);
        //Este metodo guardará al usuario enviado
        doctorScheduleService.save(doctorSchedule);

        return doctorSchedule;

    }

    @PutMapping("/")
    public DoctorSchedule updateDoctorSchedule(@RequestBody DoctorSchedule doctorSchedule) {
        System.out.println(doctorSchedule);
        Doctor doctor = doctorService.findById(doctorSchedule.getDoctor_id().getId());
        doctorSchedule.setDoctor_id(doctor);
        //Este metodo guardará al usuario enviado
        doctorScheduleService.save(doctorSchedule);
        return doctorSchedule;

    }

    @DeleteMapping("/{patientId}")
    public int deleteDoctorScheduleById(@PathVariable int doctorScheduleId) {

        DoctorSchedule doctorSchedule = doctorScheduleService.findById(doctorScheduleId);

        if(doctorSchedule == null) {
            return 0;
        }

        return doctorScheduleService.deleteById(doctorScheduleId);
    }

}
