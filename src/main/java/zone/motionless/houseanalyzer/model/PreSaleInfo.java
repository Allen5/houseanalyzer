package zone.motionless.houseanalyzer.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("pre_sale_info")
public class PreSaleInfo extends Model<PreSaleInfo> {

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
	 * 楼盘名称
	 */
	private String name;

	/**
	 * 预售许可证
	 */
	private String licence;

	/**
	 * 一房一价链接
	 */
	@TableField(value="house_price_link")
	private String housePriceLink;

	/**
	 * 本次预售总套数
	 */
	private Integer count;

	/**
	 * 本次预售剩余套数
	 */
	@TableField(value="left_count")
	private Integer leftCount;

	/**
	 * 开发商信息
	 */
	@TableField(value="developer_company")
	private String developerCompany;

	/**
	 * 开盘日期
	 */
	@TableField(value="open_date")
	private Date openDate;

	/**
	 * 销售楼盘类型
	 */
	private String type;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 销售地址
	 */
	@TableField(value="sale_address")
	private String saleAddress;

	/**
	 * 经度
	 */
	private BigDecimal latitude;

	/**
	 * 维度
	 */
	private BigDecimal longitude;

	/**
	 * 平均价
	 */
	@TableField(value="avg_price")
	private Integer avgPrice;

	/**
	 * 最低价
	 */
	@TableField(value="min_price")
	private Integer minPrice;

	/**
	 * 最高价
	 */
	@TableField(value="max_price")
	private Integer maxPrice;

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

	/**
	 * 状态码 0正常 1已售完
	 */
	private Integer status;



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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getHousePriceLink() {
		return housePriceLink;
	}

	public void setHousePriceLink(String housePriceLink) {
		this.housePriceLink = housePriceLink;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(Integer leftCount) {
		this.leftCount = leftCount;
	}

	public String getDeveloperCompany() {
		return developerCompany;
	}

	public void setDeveloperCompany(String developerCompany) {
		this.developerCompany = developerCompany;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSaleAddress() {
		return saleAddress;
	}

	public void setSaleAddress(String saleAddress) {
		this.saleAddress = saleAddress;
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

	public Integer getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Integer avgPrice) {
		this.avgPrice = avgPrice;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
