package br.edu.utfpr.e_station.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.e_station.model.Device;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
    Page<Device> findById(UUID deviceId, Pageable pageable);

}
