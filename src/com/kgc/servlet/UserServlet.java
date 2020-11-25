package com.kgc.servlet;

import com.kgc.pojo.User;
import com.kgc.service.user.UserService;
import com.kgc.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        if ("register".equals(method)){
            try {
                this.doRegister(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("login".equals(method)){
            try {
                this.doLogin(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }if ("doRename".equals(method)){
            try {
                this.doRename(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("logout".equals(method)){
            try {
                this.doLogout(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user_reg = new User();
        user_reg.setId(request.getParameter("userName"));
        user_reg.setUserName(request.getParameter("userName"));
        user_reg.setPassword(request.getParameter("passWord"));
        user_reg.setSex(request.getParameter("sex"));
        user_reg.setBirthday(null);
        user_reg.setIdentityCode(request.getParameter("ID_Card"));
        user_reg.setEmail(request.getParameter("email"));
        user_reg.setAddress(request.getParameter("address"));
        user_reg.setStatus(2);

        System.out.println(request.getParameter("userName"));
        System.out.println(request.getParameter("passWord"));


        int isRegister = userService.add(user_reg);
        if (isRegister>0){
            response.sendRedirect("EasyBuy/reg-result.jsp");
        }
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String loginUserName = request.getParameter("userName");
        String password = request.getParameter("passWord");

        List<User> userList = userService.getUserList();
        PrintWriter out = response.getWriter();
        boolean flag = false;//普通用户
        boolean flag1 = false;//管理员
        if ("管理员".equals(loginUserName) && "admin".equals(password)){
            flag1 = true;
        }
        for (User u:userList) {
            if (loginUserName.equals(u.getUserName()) && password.equals(u.getPassword())){
                flag = true;
                break;
            }else {
                flag = false;
            }
        }
        if (flag1){
            request.getSession().setAttribute("admin","管理员");
            response.sendRedirect("Manage/login-result.jsp");
        }else if(flag){
            request.getSession().setAttribute("loginUser",loginUserName);
            response.sendRedirect("EasyBuy/login-result.jsp");
        }
        else {
            out.print("<script>");
            out.print("alert('登陆失败！')");
            out.print("</script>");
        }
        out.flush();
        out.close();
    }

    protected void doFindAllUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = userService.getUserList();
        //request.getSession().setAttribute("userList",userList);
    }

    //验证用户名是否重复
    protected void doRename(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = userService.getUserList();
        String userName = request.getParameter("name");
        PrintWriter out = response.getWriter();
        String json = "{\"flag\" : \"true\"}";
        for (User u:userList) {
            if (userName.equals(u.getUserName())){
                json = "{\"flag\" : \"false\"}";
                break;
            }
        }
        out.print(json);
        out.flush();
        out.close();
    }

    //注销
    protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect("EasyBuy/index.jsp");
    }


}
