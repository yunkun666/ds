/**
 * @mbggenerated
 * @author kehui
 */
package cn.com.mapper.apdcn.pojo;

import java.io.Serializable;

public class DsSystemRole implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 747483886776133523L;

	/**
     * ds_system_role.id
     * 
     * VARCHAR(255)
     *
     * @mbggenerated
     */
    private String id;

    /**
     * ds_system_role.name
     * 
     * VARCHAR(255)
     *
     * @mbggenerated
     */
    private String name;

    /**
     * ds_system_role.detail
     * 
     * VARCHAR(500)
     *
     * @mbggenerated
     */
    private String detail;

    /**
     * ds_system_role.pid
     * 
     * VARCHAR(255)
     *
     * @mbggenerated
     */
    private String pid;

    /**
     * ds_system_role.level
     * 
     * VARCHAR(255)
     *
     * @mbggenerated
     */
    private String level;

    /* @mbggenerated */
    public String getId() {
        return id;
    }

    /* @mbggenerated */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /* @mbggenerated */
    public String getName() {
        return name;
    }

    /* @mbggenerated */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /* @mbggenerated */
    public String getDetail() {
        return detail;
    }

    /* @mbggenerated */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /* @mbggenerated */
    public String getPid() {
        return pid;
    }

    /* @mbggenerated */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /* @mbggenerated */
    public String getLevel() {
        return level;
    }

    /* @mbggenerated */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}