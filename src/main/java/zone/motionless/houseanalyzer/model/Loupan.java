package zone.motionless.houseanalyzer.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allen.Wu
 * @since 2021-10-11
 */
public class Loupan extends Model<Loupan> {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 楼盘名称信息
	 */
	private String name;

	/**
	 * 物业类型
	 */
	private String type;

	/**
	 * 剩余可售套数
	 */
	@TableField(value="left_count")
	private Integer leftCount;

	/**
	 * 总套数
	 */
	private Integer count;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 最新备案均价
	 */
	@TableField(value="current_sale_price")
	private Integer currentSalePrice;

	/**
	 * 销售电话
	 */
	private String telephone;

	/**
	 * 状态 0正常 其余状态码待补充
	 */
	private Integer status;

	/**
	 * 
	 */
	private BigDecimal latitude;

	/**
	 * 
	 */
	private BigDecimal longitude;

	private String province;

	private String city;

	private String district;

	/**
	 * 区域编码
	 */
	@TableField(value = "district_code")
	private String districtCode;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(Integer leftCount) {
		this.leftCount = leftCount;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCurrentSalePrice() {
		return currentSalePrice;
	}

	public void setCurrentSalePrice(Integer currentSalePrice) {
		this.currentSalePrice = currentSalePrice;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
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
