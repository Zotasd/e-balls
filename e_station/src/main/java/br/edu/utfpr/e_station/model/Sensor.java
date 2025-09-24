package br.edu.utfpr.e_station.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_sensors")
@Data
public class Sensor extends BaseEntity {

    public enum SensorType {
        Temperature,
        Humidity,
        Pressure,
        Precipitation
    }

    @Column(name = "model", length = 200, nullable = false)
    private String model;

    @Column(name = "sensorType", length = 200, nullable = false)
    private SensorType sensorType;

    @ManyToOne
    private Device device;

    public void setSensorType(int i)
    {
        try
        {
            switch(i)
            {
                case 0:
                    sensorType = sensorType.Temperature;
                    break;
                case 1:
                    sensorType = sensorType.Humidity;
                    break;
                case 2:
                    sensorType = sensorType.Pressure;
                    break;
                case 3:
                    sensorType = sensorType.Precipitation; 
                    break;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
