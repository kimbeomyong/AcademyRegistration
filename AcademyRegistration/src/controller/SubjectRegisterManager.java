package controller;

import java.util.Scanner;
import model.SubjectVO;

public class SubjectRegisterManager {

	// 학과 목록
	public void subjectList() throws Exception {
		SubjectDAO sd = new SubjectDAO();// SubjectDAO 객체 생성
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();// SubjectDAO>>getSubjectTotalList()
		System.out.println();
	}

	// 학과 등록 관리
	public void subjectRegistr() throws Exception {
		Scanner input = new Scanner(System.in);// Scanner 객체 선언
		SubjectDAO sd = new SubjectDAO();// SubjectDAO 객체 선언
		SubjectVO svo = new SubjectVO();// SubjectVO 객체 선언

		String s_num; // 학과 번호
		String s_name; // 학과명

		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();// SubjectDAO>>getSubjectTotalList()
		System.out.println();
		
		System.out.println("학과 정보 입력");
		System.out.print("학과번호 : ");
		s_num = input.nextLine();
		System.out.print("학과명 : ");
		s_name = input.nextLine();

		svo.setS_num(s_num);// SubjectVO>>setS_num
		svo.setS_name(s_name);// SubjectVO>>setS_name
		
		sd.setSubjectRegiste(svo);//// SubjectDAO>>getSubjectTotalList()>>SubjectVO

		System.out.println();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();// SubjectDAO>>getSubjectTotalList()
		System.out.println();
	}

	//학과 수정 관리
	public void subjectUpdate() throws Exception {
		Scanner input = new Scanner(System.in);// scanner 객체 1
		Scanner input1 = new Scanner(System.in);// scanner 객체 2(정수 버퍼를 제거하기위해서)
		SubjectDAO sd = new SubjectDAO();// SubjectDAO 객체 선언
		SubjectVO svo = new SubjectVO();// SubjectVO 객체 선언

		int s_no; // 입력한 일련번호
		String s_num; // 학과 번호
		String s_name; // 학과명

		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();// SubjectDAO>>getSubjectTotalList()
		System.out.println();
		
		System.out.println("수정할 학과 일련번호 입력");
		System.out.print("일련번호 : ");
		s_no = input1.nextInt();//정수 버퍼를 제거하기위해서 스캐너를 한개더 사용한다.
		
		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("학과번호 : ");
		s_num = input.nextLine();
		System.out.print("학과명 : ");
		s_name = input.nextLine();

		svo.setNo(s_no);
		svo.setS_num(s_num);
		svo.setS_name(s_name);
		
		sd.setSubjectUpdate(svo);

		System.out.println();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();// SubjectDAO>>getSubjectTotalList()
		System.out.println();
	}

	// 학과 삭제 관리
	public void subjectDelete() throws Exception {
		Scanner input = new Scanner(System.in);//scanner 객체선언
		SubjectDAO sd = new SubjectDAO();//SubjectDAO 객체선언
		SubjectVO svo = new SubjectVO();//SubjectVO 객체선언
		
		int s_no; // 입력한 일련번호
		
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();// SubjectDAO>>getSubjectTotalList()
		
		System.out.println();
		System.out.println("삭제할 학과 일련번호 입력");
		System.out.print("일련번호 : ");
		s_no = input.nextInt();
		
		sd.setSubjectDelete(s_no);
		
		System.out.println();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();
		System.out.println();
	}
}