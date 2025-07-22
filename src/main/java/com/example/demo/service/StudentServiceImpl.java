package com.example.demo.service;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dao.Student;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

// 当前 Service 方法的核心逻辑是：
//接收学生 ID → 调用 Repository 查询数据库获取实体 → 若查询不到则抛异常 → 若查询到则将实体转换为 DTO → 返回 DTO 给上层（如 Controller）

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired  //让 Spring 自动将 StudentRepository 的实例注入到当前 Service 类中，Service 层通过调用 Repository 的方法实现数据读写，无需关心数据库连接、SQL 执行等底层细节（符合“分层架构”：Controller → Service → Repository → 数据库）。
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studentList)) {
            throw new IllegalStateException("email:" + studentDTO.getEmail() + " already exists");
        }
        Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id){
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id + " not found"));
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudentById(long id, String name ,String email){
        Student studentInDB = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id + " not found"));

    if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
        studentInDB.setName(name);
    }

    if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
        studentInDB.setEmail(email);
    }
    Student student = studentRepository.save(studentInDB);
    return StudentConverter.convertStudent(student);
    }
}
