package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SubjectVO;

public class SubjectDAO {
	// 학과 목록
	public void getSubjectTotalList() throws Exception {
		String sql = "select * from subject order by no";// SQL develope 에 입력할 문장
		Connection con = null;// DB에 연결하기위한 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;// (JDBC) select 문의 결과를 저장하는 객체
		SubjectVO sVo = null;// model.package>>SubjectVO 를 불러오는 객체

		// DB에서 네트워크 연결 등 에러가 발생할수있어서 예외처리
		try {
			con = DBUtil.getConnection();// controller.package>>DBUtil.class>>getConnection()
			pstmt = con.prepareStatement(sql);// controller.package>>SubjectDAO.class>>getSubjectTotalList()>>Connection con
			rs = pstmt.executeQuery();// 결과 값

			System.out.println("일련번호\t학과번호\t학과명");

			while (rs.next()) {
				sVo = new SubjectVO();// model.package>>SubjectVO
				sVo.setNo(rs.getInt("no"));// model.package>>SubjectVO>>setNo(getSubjectTotalList()>>ResultSet rs>>no)
				sVo.setS_num(rs.getString("s_num"));// model.package>>SubjectVO>>setNo(getSubjectTotalList()>>ResultSet
													// rs>>s_num)
				sVo.setS_name(rs.getString("s_name"));// model.package>>SubjectVO>>setNo(getSubjectTotalList()>>ResultSet
														// rs>>s_name)

				System.out.println(sVo.getNo() + "\t" + sVo.getS_num() + "\t" + sVo.getS_name());

			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	// 학과 등록
	public void setSubjectRegiste(SubjectVO svo) throws Exception {
		String sql = "insert into subject values(subject_seq.nextval,?,?)";// SQL develope 에 입력할 문장
		Connection con = null;// DB에 연결하기위한 객체
		PreparedStatement pstmt = null;

		// DB에서 네트워크 연결 등 에러가 발생할수있어서 예외처리
		try {
			con = DBUtil.getConnection();// controller.package>>DBUtil.class>>getConnection()
			pstmt = con.prepareStatement(sql);// controller.package>>SubjectDAO.class>>getSubjectTotalList()>>Connection con
			pstmt.setString(1, svo.getS_num());// sql의 첫번째 물음표 자리에 svo.getS_num()
			pstmt.setString(2, svo.getS_name());// sql의 두번째 물음표 자리에 svo.getS_name()
			int i = pstmt.executeUpdate();// insert의 레코드의 건수를 반영

			// 레코드 건수가 1일때 학과를 등록하고 레코드건수가 1이 아니면 학과등록에 실패한다.
			if (i == 1) {
				System.out.println(svo.getS_name() + "학과 등록 완료");
				System.out.println("학과 등록 성공!!");
			} else {
				System.out.println("학과 등록 실패 ㅠㅠ");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 학과수정
	public void setSubjectUpdate(SubjectVO svo) throws Exception {
		String sql = "update subject set s_num=?, s_name=? where no=?";// SQL develope 에 입력할 문장
		Connection con = null;// DB에 연결하기위한 객체
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();// controller.package>>DBUtil.class>>getConnection()
			pstmt = con.prepareStatement(sql);// controller.package>>SubjectDAO.class>>getSubjectTotalList()>>Connection
			pstmt.setString(1, svo.getS_num());// sql의 1번째 자리에 svo.getS_num()
			pstmt.setString(2, svo.getS_name());// sql의 2번째 자리에 svo.getS_name()
			pstmt.setInt(3, svo.getNo());// sql의 3번째 자리에 svo.getNo()

			int i = pstmt.executeUpdate();// update의 레코드의 건수를 반영

			// 레코드 건수가 1일때 학과를 등록하고 레코드건수가 1이 아니면 학과등록에 실패한다.
			if (i == 1) {
				System.out.println(svo.getS_name() + "학과 수정 완료");
				System.out.println("학과 수정 성공!!");
			} else {
				System.out.println("학과 수정 실패 ㅠㅠ");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}

		}
	}

	// 학과삭제
	public void setSubjectDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();// StringBuffer 객체 생성:sql문자열을 계속해서 추가
		sql.append("delete from subject where no = ?");

		Connection con = null;// DB에 연결하기위한 객체
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();// controller.package>>DBUtil.class>>getConnection()
			pstmt = con.prepareStatement(sql.toString());// controller.package>>SubjectDAO.class>>getSubjectTotalList()>>sql.toString()
			pstmt.setInt(1, no);//물음표 첫번째 자리에 no
			int i = pstmt.executeUpdate();// update의 레코드의 건수를 반영

			// 레코드 건수가 1일때 학과를 등록하고 레코드건수가 1이 아니면 학과등록에 실패한다.
			if (i == 1) {
				System.out.println("학과 삭제 완료");
				System.out.println("학과 삭제 성공!!");
			} else {
				System.out.println("학과 수정 실패 ㅠㅠ");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}

		}
	}
}