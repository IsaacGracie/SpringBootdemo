package com.example.demo.converter;

import com.example.demo.dao.Student;
import com.example.demo.dto.StudentDTO;

// 转换器：
// 隔离实体与传输数据：
//Student是数据库实体类（Entity），与数据库表结构强绑定（字段通常与表字段一一对应），可能包含内部业务逻辑或敏感信息（如密码、权限标识），不适合直接暴露给前端。
//StudentDTO是数据传输对象（DTO），仅包含前端需要展示/使用的字段（如id/name/email），避免敏感信息泄露，同时简化传输数据结构（减少网络传输量）。
public class StudentConverter {

    public static StudentDTO convertStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        // 字段映射——将Student实体对象的指定字段值，复制到StudentDTO对象的对应字段中。
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());

        return studentDTO;
    }

    public static Student convertStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }
}
