package study.db;


import java.util.Scanner;

public class DbTestMain {

    public static void main(String[] args) {

        MemberService memberService = new MemberService();

     // dbTest.dbSelect();
     // dbTest.dbInsert();
     // dbTest.dbUpdate();
     //   dbTest.dbDelete();

        // 고정된 값이 아니라 입력 값을 저장할 수 있당

        Scanner sc = new Scanner(System.in);

        System.out.println("탈퇴할 아이디를 입력해주세요.");
        System.out.print("아이디 입력:>>>");
        String id = sc.next();
        /*
        System.out.print("비밀번호 입력:>>>");
        String password = sc.next();
        System.out.print("이름 입력:>>>");
        String name = sc.next();
        */


        Member member = new Member();
        member.setId(id);
//        member.setPassword(password);
//        member.setName(name);

 //       memberService.register(member);
          memberService.withDraw(member);

    }

}
