package zone.motionless.houseanalyzer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    void refreshSingleLouPan() {
    }

    @Test
    void refreshAllLouPan() {
         locationService.refreshLouPanGeo(1, 100);
    }
}