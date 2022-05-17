package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_employee_ec")
@ApiModel(value="EmployeeEc对象", description="")
public class EmployeeEc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "奖罚日期")
    @TableField("ecDate")
    private LocalDate ecdate;

    @ApiModelProperty(value = "奖罚原因")
    @TableField("ecReason")
    private String ecreason;

    @ApiModelProperty(value = "奖罚分")
    @TableField("ecPoint")
    private Integer ecpoint;

    @ApiModelProperty(value = "奖罚类别，0：奖，1：罚")
    @TableField("ecType")
    private Integer ectype;

    @ApiModelProperty(value = "备注")
    private String remark;


}
