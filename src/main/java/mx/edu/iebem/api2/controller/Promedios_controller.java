package mx.edu.iebem.api2.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.iebem.api2.models.Promedios;
import mx.edu.iebem.api2.models.leerXML;
import mx.edu.iebem.api2.services.Promedios_services;

@RestController
@RequestMapping("/Promedios")
public class Promedios_controller {

@Autowired private Promedios_services service;
@GetMapping
public List<Promedios> getPromedios(){
    return service.ListPromedios();
}

@PostMapping("/Guardar")

public Promedios getGuardar(@RequestBody Promedios datos){
      System.out.println(" IMPRESION " + datos.getPROMEDIO_NIVEL());
    return service.guardar(datos);
    
}
@PostMapping("/GuardarXML")
public void getGuardarXML (@RequestParam("file") MultipartFile multipart) throws IOException{
    System.out.println("archivo"+multipart);
      service.guardarXML(multipart);
    
}  
@GetMapping("/{curp}")
public leerXML getId(String curp){
    return service.getIdAlumno(curp);
}
    
}
