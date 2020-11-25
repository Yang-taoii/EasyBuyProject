package com.kgc.dao;

import java.sql.*;

public class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/easybuy";
    private String user="root";
    private String password="root";

    protected Connection con = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public Connection getConnection(){
        try {
            if(con==null || con.isClosed()){
                Class.forName(driver);
                con = DriverManager.getConnection(url,user,password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int update(String sql ,Object[] obj){
        int num = -1;
        con = this.getConnection();
        try {
            ps = con.prepareStatement(sql);
            if (obj != null){
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i+1,obj[i]);
                }
            }
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return num;
    }


    public ResultSet query(String sql,Object[] object){
        try{
            con = this.getConnection();
            ps = con.prepareStatement(sql);
            if(object!=null){
                for(int i=0;i<object.length;i++){
                    ps.setObject(i+1, object[i]);
                }
            }
            rs=ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
