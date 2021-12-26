package repository.repositories;

import org.springframework.stereotype.Repository;
import repository.entity.MotionSensorMovement;

@Repository
public interface MotionSensorMovementRepository extends BaseRepository<MotionSensorMovement, Integer> {
}
