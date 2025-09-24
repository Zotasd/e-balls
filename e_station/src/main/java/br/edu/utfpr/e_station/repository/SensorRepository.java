package br.edu.utfpr.e_station.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.e_station.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, UUID> {
    Page<Sensor> findById(UUID sensorId, Pageable pageable);

    Page<Sensor> findBySensorType(Sensor.SensorType sensorType, Pageable pageable);
}
