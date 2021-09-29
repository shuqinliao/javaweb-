package basic;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public Connection getConnection() {//用于创建数据库连接Connection对象
        Connection conn = null;
        try {
            //System.out.println("---------------------------------");
            Driver driver = new Driver();
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
            String url = "jdbc:mysql://localhost:3306/Products?characterEncoding=UTF-8";//数据连接字符串
            String username = "root";//用户名
            String password = "root";//密码
            conn = DriverManager.getConnection(url, username, password);//conn连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

//     Statement 用于通用查询， PreparedStatement 用于执行参数化查询

    public List<Product> find(int page){//用于传递要查询的页码
        List<Product> list = new ArrayList<Product>();//创建list
        Connection conn = getConnection();//获取连接
        String sql = "select * from tb_product order by id desc limit ?,?";//分页查询sql语句
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,(page - 1)*Product.PATH_SIZE);//对参数1赋值
            ps.setInt(2,Product.PATH_SIZE);
            ResultSet rs = ps.executeQuery();//查询
            while (rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("id"));//赋值
                p.setName(rs.getString("name"));
                //System.out.println(p.getName());
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setUnit(rs.getString("unit"));
                list.add(p);//添加
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public int findCount(){//计算商品信息的总页数
        int count = 0;//创建总数
        Connection conn = getConnection();//获取连接
        String sql = "select count(*) from tb_product";//执行查询
        try{
            Statement stmt = conn.createStatement();//创建Statement
            ResultSet rs = stmt.executeQuery(sql);//查询并获取ResultSet
            if (rs.next()){//光标后移，判断是否有效
                count = rs.getInt(1);//对记录结果赋值
            }
            rs.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

}
