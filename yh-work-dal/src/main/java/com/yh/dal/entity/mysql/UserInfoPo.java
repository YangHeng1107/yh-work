package com.yh.dal.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author v-yangheng.ea
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
public class UserInfoPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String userName;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;


}
