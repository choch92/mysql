package main;

import java.util.Scanner;

import com.naver.choch92.domain.MemberDao;
import com.naver.choch92.domain.MemberDaoImpl;

import service.MemberServiceImpl;

public class Main {

	public static void main(String[] args) {
		// 1번이면 회원가입 2번이면 로그인 3번이면 종료를 할 수 있도록 메뉴를 구성
		Scanner sc = new Scanner(System.in);
		MemberDao dao = MemberDaoImpl.getInstance();
		MemberServiceImpl service = new MemberServiceImpl();
		// service의 dao에 여기서 만든 dao를 주입
		service.setDao(dao);
		
		while(true) {
			System.out.printf("메뉴입력(1.회원가입 2.로그인) :");
			String menu = sc.nextLine();
			switch(menu) {
			case "1":
				boolean x = service.insertMember(sc);
				String msg = null;
				if(x==true) {
					msg = "회원가입 성공\n";
				}else {
					msg = "회원가입 실패\n";
				}
				System.out.printf(msg);
				break;
			case "2":
				boolean y = service.login(sc);
				String msglogin = null;
				if(y==true) {
					msglogin = "로그인 성공\n";
				}else {
					msglogin = "로그인 실패\n";
				}
				System.out.printf(msglogin);
				break;
			case "3":
				System.out.printf("프로그램 종료\n");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.printf("잘못된 메뉴 선택\n");
				break;
			}
			
		}		
		
	}
}
