package zone.motionless.houseanalyzer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
		"zone.motionless.houseanalyzer.mapper",
})
public class HouseAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseAnalyzerApplication.class, args);
	}

}
