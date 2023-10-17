package org.example.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auth: w
 * @desc:
 * @date: 2023/10/16 19:09
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("测试用户实体")
public class TestUser {
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户年龄")
    private Integer age;

}
