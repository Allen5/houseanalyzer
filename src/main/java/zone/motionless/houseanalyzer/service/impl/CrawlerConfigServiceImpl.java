package zone.motionless.houseanalyzer.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import zone.motionless.houseanalyzer.model.CrawlerConfig;
import zone.motionless.houseanalyzer.mapper.CrawlerConfigMapper;
import zone.motionless.houseanalyzer.service.ICrawlerConfigService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author Allen.Wu
 * @since 2021-10-11
 */
@Slf4j
@Service
public class CrawlerConfigServiceImpl extends ServiceImpl<CrawlerConfigMapper, CrawlerConfig> implements ICrawlerConfigService {

    @Autowired
    private CrawlerConfigMapper crawlerConfigMapper;

    @Override
    public boolean saveBatch(Collection<CrawlerConfig> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<CrawlerConfig> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<CrawlerConfig> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(CrawlerConfig entity) {
        return false;
    }

    @Override
    public CrawlerConfig getOne(Wrapper<CrawlerConfig> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<CrawlerConfig> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<CrawlerConfig> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public Class<CrawlerConfig> getEntityClass() {
        return null;
    }

    @Override
    public List<Cookie> getCookies(String domain) {
        // 根据站点名称获取对象
        LambdaQueryWrapper<CrawlerConfig> lq = Wrappers.lambdaQuery(CrawlerConfig.class);
        CrawlerConfig config = crawlerConfigMapper.selectOne(lq.eq(CrawlerConfig::getDomain, domain));
        if ( null == config ) {
            log.error("no config exists for domain: {}", domain);
            return null;
        }
        // 解析cookie对象
        List<Cookie> cookies = new ArrayList<>();
        String[] cookieItems = config.getCookie().split(";");
        for (String cookieItem: cookieItems) {
            String[] items = cookieItem.split("=");
            if ( items.length != 2 ) {
                log.error("not valid cookie item: {}" ,cookieItem);
                continue;
            }
            cookies.add(new Cookie(items[0], items[1]));
        }
        return cookies;
    }
}
