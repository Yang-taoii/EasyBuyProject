package com.kgc.servlet;

import com.kgc.pojo.Product;

import com.kgc.service.product.ProductService;
import com.kgc.service.product.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    ProductService ps = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("showAllProduct".equals(method)){
            this.doShowAll(request,response);
        }
        if ("productDetail".equals(method)){
            this.doShowProductDetail(request,response);
        }

        if ("select_product".equals(method)){
            this.doSelectProduct(request,response);
        }

        if ("fileUpload".equals(method)){
            this.doFileUpload(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    //展示所有产品
    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String child_Name = request.getParameter("child_name");
        String father_Name = request.getParameter("father_name");
        //根据父类id查询子类所有商品
        //System.out.println(request.getParameter("epc_id"));
        int epc_id = Integer.parseInt(request.getParameter("epc_id"));
        List<Product> list_category = ps.findALlProductById(epc_id);
        request.getSession().setAttribute("list_category",list_category);
        request.getSession().setAttribute("child_Name",child_Name);
        request.getSession().setAttribute("father_Name",father_Name);
        response.sendRedirect("EasyBuy/product-list.jsp");
    }


    //展示商品详情
    protected void doShowProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ep_id = Integer.parseInt(request.getParameter("ep_id"));
        System.out.println(ep_id);
        Product product = ps.findProductById(ep_id);
        request.getSession().setAttribute("productDetail",product);
        response.sendRedirect("EasyBuy/product-view.jsp");
    }


    //后端查询商品
    protected void doSelectProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ep_ids = request.getParameter("ep_id");
        String ep_father_ids = request.getParameter("ep_father_id");
        int ep_id = 0;
        if (null!=ep_ids && !"".equals(ep_ids)){
            ep_id = Integer.parseInt(ep_ids);
        }
        int ep_father_id = 0;
        if (null!= ep_father_ids && !"".equals(ep_father_ids)){
            ep_father_id = Integer.parseInt(ep_father_ids);
        }
        System.out.println(ep_id+"---"+ep_father_id);
        List<Product> products_list_by_condition = ps.findProduct(ep_id,ep_father_id);
        request.getSession().setAttribute("products",products_list_by_condition);
        response.sendRedirect("Manage/product.jsp");
    }



    protected void doFileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建FileItemFactory对象(工厂对象)
        FileItemFactory factory = new DiskFileItemFactory();
        //创建ServletFileUpload对象，将FileItemFactory作为构造函数
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024*1024*50);
        Product product = new Product();
        int ep_id = (int)(Math.random()*1000);
        product.setEp_id(ep_id);
        //获取表单中的所有表单元素，得到的是一个List集合，里面装的都是FileItem对象
        try {
            List<FileItem> items = upload.parseRequest(request);
            //循环迭代List集合，每一次循环都是拿到表单中的一个元素（文本框、密码框、文件等）
            for(FileItem item : items){
                //判断该元素是表单文本元素还是文件元素
                if(item.isFormField()){
                    //如果是普通表单元素，则可以获取到该元素的name和value
                    String key = item.getFieldName();//表单元素name属性的值
                    String value = item.getString("utf-8");
                    if ("productName".equals(key)){
                        product.setEp_name(value);
                    }
                    if ("parentId".equals(key)){
                        product.setEPC_ID(542);
                    }
                    if ("productPrice".equals(key)){
                        product.setEp_price(Double.parseDouble(value));
                    }
                    if ("stock".equals(key)){
                        product.setEP_STOCK(500);
                    }
                    if ("description".equals(key)){
                        product.setEp_description(value);
                    }
                }else{
                    //如果是文件元素，可以将文件写入到服务器的硬盘中
                    File file = new File("D:\\TomCat\\apache-tomcat-7.0.106\\picture\\"+item.getName());
                    item.write(file);
                    product.setEP_FILE_NAME("images/product/timg.jpg");
                }
            }

            int isUpload =ps.addProduct(product);

            if (isUpload>0){
                System.out.println("上传成功！");
            }else
                System.out.println("上传失败！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            response.sendRedirect("Manage/index.jsp");
        }


    }










































    //最近浏览
    protected void doRecentlyViewed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取点击商品id
        int pid = Integer.parseInt(request.getParameter("epid"));
        Product pc = (Product) ps.findALlProductById(pid);
        //放入作用域:
        request. setAttribute("pp", pc);
        //最近浏览处理:
        Cookie[] cks=request. getCookies();
        if (cks!=null && cks.length>0){
            Cookie cookie = null;
            for (Cookie ck : cks){
                String key = ck.getName();
                if ("pids".equals(key)){

                }
            }
        }
    }


}
