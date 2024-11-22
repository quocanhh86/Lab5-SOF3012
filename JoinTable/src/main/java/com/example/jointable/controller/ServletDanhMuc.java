package com.example.jointable.controller;

import com.example.jointable.entity.DanhMuc;
import com.example.jointable.repository.DanhMucRepository;
import com.example.jointable.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "ServletDanhMuc",
        value = {
                "/danh-muc/hien-thi",
                "/danh-muc/detail",
                "/danh-muc/add",
                "/danh-muc/update",
        })
public class ServletDanhMuc extends HttpServlet {
    private DanhMucRepository danhMucRepository = new DanhMucRepository();
    private SanPhamRepository repository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/danh-muc/hien-thi")) {
            request.setAttribute("listCatagory", danhMucRepository.getAll());
            request.setAttribute("listProduct", repository.getAll());
            request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
        } else {
            Integer id = Integer.parseInt(request.getParameter("id"));
            DanhMuc dm = danhMucRepository.getOne(id);
            request.setAttribute("dm", dm);
            request.setAttribute("listCatagory", danhMucRepository.getAll());
            request.setAttribute("listProduct", repository.getAll());
            request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/danh-muc/add")) {
            String code = request.getParameter("maDanhMuc");
            String ten = request.getParameter("tenDanhMuc");
            String trangThai = request.getParameter("trangThai");
            String ngayTao = request.getParameter("ngayTao");
            String ngaySua = request.getParameter("ngaySua");
            String id = request.getParameter("id");
            boolean isValid = true;


            if (code == null || code.trim().isEmpty()) {
                request.setAttribute("message", "Bạn chưa nhập mã");
                isValid = false;
            }

            if (ten == null || ten.trim().isEmpty()) {
                request.setAttribute("message1", "Bạn chưa nhập tên");
                isValid = false;
            }

            if (trangThai == null || trangThai.trim().isEmpty()) {
                request.setAttribute("message2", "Bạn chưa nhập trạng thái");
                isValid = false;
            }
            if (ngayTao == null || ngayTao.trim().isEmpty()) {
                request.setAttribute("message3", "Bạn chưa chọn ngày tạo");
                isValid = false;
            }
            if (ngaySua == null || ngaySua.trim().isEmpty()) {
                request.setAttribute("message4", "Bạn chưa chọn ngày sửa");
                isValid = false;
            }
            if (id == null || id.isEmpty()) {
                request.setAttribute("message5", "Bạn chưa nhập id");
                isValid = false;
            }
            if (!isValid) {
                request.setAttribute("listCatagory", danhMucRepository.getAll());
                request.setAttribute("listProduct", repository.getAll());
                request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
            } else {
                try {
                    DanhMuc dm = new DanhMuc();
                    BeanUtils.populate(dm, request.getParameterMap());
                    danhMucRepository.add(dm);
                    response.sendRedirect("/danh-muc/hien-thi");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi thêm mới.");
                }
            }
        } else {
            String code = request.getParameter("maDanhMuc");
            String ten = request.getParameter("tenDanhMuc");
            String trangThai = request.getParameter("trangThai");
            String ngayTao = request.getParameter("ngayTao");
            String ngaySua = request.getParameter("ngaySua");
            String id = request.getParameter("id");
            boolean isValid = true;


            if (code == null || code.trim().isEmpty()) {
                request.setAttribute("message", "Bạn chưa nhập mã");
                isValid = false;
            }

            if (ten == null || ten.trim().isEmpty()) {
                request.setAttribute("message1", "Bạn chưa nhập tên");
                isValid = false;
            }

            if (trangThai == null || trangThai.trim().isEmpty()) {
                request.setAttribute("message2", "Bạn chưa nhập sở thích");
                isValid = false;
            }
            if (ngayTao == null || ngayTao.trim().isEmpty()) {
                request.setAttribute("message3", "Bạn chưa chọn ngày tạo");
                isValid = false;
            }
            if (ngaySua == null || ngaySua.trim().isEmpty()) {
                request.setAttribute("message4", "Bạn chưa chọn ngày sửa");
                isValid = false;
            }
            if (id == null || id.isEmpty()) {
                request.setAttribute("message5", "Bạn chưa nhập id");
                isValid = false;
            }
            if (!isValid) {
                request.setAttribute("listCatagory", danhMucRepository.getAll());
                request.setAttribute("listProduct", repository.getAll());
                request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
            } else {
                try {
                    Integer ma = Integer.parseInt(request.getParameter("id"));
                    DanhMuc dm = danhMucRepository.getOne(ma);
                    BeanUtils.populate(dm, request.getParameterMap());
                    danhMucRepository.update(dm);
                    response.sendRedirect("/danh-muc/hien-thi");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi thêm mới.");
                }
            }
        }
    }
}
