package com.gabrego.citasapi.controller;

import com.gabrego.citasapi.entity.Day;
import com.gabrego.citasapi.service.DayService;
import com.gabrego.citasapi.service.DayService;
import com.gabrego.citasapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/appointment/day") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/usersapi/
public class DayRestController {

    @Autowired
    private DayService dayService;

    @GetMapping("/")
    public List<Day> findAll() {
        return dayService.findAll();
    }

    @GetMapping("/{dayId}")
    public Day getDayById(@PathVariable int dayId){
        Day day = dayService.findById(dayId);

        if(day == null) {
            new Day();
        }
        //retornará al usuario con id pasado en la url
        return day;
    }


    @PostMapping("/")
    public Day addDay(@RequestBody Day day) {
        day.setId(0);

        //Este metodo guardará al usuario enviado
        dayService.save(day);

        return day;

    }

    @PutMapping("/")
    public Day updateDay(@RequestBody Day clinic) {

        dayService.save(clinic);

        //este metodo actualizará al usuario enviado

        return clinic;
    }

    @DeleteMapping("/{dayId}")
    public int deleteAppointment(@PathVariable int dayId) {

        Day clinic = dayService.findById(dayId);

        if(clinic == null) {
            return 0;
        }

        return dayService.deleteById(dayId);
    }

    
}
