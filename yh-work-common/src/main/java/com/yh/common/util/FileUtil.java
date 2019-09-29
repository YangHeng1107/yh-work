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
package com.yh.common.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.yh.common.bo.StudentEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/29
 * @since 1.0.0
 */
@Slf4j
public class FileUtil {

    public void downExcel(Workbook workbook, String fileName, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + "xls", "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("导出Excel失败: {}", e.getMessage());

        }
    }


    private FileUtil() {
    }
}