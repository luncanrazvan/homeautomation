package repository.repositories;

import org.springframework.stereotype.Repository;
import repository.entity.CameraMovement;

@Repository
public interface CameraMovementRepository extends BaseRepository<CameraMovement, Integer> {
}
