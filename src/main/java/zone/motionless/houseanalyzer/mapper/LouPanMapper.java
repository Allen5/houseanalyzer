package zone.motionless.houseanalyzer.mapper;

import zone.motionless.houseanalyzer.model.LouPan;

public interface LouPanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loupan
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loupan
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int insert(LouPan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loupan
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int insertSelective(LouPan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loupan
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    LouPan selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loupan
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int updateByPrimaryKeySelective(LouPan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loupan
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    int updateByPrimaryKey(LouPan record);
}