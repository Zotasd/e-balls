package br.edu.utfpr.e_station.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.utfpr.e_station.dto.DeviceDTO;
import br.edu.utfpr.e_station.model.Device;
import br.edu.utfpr.e_station.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepo;

    public Page<Device> getAll(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return deviceRepo.findAll(pageable);
    }

    public Device getById(UUID id)
    {
        var existingDevice = deviceRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));;

        Device device = new Device();
        BeanUtils.copyProperties(existingDevice, device);
        return device;
    }

    public Device create(DeviceDTO dto)
    {
        Device device = new Device();
        BeanUtils.copyProperties(dto, device);

        return deviceRepo.save(device);  
    }

    public Device update(UUID id, DeviceDTO dto)
    {
        var existingDevice = deviceRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));;
        Device device = new Device();

        BeanUtils.copyProperties(existingDevice, device);
        BeanUtils.copyProperties(dto, device);
        device.setUpdateDate(LocalDateTime.now());

        return deviceRepo.save(device);
    }

    public ResponseEntity<String> delete(UUID id)
    {
        if(deviceRepo.existsById(id))
        {
            deviceRepo.deleteById(id);
            return ResponseEntity.ok("Dispositivo "+id+" deletado com sucesso");
        }
        else
        {
            return ResponseEntity.ok("Dispositivo "+id+" não encontrado");
        }
    }

}
