package zone.motionless.houseanalyzer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoordinateServiceImplTest {

    @Autowired
    private CoordinateService coordinateService;

    @Test
    void refreshSingleLouPan() {
    }

    @Test
    void refreshAllLouPan() {
        // for test
        // coordinateService.refreshAllLouPan(1, 100);
    }
}