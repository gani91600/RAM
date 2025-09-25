package com.example.student.servlet;

import com.example.student.dao.StudentDao;
import com.example.student.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {
    private StudentDao studentDao;

    @Override
    public void init() {
        studentDao = new StudentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = studentDao.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("view-students.jsp").forward(request, response);
    }
}
