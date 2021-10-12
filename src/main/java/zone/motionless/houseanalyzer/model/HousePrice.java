package zone.motionless.houseanalyzer.model;

import java.io.Serializable;
import java.util.Date;

public class HousePrice implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.loupan_id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Long loupanId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.pre_sale_id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Long preSaleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.building_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Integer buildingNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.unit_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Integer unitNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.floor_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Integer floorNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.door_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private String doorNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.sale_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Integer salePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.deal_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Integer dealPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.status
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.created_at
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_price.updated_at
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private Date updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table house_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.id
     *
     * @return the value of house_price.id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.id
     *
     * @param id the value for house_price.id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.loupan_id
     *
     * @return the value of house_price.loupan_id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Long getLoupanId() {
        return loupanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.loupan_id
     *
     * @param loupanId the value for house_price.loupan_id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setLoupanId(Long loupanId) {
        this.loupanId = loupanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.pre_sale_id
     *
     * @return the value of house_price.pre_sale_id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Long getPreSaleId() {
        return preSaleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.pre_sale_id
     *
     * @param preSaleId the value for house_price.pre_sale_id
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setPreSaleId(Long preSaleId) {
        this.preSaleId = preSaleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.building_number
     *
     * @return the value of house_price.building_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.building_number
     *
     * @param buildingNumber the value for house_price.building_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.unit_number
     *
     * @return the value of house_price.unit_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Integer getUnitNumber() {
        return unitNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.unit_number
     *
     * @param unitNumber the value for house_price.unit_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.floor_number
     *
     * @return the value of house_price.floor_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Integer getFloorNumber() {
        return floorNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.floor_number
     *
     * @param floorNumber the value for house_price.floor_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.door_number
     *
     * @return the value of house_price.door_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public String getDoorNumber() {
        return doorNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.door_number
     *
     * @param doorNumber the value for house_price.door_number
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.sale_price
     *
     * @return the value of house_price.sale_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Integer getSalePrice() {
        return salePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.sale_price
     *
     * @param salePrice the value for house_price.sale_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.deal_price
     *
     * @return the value of house_price.deal_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Integer getDealPrice() {
        return dealPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.deal_price
     *
     * @param dealPrice the value for house_price.deal_price
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setDealPrice(Integer dealPrice) {
        this.dealPrice = dealPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.status
     *
     * @return the value of house_price.status
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.status
     *
     * @param status the value for house_price.status
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.created_at
     *
     * @return the value of house_price.created_at
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.created_at
     *
     * @param createdAt the value for house_price.created_at
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_price.updated_at
     *
     * @return the value of house_price.updated_at
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_price.updated_at
     *
     * @param updatedAt the value for house_price.updated_at
     *
     * @mbg.generated Tue Oct 12 15:15:06 CST 2021
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}