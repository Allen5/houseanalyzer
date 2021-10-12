package zone.motionless.houseanalyzer.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allen.Wu
 * @since 2021-10-11
 */
@TableName("crawler_config")
public class CrawlerConfig extends Model<CrawlerConfig> {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 站点域名
	 */
	private String domain;

	/**
	 * cookie信息
	 */
	private String cookie;

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
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
