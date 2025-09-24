package br.edu.utfpr.e_station.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.utfpr.e_station.dto.SensorDTO;
import br.edu.utfpr.e_station.model.Sensor;
import br.edu.utfpr.e_station.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepo;

    public List<Sensor> getAll()
    {
        return sensorRepo.findAll();
    }

    public Sensor getById(UUID id)
    {
        var existingSensor = sensorRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Sensor "+id+ " não encontrado"));

        Sensor sensor = new Sensor();
        BeanUtils.copyProperties(existingSensor, sensor);
        return sensor;
    }

    public Sensor create(SensorDTO dto)
    {
        Sensor sensor = new Sensor();
        BeanUtils.copyProperties(dto, sensor);
        sensor.setSensorType(dto.sensorType());
        return sensorRepo.save(sensor);
    }

    public Sensor update(UUID id, SensorDTO dto)
    {
        Sensor sensor = new Sensor();
        var existingSensor = sensorRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Sensor "+id+ " não encontrado"));

        BeanUtils.copyProperties(existingSensor, sensor);
        BeanUtils.copyProperties(dto, sensor);
        sensor.setUpdateDate(LocalDateTime.now());

        return sensorRepo.save(sensor);
    }

    public ResponseEntity<String> delete(UUID id)
    {
        if(sensorRepo.existsById(id))
        {
            sensorRepo.deleteById(id);
            return ResponseEntity.ok("Sensor "+id+" excluído com sucesso");
        }
        else
        {
            return ResponseEntity.ok("Sensor "+id+" não encontrado");
        }
    }


}
