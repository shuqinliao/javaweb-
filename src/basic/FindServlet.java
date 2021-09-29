package basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class FindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //重写doGet对分页请求进行处理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int currPage = 1;//创建页码
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("page") != null) {
            currPage = Integer.parseInt(request.getParameter("page"));
        }
        ProductDao dao = new ProductDao();//实例化
        List<Product> list = dao.find(currPage);//查询所有商品信息
        request.setAttribute("list", list);
        int pages;
        int count = dao.findCount();
        if (count % Product.PATH_SIZE == 0) {//计算总页数
            pages = count / Product.PATH_SIZE;
        } else {
            pages = count / Product.PATH_SIZE + 1;
        }
        StringBuffer sb = new StringBuffer();//实例化
        for (int i = 1; i <= pages; i++) {
            if (i == currPage) {
                sb.append("[" + i + "]");//构建分页条
            } else {
                sb.append("<a href='list?page=" + i + "' >" + i + "</a>");
            }
            //sb.append("");
        }
        request.setAttribute("bar", sb.toString());//将分页条的字符串放置到request中
        request.getRequestDispatcher("product_list.jsp").forward(request, response);//转发
    }
}
