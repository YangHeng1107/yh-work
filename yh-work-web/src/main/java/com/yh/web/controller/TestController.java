package com.yh.web.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.yh.biz.TestService;
import com.yh.common.bo.CourseEntity;
import com.yh.common.bo.StudentEntity;
import com.yh.common.bo.TeacherEntity;
import com.yh.common.response.PlainResult;
import com.yh.common.util.FileUtil;
import com.yh.dal.entity.mysql.UserInfoPo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yangheng
 * @create 2019/9/17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/private/test")
public class TestController {

    @Resource
    private HttpServletResponse response;
    @Resource
    private TestService testService;

    @GetMapping("/test")
    public PlainResult test() {

        List<UserInfoPo> test = testService.test();
        return new PlainResult<>(test);
    }

    @GetMapping("/down")
    public void down() {
        List<StudentEntity> list = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setBirthday(new Date());
        studentEntity.setName("张三");
        studentEntity.setRegistrationDate(new Date());
        studentEntity.setSex(1);
        StudentEntity studentEntity1 = new StudentEntity();
        studentEntity1.setBirthday(new Date());
        studentEntity1.setName("李四");
        studentEntity1.setRegistrationDate(new Date());
        studentEntity1.setSex(2);
        list.add(studentEntity);
        list.add(studentEntity1);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                CourseEntity.class, list);
        FileUtil.downExcel(workbook, "测试", response);

    }

    @GetMapping("/down1")
    public void down1() {
        List<StudentEntity> studentList = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setBirthday(new Date());
        studentEntity.setName("张三");
        studentEntity.setRegistrationDate(new Date());
        studentEntity.setSex(1);
        StudentEntity studentEntity1 = new StudentEntity();
        studentEntity1.setBirthday(new Date());
        studentEntity1.setName("李四");
        studentEntity1.setRegistrationDate(new Date());
        studentEntity1.setSex(2);
        studentList.add(studentEntity);
        studentList.add(studentEntity1);
        List<CourseEntity> list = new ArrayList<>();
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setStudents(studentList);
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName("老师一");
        courseEntity.setMathTeacher(teacherEntity);
        courseEntity.setName("语文");
        list.add(courseEntity);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                CourseEntity.class, list);
        FileUtil.downExcel(workbook, "测试", response);
    }

}