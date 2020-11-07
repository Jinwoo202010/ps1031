package jw;

import java.util.ArrayList;
import java.util.Scanner;

public class board_Jw {

	public static void main(String[] args) {
		
		
		ArrayList<Article> articleList = new ArrayList<>();	
		Scanner sc = new Scanner(System.in);
		
		int id = 1;
		

		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if(cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}

			if(cmd.equals("add")) {

				System.out.print("게시물 제목을 입력해주세요 : ");
				String t = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요 : ");
				String b = sc.nextLine();
				System.out.println("게시물이 등록되었습니다.");
				Article a1 = new Article(id, t , b);
				articleList.add(a1);

				id++;
                
			} 
			if(cmd.equals("list")) {

				for(int i = 0; i < articleList.size(); i++) {
					Article a = articleList.get(i);
					System.out.println(a.getId());
					System.out.println("----------");
					System.out.println(a.getTitle());
					System.out.println(a.getBody());
					System.out.println("==========");
				}
			}
			if(cmd.equals("update")) {
				System.out.print("수정 할 게시물 번호 : ");
				String upd = sc.nextLine();
				int targetId = Integer.parseInt(upd);
				int existFlag = 1; // 1.없다 2.있다
				
				for(int i = 0; i < articleList.size(); i++) {
					Article art = articleList.get(i);
					if(targetId == art.getId()) {
						existFlag = 2;
						System.out.print("새 제목 : ");
						String t2 = sc.nextLine();
						System.out.print("새 내용 : ");
						String b2 = sc.nextLine();
						System.out.println("수정이 완료되었습니다.");
						Article a2 = new Article(targetId, t2, b2 );
						articleList.set(i, a2);
						break;
					}
				}
				if(existFlag == 1) {
					System.out.println("없는 게시물입니다.");
				}
			}
			
				if(cmd.equals("delete")) {
					System.out.print("삭제 할 게시물 번호 : ");
					String upd = sc.nextLine();
					int targetId = Integer.parseInt(upd);
					int existFlag = 1; // 1.없다 2.있다
					
					for(int i = 0; i < articleList.size(); i++) {
						Article art = articleList.get(i);
						if(targetId == art.getId()) {
							existFlag = 2;
							articleList.remove(i);
							System.out.println("삭제가 완료되었습니다.");
							
							break;
						}
					}
				}
				
					
					}
			}
	
		}

	








