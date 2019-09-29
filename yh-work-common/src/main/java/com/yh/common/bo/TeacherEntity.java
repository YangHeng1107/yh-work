/**
 * *****************************************************
 * Copyright (C) 2019 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 * <p>
 * History:
 * <author>            <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号            描述
 */
package com.yh.common.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/28
 * @since 1.0.0
 */
@Data
@ExcelTarget("teacherEntity")
public class TeacherEntity {
    /**
     * name
     */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent", needMerge = true)
    private String name;
}