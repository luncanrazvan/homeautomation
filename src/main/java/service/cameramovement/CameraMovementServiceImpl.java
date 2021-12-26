package service.cameramovement;

import org.springframework.stereotype.Service;
import repository.entity.CameraMovement;
import service.base.BaseServiceImpl;

@Service("cameraMovement")
public class CameraMovementServiceImpl extends BaseServiceImpl<CameraMovement, Integer> implements CameraMovementService {
}
