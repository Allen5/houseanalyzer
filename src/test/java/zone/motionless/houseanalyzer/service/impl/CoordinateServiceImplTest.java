package zone.motionless.houseanalyzer.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zone.motionless.houseanalyzer.service.ICoordinateService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoordinateServiceImplTest {

    @Autowired
    private ICoordinateService coordinateService;

    @Test
    void refreshSingleLouPan() {
    }

    @Test
    void refreshAllLouPan() {
        // for test
        coordinateService.refreshAllLouPan(1, 100);
    }
}