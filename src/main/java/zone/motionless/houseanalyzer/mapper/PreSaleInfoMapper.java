package zone.motionless.houseanalyzer.mapper;

import zone.motionless.houseanalyzer.model.PreSaleInfo;

public interface PreSaleInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pre_sale_info
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pre_sale_info
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int insert(PreSaleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pre_sale_info
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int insertSelective(PreSaleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pre_sale_info
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    PreSaleInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pre_sale_info
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int updateByPrimaryKeySelective(PreSaleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pre_sale_info
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int updateByPrimaryKey(PreSaleInfo record);
}