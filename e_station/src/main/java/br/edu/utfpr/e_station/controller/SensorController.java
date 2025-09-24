package br.edu.utfpr.e_station.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.e_station.dto.SensorDTO;
import br.edu.utfpr.e_station.model.Sensor;
import br.edu.utfpr.e_station.service.SensorService;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("getAll")
    public List<Sensor> getAll() 
    {
        return sensorService.getAll();
    }

    @GetMapping("getById/{id}")
    public Sensor getById(@PathVariable UUID id) 
    {
        return sensorService.getById(id);
    }

    @PostMapping("create")
    public Sensor create(@RequestBody SensorDTO dto) 
    {
        return sensorService.create(dto);
    }

    @PutMapping("update/{id}")
    public Sensor update(@PathVariable UUID id, @RequestBody SensorDTO dto) 
    {
        return sensorService.update(id, dto);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) 
    {
        return sensorService.delete(id);
    }

}
