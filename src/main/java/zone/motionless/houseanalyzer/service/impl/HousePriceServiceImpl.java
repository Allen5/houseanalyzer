package zone.motionless.houseanalyzer.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import zone.motionless.houseanalyzer.model.HousePrice;
import zone.motionless.houseanalyzer.mapper.HousePriceMapper;
import zone.motionless.houseanalyzer.service.IHousePriceService;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
@Service
public class HousePriceServiceImpl extends ServiceImpl<HousePriceMapper, HousePrice> implements IHousePriceService {

    @Override
    public boolean saveBatch(Collection<HousePrice> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<HousePrice> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<HousePrice> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(HousePrice entity) {
        return false;
    }

    @Override
    public HousePrice getOne(Wrapper<HousePrice> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<HousePrice> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<HousePrice> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public Class<HousePrice> getEntityClass() {
        return null;
    }
}
