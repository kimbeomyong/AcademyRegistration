package main;

import view.MENU_CHOICE;
import view.MenuViewer;
import view.SUBJECT_CHOICE;

public class UniversityRegisterCoursesMain {

	public static void main(String[] args) {
		mainmenu();
	}// main

	public static void mainmenu() {
		int choiceNum;// switch 문에 case 선택할때 사용
		boolean stopFlag = false;// 무한루프 탈출
		while (!stopFlag) {
			try {
				// 메인메뉴 화면 출력
				MenuViewer.mainManuView();// view.package>>MenuViewer.class>>mainManuView()
				// 키보드로 입력
				choiceNum = MenuViewer.choice.nextInt();// view.package>>MenuViewer.class>>Scanner 입력받기
				MenuViewer.choice.nextLine();// 입력버퍼클리어

				switch (choiceNum) {
				case MENU_CHOICE.SUBJECT:// view.package>>MENU_SUBJECT interface>> subject = 1
					subjectMenu();// method
					break;
				case MENU_CHOICE.STUDENT:// view.package>>MENU_SUBJECT interface>> student = 2
					studentMenu();// method
					break;
				case MENU_CHOICE.LESSON:// view.package>>MENU_SUBJECT interface>> lesson = 3
					lessonMenu();// method
					break;
				case MENU_CHOICE.TRAINEE:// view.package>>MENU_SUBJECT interface>> trainee = 4
					traineeMenu();// method
					break;
				case MENU_CHOICE.EXIT:// view.package>>MENU_SUBJECT interface>> exit = 5
					System.out.println("프로그램을 종료합니다.");
					stopFlag = true;// 종료
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}// switch
			} catch (Exception e) {
				System.out.println("\n 입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				stopFlag = true;// 종료
			} // catch
		} // while
	}// mainmenu method

	// 수강 신청 메뉴
	public static void traineeMenu() {
		int choiceNum;// switch 문에 case 선택할때 사용

	}// traineeMenu method

	public static void lessonMenu() {

	}// lessonMenu method

	// 학생 메뉴
	public static void studentMenu() {

	}// studentManu method

	// 학과 메뉴
	public static void subjectMenu() {
		int choice;
//		SubjectRegisterManager subjectManager = new SubjectRegisterManager();
		//학과메뉴선택 디스플레이
		MenuViewer.subjectMenuView();
		//학과 메뉴입력
		choice = MenuViewer.choice.nextInt();
		MenuViewer.choice.nextLine();
		
		switch (choice) {
			case SUBJECT_CHOICE.LIST:
				System.out.println("");
				break;
			case SUBJECT_CHOICE.INSERT:
				System.out.println("");
//				subjectManager.subjectRegistr();
				break;
			case SUBJECT_CHOICE.UPDATE:
				System.out.println("");
//				subjectManager.subjectUpdate();
				break;
			case SUBJECT_CHOICE.DELETE:
				System.out.println("");
//				subjectManager.subjectDelete();
				break;
			case SUBJECT_CHOICE.MAIN:
				return;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}// subjectMenu method
}// class
