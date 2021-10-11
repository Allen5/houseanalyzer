package zone.motionless.houseanalyzer.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allen.Wu
 * @since 2021-10-11
 */
@TableName("house_price")
public class HousePrice extends Model<HousePrice> {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 楼盘id
	 */
	@TableField(value="loupan_id")
	private Long loupanId;

	/**
	 * 预售信息id
	 */
	@TableField(value="pre_sale_id")
	private Long preSaleId;

	/**
	 * 幢
	 */
	@TableField(value="building_number")
	private Integer buildingNumber;

	/**
	 * 单元
	 */
	@TableField(value="unit_number")
	private Integer unitNumber;

	/**
	 * 楼层
	 */
	@TableField(value="floor_number")
	private Integer floorNumber;

	/**
	 * 门牌号
	 */
	@TableField(value="door_number")
	private String doorNumber;

	/**
	 * 挂牌价
	 */
	@TableField(value="sale_price")
	private Integer salePrice;

	/**
	 * 成交价
	 */
	@TableField(value="deal_price")
	private Integer dealPrice;

	/**
	 * 状态 0销售中 1已成交
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	@TableField(value="created_at")
	private Date createdAt;

	/**
	 * 更新时间
	 */
	@TableField(value="updated_at")
	private Date updatedAt;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoupanId() {
		return loupanId;
	}

	public void setLoupanId(Long loupanId) {
		this.loupanId = loupanId;
	}

	public Long getPreSaleId() {
		return preSaleId;
	}

	public void setPreSaleId(Long preSaleId) {
		this.preSaleId = preSaleId;
	}

	public Integer getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(Integer buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public Integer getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(Integer unitNumber) {
		this.unitNumber = unitNumber;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public Integer getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(Integer dealPrice) {
		this.dealPrice = dealPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
