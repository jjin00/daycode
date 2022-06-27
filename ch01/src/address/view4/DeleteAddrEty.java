package address.view4;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.table.DefaultTableModel;

public class DeleteAddrEty {

	public AddressVO delete(AddressVO vo) {
		System.out.println("DeleteAddrEty delete 호출 성공");
//		int row = table.getSelectedRow();
//		if(row<0) return;
		 Connection con = null;
	      PreparedStatement pstmt = null;
	      StringBuilder sql = new StringBuilder();
	      
	      DBConnectionMgr dbMgr = new DBConnectionMgr();
	      sql.append("DELETE FROM MKADDRTB");
	      sql.append("WHERE ID = ?");
	      int result = 0;
	      try {con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
//			pstmt.setInt(1, (String) model2.getValueAt(row, 0));
			
			System.out.println(vo.getId());
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("삭제되었습니다.");
			}else if (result != 1) {
				System.out.println("삭제되지않았습니다.");
			}
				
			} catch (Exception e) {
				e.getStackTrace();
			}finally {
				DBConnectionMgr.freeConnection(pstmt, con);
				
			}
			System.out.println("end");
			return vo ;
	}

}


//public class DeleteAddrEty {
	
/********************************
 * 회원 삭제 구현
 * DELETE FROM MKADDRTB
 * WHERE ID = 1
 * @param int - 사용자가 입력한 값 담기
 * @return - 삭제 성공 여부 담기
 ******************************/
//
//	public int delete(int id) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		DBConnectionMgr dbMgr = new DBConnectionMgr();
//		
//		System.out.println("DeleteAddrEty delete 호출 성공");
//		int result = 0;
//		StringBuilder sql = new StringBuilder();
//		sql.append("DELETE FROM MKADDRTB");
//		sql.append("WHERE ID=1");
//		
//		
//		try {con = dbMgr.getConnection();
//		pstmt = con.prepareStatement(sql.toString());
//		pstmt.setInt(1, id);
//		result = pstmt.executeUpdate();
//		if(result == 1) {
//			System.out.println("삭제되었습니다.");
//		}else if (result != 1) {
//			System.out.println("삭제되지않았습니다.");
//		}
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//		}finally {
//			DBConnectionMgr.freeConnection(pstmt, con);
//			
//		}
//		
//		 
//		return result;
//	}
//
//}
// 