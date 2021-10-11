package zone.motionless.houseanalyzer.service;

import org.openqa.selenium.Cookie;
import zone.motionless.houseanalyzer.model.CrawlerConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Allen.Wu
 * @since 2021-10-11
 */
public interface ICrawlerConfigService extends IService<CrawlerConfig> {

    /**
     * 根据站点名称获取cookie
     * @param domain 站点名称url. 全剧唯一
     * @return List<Cookie> 返回cookie对象
     */
    List<Cookie> getCookies(final String domain);
	
}
