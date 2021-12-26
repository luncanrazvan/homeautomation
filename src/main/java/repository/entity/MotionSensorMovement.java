package repository.entity;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class MotionSensorMovement extends BaseEntity<Integer>{

    private Long movementDate;

}
