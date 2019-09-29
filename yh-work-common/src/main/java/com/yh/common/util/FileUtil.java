package com.yh.common.util;

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

    public static void downExcel(Workbook workbook, String fileName, HttpServletResponse response) {
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