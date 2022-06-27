package mx.edu.iebem.api2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.iebem.api2.models.Promedios;
import mx.edu.iebem.api2.services.Promedios_services;

@RestController
@RequestMapping("/Promedios")
public class Promedios_controller {

@Autowired private Promedios_services service;
@GetMapping
public List<Promedios> getPromedios(){
    return service.ListPromedios();
}
    
}
