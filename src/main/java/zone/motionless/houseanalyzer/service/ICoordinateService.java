package zone.motionless.houseanalyzer.service;

import zone.motionless.houseanalyzer.model.Loupan;

/**
 * 坐标服务
 */
public interface ICoordinateService {

    /**
     * 更新单个楼盘坐标
     * @param loupan
     */
    void refreshSingleLouPan(final Loupan loupan);

    /**
     * 更新所有楼盘坐标信息
     */
    void refreshAllLouPan(int page, final int count);

}
