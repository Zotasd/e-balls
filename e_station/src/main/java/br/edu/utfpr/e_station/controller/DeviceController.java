package br.edu.utfpr.e_station.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.e_station.dto.DeviceDTO;
import br.edu.utfpr.e_station.model.Device;
import br.edu.utfpr.e_station.service.DeviceService;




@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("getAll")
    public Page<Device> getAll() 
    {
        return deviceService.getAll(0, 10);
    }
    
    @GetMapping("getById/{id}")
    public Device getById(@PathVariable UUID id) 
    {
        return deviceService.getById(id);
    }

    @PostMapping("create")
    public Device create(@RequestBody DeviceDTO dto)
    {
        return deviceService.create(dto);
    }

    @PutMapping("update/{id}")
    public Device update(@PathVariable UUID id, @RequestBody DeviceDTO dto) 
    {
        return deviceService.update(id, dto);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) 
    {
        return deviceService.delete(id);
    }
    
    

    

}
