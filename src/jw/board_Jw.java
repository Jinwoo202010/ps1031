package jw;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class board_Jw {

	public static void main(String[] args) {

		ArrayList<Article> articleList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		
		int testnum = 1;
		int id = 1;
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String nickname = "익명";

		Article testdata1 = new Article(1, "제목1", "내용1", year + "/" + month + "/" + day, 0, nickname);
		Article testdata2 = new Article(2, "제목2", "내용2", year + "/" + month + "/" + day, 0, nickname);
		Article testdata3 = new Article(3, "제목3", "내용3", year + "/" + month + "/" + day, 0, nickname);

		articleList.add(testdata1);
		articleList.add(testdata2);
		articleList.add(testdata3);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if (cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}

			if (cmd.equals("add")) {

				System.out.print("게시물 제목을 입력해주세요 : ");
				String t = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요 : ");
				String b = sc.nextLine();
				System.out.println("게시물이 등록되었습니다.");
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
				day = cal.get(Calendar.DAY_OF_MONTH);
				Article a1 = new Article(id, t, b, year + "/" + month + "/" + day, 0, nickname);
				articleList.add(a1);
				testnum = 0;
				id++;

				articleList.remove(testdata1);
				articleList.remove(testdata2);
				articleList.remove(testdata3);

			}
			if (cmd.equals("list")) {

				if (testnum == 1) {
					for (int i = 0; i < articleList.size(); i++) {
						Article a2 = articleList.get(i);
						System.out.println(a2.getId());
						System.out.println("----------");
						System.out.println(a2.getTitle());
						System.out.println("==========");
					}
				}
				if (testnum == 0) {
					for (int i = 0; i < articleList.size(); i++) {
						Article a = articleList.get(i);
						System.out.println("번호 : "+a.getId());
						System.out.println("제목 : "+a.getTitle());
						System.out.println("작성자 : "+a.getWriter());
						System.out.println("등록날짜 : "+a.getEnrdate());
						System.out.println("조회수 : "+a.getViews());
						System.out.println("============");
					}

				}
			}
			if (cmd.equals("update")) {
				System.out.print("수정 할 게시물 번호 : ");
				String upd = sc.nextLine();
				int targetId = Integer.parseInt(upd);
				int existFlag = 1; // 1.없다 2.있다

				for (int i = 0; i < articleList.size(); i++) {
					Article art = articleList.get(i);
					if (targetId == art.getId()) {
						existFlag = 2;
						System.out.print("새 제목 : ");
						String t2 = sc.nextLine();
						System.out.print("새 내용 : ");
						String b2 = sc.nextLine();
						System.out.println("수정이 완료되었습니다.");
						year = cal.get(Calendar.YEAR);
						month = cal.get(Calendar.MONTH) + 1;
						day = cal.get(Calendar.DAY_OF_MONTH);
						Article a2 = new Article(targetId, t2, b2, year + "/" + month + "/" + day, art.getViews(), nickname);
						articleList.set(i, a2);
						break;
					}
				}
				if (existFlag == 1) {
					System.out.println("없는 게시물입니다.");
				}
			}

			if (cmd.equals("delete")) {
				System.out.print("삭제 할 게시물 번호 : ");
				String upd = sc.nextLine();
				int targetId = Integer.parseInt(upd);
				int existFlag = 1; // 1.없다 2.있다

				for (int i = 0; i < articleList.size(); i++) {
					Article art = articleList.get(i);
					if (targetId == art.getId()) {
						existFlag = 2;
						articleList.remove(i);
						System.out.println("삭제가 완료되었습니다.");

						break;
					}
				}
				if (existFlag == 1) {
					System.out.println("없는 게시물입니다.");
				}
			}
			if (cmd.equals("read")) {
				System.out.print("보고싶은 게시물 번호를 입력하세요 : ");
				String rdnum = sc.nextLine();
				int rdid = Integer.parseInt(rdnum);
				int readFlag = 1;

				for (int i = 0; i < articleList.size(); i++) {
					Article rdart = articleList.get(i);

					if (rdid == rdart.getId()) {
						Article read = articleList.get(i);
						System.out.println(read.getId());
						System.out.println("===============");
						System.out.println(read.getTitle());
						System.out.println("===============");
						System.out.println(read.getBody());
						System.out.println("---------------");
						readFlag = 2;
						read.setViews(read.getViews() + 1);
						
						break;
						
					}

				}
				if (readFlag == 1) {
					System.out.println("없는 게시물입니다.");

				}

			}

		}
	}

}
