package com.gabrego.citasapi.controller;

import com.gabrego.citasapi.entity.Appointment;
import com.gabrego.citasapi.entity.User;
import com.gabrego.citasapi.service.AppointmentService;
import com.gabrego.citasapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/appointment") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/usersapi/
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/check/{doctorId}/{aDate}/{timeStart}/{timeFinish}")
    public Appointment getAppointmentById(@PathVariable int doctorId, Date aDate, Time timeStart, Time timeFinish){
        Appointment appointment = appointmentService.checkIfExistTimeAndDate(doctorId, aDate, timeStart, timeFinish);

        if(appointment == null) {
            new Appointment();
        }
        //retornará al usuario con id pasado en la url
        return appointment;
    }


    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable int appointmentId){
        Appointment appointment = appointmentService.findById(appointmentId);

        if(appointment == null) {
            new Appointment();
        }
        //retornará al usuario con id pasado en la url
        return appointment;
    }

    @GetMapping("/patient/{userId}")
    public List<Appointment> findAllByPatient(@PathVariable int userId){

        //retornará al usuario con id pasado en la url
        return appointmentService.findByPatientId(userId);
    }

    @PostMapping("/")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        appointment.setId(0);

        //Este metodo guardará al usuario enviado
        appointmentService.save(appointment);

        return appointment;

    }

    @PutMapping("/")
    public Appointment updateAppointment(@RequestBody Appointment appointment) {

        appointmentService.save(appointment);

        //este metodo actualizará al usuario enviado

        return appointment;
    }

    @DeleteMapping("/{appointmentId}")
    public int deleteAppointment(@PathVariable int appointmentId) {

        Appointment appointment = appointmentService.findById(appointmentId);

        if(appointment == null) {
            new Appointment();
        }

        return appointmentService.deleteById(appointmentId);
    }

    
}
