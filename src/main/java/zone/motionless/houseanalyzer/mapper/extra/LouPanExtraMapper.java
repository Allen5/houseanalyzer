package zone.motionless.houseanalyzer.mapper.extra;

import zone.motionless.houseanalyzer.mapper.LouPanMapper;
import zone.motionless.houseanalyzer.model.LouPan;

import java.util.List;

/**
 * 楼盘信息
 */
public interface LouPanExtraMapper extends LouPanMapper {

    /**
     * 获取存在有地址信息的楼盘记录
     * @param offset 偏移值
     * @param count  每次获取记录
     * @return
     */
    List<LouPan> fetchValidAddressItems(final int offset,
                                        final int count);

}
