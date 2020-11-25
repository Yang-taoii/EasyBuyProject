package com.kgc.dao.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kgc.dao.BaseDao;
import com.kgc.pojo.Page;
import com.kgc.pojo.User;

/**
 * 用户dao
 */
public class UserDaoImpl extends BaseDao implements UserDao {


	@Override
	public List<User> fenYe(Page page) {
		String sql="select * from easybuy_user limit ?,?";
		Object[] obj={page.getPageIndex(),page.getPageSize()};
		List<User> list= new ArrayList<>();
		rs=query(sql, obj);
		try{
			while(rs.next()){
				User uu=new User();
				uu.setId(rs.getString("EU_USER_ID"));
				uu.setUserName(rs.getString("EU_USER_NAME"));
				uu.setPassword(rs.getString("EU_PASSWORD"));
				uu.setStatus(rs.getInt("EU_STATUS"));
				uu.setAddress(rs.getString("EU_ADDRESS"));
				uu.setEmail(rs.getString("EU_EMAIL"));
				uu.setIdentityCode(rs.getString("EU_IDENTITY_CODE"));
				uu.setSex(rs.getString("EU_SEX"));
				uu.setMobile(rs.getString("EU_MOBILE"));
				list.add(uu);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return list;
	}

	@Override
	public int fenYeCount() {
		String sql="select count(1) from user";
		int count=0;
		rs=query(sql, null);
		try{
			while(rs.next()){
				count=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return count;
	}

	public int add(User user){//新增用户信息
    	String sql = "insert into easybuy_user(EU_USER_ID,EU_USER_NAME,EU_PASSWORD,EU_SEX,EU_BIRTHDAY,EU_IDENTITY_CODE,EU_EMAIL,EU_MOBILE,EU_ADDRESS,EU_STATUS) values(?,?,?,?,?,?,?,?,?,?)";
    	Object[] objects = {user.getId(),user.getUserName(),user.getPassword(),user.getSex(),user.getBirthday(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getAddress(),user.getStatus()};
		return this.update(sql,objects);
    }

    //更新用户信息
    public int updateInfo(User user) {
		String sql = " update easybuy_user set EU_USER_NAME =?,EU_STATUS=?,EU_SEX =?, EU_IDENTITY_CODE =?, EU_EMAIL =?, EU_MOBILE =? WHERE EU_USER_ID =?  ";
		Object[] objects = {user.getUserName(),user.getStatus(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getId()};
		return this.update(sql,objects);
    }

	@Override
	public int deleteUserById(String id) throws Exception {


		return 0;
	}

	@Override
	public List<User> getUserList() throws Exception {
		List<User> list = new ArrayList<>();
		String sql = "select * from easybuy_user";
		rs = this.query(sql,null);
		try{
			while (rs.next()){
				User uu=new User();
				uu.setId(rs.getString("EU_USER_ID"));
				uu.setUserName(rs.getString("EU_USER_NAME"));
				uu.setPassword(rs.getString("EU_PASSWORD"));
				uu.setStatus(rs.getInt("EU_STATUS"));
				uu.setAddress(rs.getString("EU_ADDRESS"));
				uu.setEmail(rs.getString("EU_EMAIL"));
				uu.setIdentityCode(rs.getString("EU_IDENTITY_CODE"));
				uu.setSex(rs.getString("EU_SEX"));
				uu.setMobile(rs.getString("EU_MOBILE"));
				list.add(uu);
			}
		}finally {
			this.closeAll(con,ps,rs);
		}
		return list;
	}

	@Override
	public int count() throws Exception {
		return 0;
	}

	@Override
	public User getUser(int id, String userName) throws Exception {
		return null;
	}

}
