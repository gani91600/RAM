package com.example.student.servlet;

import com.example.student.dao.StudentDao;
import com.example.student.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    private StudentDao studentDao;

    @Override
    public void init() {
        studentDao = new StudentDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        studentDao.addStudent(student);

        response.sendRedirect("view-students.jsp");
    }
}
