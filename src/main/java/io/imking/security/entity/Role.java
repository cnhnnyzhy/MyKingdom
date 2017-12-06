package io.imking.security.entity;

import java.util.Date;

/**
 * 角色实体类
 * @author yang.zhang3
 * @create 2017/11/16
 */
public class Role implements java.io.Serializable {
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 角色类型
     */
    private Integer type;
    /**
     * 角色状态
     */
    private Integer state;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
