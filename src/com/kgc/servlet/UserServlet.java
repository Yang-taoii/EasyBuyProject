package com.kgc.servlet;

import com.kgc.pojo.Page;
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
import java.util.Date;
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


        //后端代码
        //展示所有用户信息
        if("showAllUserInfo".equals(method)){
            try {
                this.doFindAllUser(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //删除用户
        if ("del".equals(method)){
            try {
                this.doDeleteUserInfo(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //新增用户
        if("insert".equals(method)){
            try {
                this.doInsertUserInfo(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //修改用户
        if("update".equals(method)){
            try {
                this.doModifyUserInfo(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ("getUser".equals(method)){
            try {
                this.doGetUserInfo(request,response);
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


    //后端用户管理
    //
    // 点击修改时  获取用户信息
    protected void doGetUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User user_now = userService.selectUserByName(request.getParameter("user_name"));
        request.getSession().setAttribute("user_modify",user_now);
        response.sendRedirect("Manage/user-modify.jsp");
    }
    // 1.展示所有用户信息
    protected void doFindAllUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Page page = new Page();
        page.setPageSize(4);//每页展示4条数据
        String pageIndex=request.getParameter("pageIndex");//当前页码
        if (pageIndex == null || Integer.parseInt(pageIndex) < 1){
            page.setPageIndex(1);
        }else {
            page.setPageIndex(Integer.parseInt(pageIndex));
        }
        Page page1 = userService.fenYe(page);
        request.getSession().setAttribute("page",page1);
        response.sendRedirect("Manage/user.jsp");
    }

    // 2.修改用户信息
    protected void doModifyUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String user_name = request.getParameter("userName");
        String user_password = request.getParameter("passWord");
        String user_sex = request.getParameter("sex");
        String user_address = request.getParameter("address");
        String user_identityCode = request.getParameter("identityCode");
        String user_email = request.getParameter("email");
        String user_mobile = request.getParameter("mobile");
        User user = new User();
        user.setUserName(user_name);
        user.setPassword(user_password);
        user.setAddress(user_address);
        user.setSex(user_sex);
        Date date = new Date();
        user.setId(user_name+date.getTime());
        user.setIdentityCode(user_identityCode);
        user.setMobile(user_mobile);
        user.setEmail(user_email);

        int isUpdate = userService.updateUserInfo(user);
        if (isUpdate>0){
            System.out.println("11111111");
            response.sendRedirect("Manage/manage-result.jsp");
        }else {
            response.sendRedirect("Manage/user-modify.jsp");
        }
    }

    // 2.删除用户信息
    protected void doDeleteUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("user_name");
        int isDelete  = userService.deleteUserInfo(name);
        if (isDelete>0){
           this.doFindAllUser(request,response);
        }else {
            this.doFindAllUser(request,response);
        }
    }

    // 3.新增用户信息
    protected void doInsertUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String user_name = request.getParameter("userName");
        String user_password = request.getParameter("passWord");
        String user_sex = request.getParameter("sex");
        int user_status = 1; //普通用户
        String user_address = request.getParameter("address");
        User user = new User();
        user.setUserName(user_name);
        user.setSex(user_sex);
        user.setAddress(user_address);
        user.setStatus(user_status);
        user.setPassword(user_password);

        int isInsert = userService.insertUserInfo(user);
        if (isInsert>0){
            response.sendRedirect("Manage/manage-result.jsp");
        }else {
            response.sendRedirect("Manage/user-add.jsp");
        }

    }

}
