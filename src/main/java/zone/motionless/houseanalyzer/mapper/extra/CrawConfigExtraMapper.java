package zone.motionless.houseanalyzer.mapper.extra;

import zone.motionless.houseanalyzer.mapper.CrawlerConfigMapper;

/**
 * 自定义实现的方法在这里编写
 */
public interface CrawConfigExtraMapper extends CrawlerConfigMapper {

    /**
     * 根据domain获取记录
     * @param domain domain 全局唯一
     * @return String cookie记录
     */
    String selectOneByDomain(final String domain);

}
