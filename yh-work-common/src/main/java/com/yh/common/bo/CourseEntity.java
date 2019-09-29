
package com.yh.common.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/28
 * @since 1.0.0
 */
@Data
@ExcelTarget("courseEntity")
public class CourseEntity implements Serializable {

    /**
     * 课程名称
     */
    @Excel(name = "课程名称", orderNum = "1", width = 25, needMerge = true)
    private String name;
    /**
     * 老师主键
     */
    @ExcelEntity(id = "absent")
    private TeacherEntity mathTeacher;

    @ExcelCollection(name = "", orderNum = "4")
    private List<StudentEntity> students;
}