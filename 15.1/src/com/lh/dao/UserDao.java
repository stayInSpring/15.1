package com.lh.dao;
import java.sql.*;

import com.lh.model.*;
/**
 * �����û���ϢDao��
 * @author lh
 */
public class UserDao {
	private static UserDao instance=null;
	public static UserDao getInstance(){
		if(instance==null) instance = new UserDao();
		return instance;
	}
	public UserDao(){}
	/**
	 * ��֤�û����˻������Ƿ�ɹ�
	 * @param user ��װ�û���Ϣ�Ķ���
	 * @return ��֤�ɹ�����true,���򷵻�false
	 */
	public Boolean checkUserLog(UserInfo user){
		boolean res = false;  
		Connection con = null;      //�����յ����ݿ����Ӷ���
		ResultSet rs = null;        //�����յĽ��������
		try{
			con=DBCon.getInstance();//��DBCon���л�����ݿ����Ӷ���
			String sql = "select id from userinfo_tb where name=? and password=?";//select���
			PreparedStatement pstmt = con.prepareStatement(sql);//����PreparedStatement����
			pstmt.setString(1, user.getName()); //�Բ����е��û�����ֵ
			pstmt.setString(2, user.getPwd());  //�Բ����е����븳ֵ
			rs=pstmt.executeQuery();            //ִ�в����ؽ����
			if(rs.next()) res=true;             //��������������һ�����ݣ�������true
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
		finally{
			try {
				rs.close();  //�رս����
				con.close(); //�ر����ݿ�����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
