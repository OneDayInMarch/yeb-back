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
@TableName("t_salary_adjust")
@ApiModel(value="SalaryAdjust对象", description="")
public class SalaryAdjust implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工ID")
    private Integer eid;

    @ApiModelProperty(value = "调薪日期")
    @TableField("asDate")
    private LocalDate asdate;

    @ApiModelProperty(value = "调前薪资")
    @TableField("beforeSalary")
    private Integer beforesalary;

    @ApiModelProperty(value = "调后薪资")
    @TableField("afterSalary")
    private Integer aftersalary;

    @ApiModelProperty(value = "调薪原因")
    private String reason;

    @ApiModelProperty(value = "备注")
    private String remark;


}
