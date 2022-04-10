package by.mitskevich.station.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars", schema = "car_service_station")
public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = -3884445871217214134L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String vin;
    private String brand;
    private String model;

}
