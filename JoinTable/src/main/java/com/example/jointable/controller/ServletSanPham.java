package com.example.jointable.controller;

import com.example.jointable.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletSanPham",
        value =
                {
                        "/san-pham/hien-thi",
                        "/san-pham/add",
                        "/san-pham/remove",
                        "/san-pham/update",
                        "/san-pham/detail",

                })
public class ServletSanPham extends HttpServlet {
    private SanPhamRepository repository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/hien-thi")){
            request.setAttribute("listProduct", repository.getAll());
            request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
