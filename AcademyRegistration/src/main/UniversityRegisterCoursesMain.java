package main;

import controller.LessonRegisterManager;
import controller.StudentRegisterManager;
import controller.SubjectRegisterManager;
import controller.TraineeRegisterManager;
import view.LESSON_CHOICE;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.STUDENT_CHOICE;
import view.SUBJECT_CHOICE;
import view.TRAINEE_CHOICE;

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

	public static void traineeMenu() throws Exception {
		int choice;// switch 문에 case 선택할때 사용
		TraineeRegisterManager traineeManager = new TraineeRegisterManager();
		// 메인메뉴 화면출력
		MenuViewer.traineeMenuView();// view.package>>TRAINEE_CHOICE.class>>traineeMenuView()
		// 키보드로 입력
		choice = MenuViewer.choice.nextInt();// view.package>>MenuViewer.class>>Scanner 입력받기
		MenuViewer.choice.nextLine();// 입력버퍼클리어

		switch (choice) {
		case TRAINEE_CHOICE.LIST:// view.package>>TRAINEE_CHOICE interface>> list = 1
			System.out.println("");
			traineeManager.traineeList();
			break;
		case TRAINEE_CHOICE.INSERT:// view.package>>TRAINEE_CHOICE interface>> insert = 1
			System.out.println("");
			traineeManager.traineeRegistr();
			break;
		case TRAINEE_CHOICE.UPDATE:// view.package>>TRAINEE_CHOICE interface>> list = 1
			System.out.println("");
			traineeManager.traineeDelete();
			break;
		case TRAINEE_CHOICE.MAIN:// view.package>>TRAINEE_CHOICE interface>> list = 1
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}// traineeMenu method
		// 과목 메뉴

	public static void lessonMenu() throws Exception {
		int choice;// switch 문에 case 선택할때 사용

		LessonRegisterManager lessonManager = new LessonRegisterManager();
		// 메인메뉴 화면 출력
		MenuViewer.lessonMenuView();// view.package>>MenuViewer.class>>lessonMenuView()
		// 키보드로 입력
		choice = MenuViewer.choice.nextInt();// view.package>>MenuViewer.class>>Scanner 입력받기
		MenuViewer.choice.nextLine();// 입력버퍼클리어

		switch (choice) {
		case LESSON_CHOICE.LIST:// view.package>>LESSON_CHOICE interface>> list = 1
			System.out.println("");
			lessonManager.lessonList();
			break;
		case LESSON_CHOICE.INSERT:// view.package>>LESSON_CHOICE interface>> insert = 2
			System.out.println("");
			lessonManager.lessonRegistr();
			break;
		case LESSON_CHOICE.UPDATE:// view.package>>LESSON_CHOICE interface>> update = 3
			System.out.println("");
			lessonManager.lessonUpdate();
			break;
		case LESSON_CHOICE.DELETE:// view.package>>LESSON_CHOICE interface>> delete = 4
			System.out.println("");
			lessonManager.lessonDelete();
			break;
		case LESSON_CHOICE.MAIN:// view.package>>LESSON_CHOICE interface>> main = 5
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}// lessonMenu method
		// 학생 메뉴

	public static void studentMenu() throws Exception {
		int choice;// switch 문에 case 선택할때 사용
		StudentRegisterManager studnetManager = new StudentRegisterManager();
		// 메인메뉴 화면 출력
		MenuViewer.studentMenuView();// view.package>>MenuViewer.class>>mainManuView()
		// 키보드로 입력
		choice = MenuViewer.choice.nextInt();// view.package>>MenuViewer.class>>Scanner 입력받기
		MenuViewer.choice.nextLine();// 입력버퍼클리어

		switch (choice) {
		case STUDENT_CHOICE.INSERT:// view.package>>STUDENT_CHOICE interface>> insert = 1
			System.out.println("");
			studnetManager.studnetRegistr();
			break;
		case STUDENT_CHOICE.UPDATE:// view.package>>STUDENT_CHOICE interface>> update = 2
			System.out.println("");
			studnetManager.studnetUpdate();
			break;
		case STUDENT_CHOICE.LIST:// view.package>>STUDENT_CHOICE interface>> list = 3
			System.out.println("");
			studnetManager.studnetTotalList();
			break;
		case STUDENT_CHOICE.MAIN:// view.package>>STUDENT_CHOICE interface>> main = 4
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}// switch
	}// studentManu method
		// 학과 메뉴

	public static void subjectMenu() throws Exception {
		int choice;// switch 문에 case 선택할때 사용

		SubjectRegisterManager subjectManager = new SubjectRegisterManager();
		// 학과메뉴선택 디스플레이
		MenuViewer.subjectMenuView();// view.package>>MenuViewer.class>>subjectMenuView()
		// 학과 메뉴입력
		choice = MenuViewer.choice.nextInt();// view.package>>MenuViewer.class>>Scanner 입력받기
		MenuViewer.choice.nextLine();// 입력버퍼클리어

		switch (choice) {
		case SUBJECT_CHOICE.LIST:// view.package>>SUBJECT_CHOICE interface>> list = 1
			System.out.println("");
			subjectManager.subjectList();
			break;
		case SUBJECT_CHOICE.INSERT:// view.package>>SUBJECT_CHOICE interface>> insert = 2
			System.out.println("");
			subjectManager.subjectRegistr();
			break;
		case SUBJECT_CHOICE.UPDATE:// view.package>>SUBJECT_CHOICE interface>> update = 3
			System.out.println("");
			subjectManager.subjectUpdate();
			break;
		case SUBJECT_CHOICE.DELETE:// view.package>>SUBJECT_CHOICE interface>> delete = 4
			System.out.println("");
			subjectManager.subjectDelete();
			break;
		case SUBJECT_CHOICE.MAIN:// view.package>>SUBJECT_CHOICE interface>> main = 5
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}// switch
	}// subjectMenu method
}// class
