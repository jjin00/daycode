package address.view4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import address.view4.DBConnectionMgr;
public class RetrieveAddrEty {

	/***************************************************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
        WHERE id = 5
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/

	
	public AddressVO retrieve(AddressVO vo) {
		
	      DBConnectionMgr dbMgr = new DBConnectionMgr();
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      StringBuilder sql = new StringBuilder();
	      AddressVO rVO = null;
		System.out.println("RetrieveAddrEty retrieve(AddressVO vo) :상세조회 호출 성공");
	    sql.append("   SELECT id, name, address, telephone                         ");
        sql.append("   ,gender , relationship, comments     ");
        sql.append("   , registedate, birthday                                 ");
        sql.append("   FROM mkaddrtb                                                   ");
		try {
			 con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sql.toString());
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	        	 int id = rs.getInt("id");
		            String name = rs.getString("name");
		            String address = rs.getString("address");
		            String telephone = rs.getString("telephone");
		            String gender = rs.getString("gender");
		            String relationship = rs.getString("relationship");
		            String birthday = rs.getString("birthday");
		            String comments = rs.getString("comments");
		            String registedate = rs.getString("registedate");
	         }
			
		} catch (Exception e) {
			 System.out.println(e.toString());
		} finally {
			 DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return rVO;
	
	
	}

	   public AddressVO[] retrieve() {
		      
		      DBConnectionMgr dbMgr = new DBConnectionMgr();
		      Connection con = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		   
		      System.out.println("RetrieveAddrEty retrieve() : 전체조회 호출 성공");
		      AddressVO[] vos = null;
		      AddressVO avo = null;
		      StringBuilder sql = new StringBuilder();
		      Vector<AddressVO> v = new Vector<AddressVO>();
		      sql.append("   SELECT id, name, address, telephone                         ");
		        sql.append("   ,relationship, DECODE(gender,'1','남','2','여') as gender ,birthday  ");
		        sql.append("   ,  comments    , registedate                               ");
		        sql.append("   FROM mkaddrtb                                                    ");
		      try {
		         con = dbMgr.getConnection();
		         pstmt = con.prepareStatement(sql.toString());
		         rs = pstmt.executeQuery();
		         while(rs.next()) {
		        	 int id = rs.getInt("id");
		            String name = rs.getString("name");
		            String address = rs.getString("address");
		            String telephone = rs.getString("telephone");
		            String relationship = rs.getString("relationship");
		            String gender = rs.getString("gender");
		            String comments = rs.getString("comments");
		            String birthday = rs.getString("birthday");
		            String registedate = rs.getString("registedate");
		            
		          avo =  new AddressVO(id,name,address,telephone,relationship,gender,birthday,comments,registedate);
		          
		          
		          v.add(avo) ;
		          
		         }
		         vos = new AddressVO[v.size()];
		         v.copyInto(vos);

		      } catch (Exception e) {
		         System.out.println(e.toString());
		      } finally {
		         DBConnectionMgr.freeConnection(rs, pstmt, con);
		      }
		   
		      System.out.println("db연결 성공");
		      
		      return vos;
		      
		   }
	
}



