package study.db;

import java.sql.*;

public class MemberService {

    public void dbSelect() {

        //db 연결
        /*
            1. ip(domain)
            2. port
            3.계정
            4. 패스워드
            5. 인스턴스
         */

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "root";
        String dbPassword = "1234";

        /*
            1. 드라이버 로드
            2. 커넥션 객체 생성
            3. 스테이트먼트 객체 생성
            4. 쿼리 실행
            5. 결과 수행
            6. 객체 연결 해제 (close) = 자원 낭비 안 하려고
         */

        // 1. 드라이버 로드
        try { // 예외 발생 검사
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) { // 발생될 것 같은 예외  (클래스가 없을 때)
            e.printStackTrace(); // 어떤 에러인지 처리해주는 거 = 에러메세지 출력
        }

        // 2. 커넥션 객체 생성
        Connection connection = null;

        //  Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        /*
            String memberEmailType = "email' or 1 = 1";
            변경될 수 있는 값들 email, kakao, facebook
         */

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 3. statement 객체 생성
            //  statement = connection.createStatement();

            String sql = " SELECT id, password " +
                    " from test_member";
            preparedStatement = connection.prepareStatement(sql);

            // 변수 = ?, (1, memberEmailValue) => 1번 데이ㅓ
            // preparedStatement.setString(1, meberEmailValue);

            // 4. 쿼리문 실행
            rs = preparedStatement.executeQuery();
            // statement.executeQuery(sql);

            // 5. 결과 수행
            while (rs.next()) {
                String id = rs.getString("id");
                String password = rs.getString("password");
                System.out.println(id + ", " + password);

            }

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {

            // 6. close
            try {
                if ( rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null&& !connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


    }

    // 회원 가입 함수
    /**
      *  @param member 회원정보
     */
    public void register(Member member) {

        //db 연결
        /*
            1. ip(domain)
            2. port
            3.계정
            4. 패스워드
            5. 인스턴스
         */

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "root";
        String dbPassword = "1234";

        /*
            1. 드라이버 로드
            2. 커넥션 객체 생성
            3. 스테이트먼트 객체 생성
            4. 쿼리 실행
            5. 결과 수행
            6. 객체 연결 해제 (close) = 자원 낭비 안 하려고
         */

        // 1. 드라이버 로드 (동일)
        try { // 예외 발생 검사
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) { // 발생될 것 같은 예외  (클래스가 없을 때)
            e.printStackTrace(); // 어떤 에러인지 처리해주는 거 = 에러메세지 출력
        }

        // 2. 커넥션 객체 생성
        Connection connection = null;

        //  Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        /*
            String memberEmailType = "email' or 1 = 1";
            변경될 수 있는 값들 email, kakao, facebook
         */

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 3. statement 객체 생성
            //  statement = connection.createStatement();

//            String idValue = "kdy1227";
//            String passwordValue = "1234";
//            String nameValue = "김쫑구";


            String sql = " INSERT into test_member (id, password, name) "
            + " values (?, ?, ?); ";


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getName());

            // 변수 = ?, (1, memberEmailValue) => 1번 데이ㅓ
            // preparedStatement.setString(1, meberEmailValue);


            // 4. 쿼리문 실행
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }

//            // 5. 결과 수행
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String password = rs.getString("password");
//                String name = rs.getString("name");
//                System.out.println(id + ", " + password + ", " + name);
//
//            }

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {

            // 6. close
            try {
                if ( rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    public void dbUpdate(Member member) {

        //db 연결
        /*
            1. ip(domain)
            2. port
            3.계정
            4. 패스워드
            5. 인스턴스
         */

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "root";
        String dbPassword = "1234";

        /*
            1. 드라이버 로드
            2. 커넥션 객체 생성
            3. 스테이트먼트 객체 생성
            4. 쿼리 실행
            5. 결과 수행
            6. 객체 연결 해제 (close) = 자원 낭비 안 하려고
         */

        // 1. 드라이버 로드 (동일)
        try { // 예외 발생 검사
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) { // 발생될 것 같은 예외  (클래스가 없을 때)
            e.printStackTrace(); // 어떤 에러인지 처리해주는 거 = 에러메세지 출력
        }

        // 2. 커넥션 객체 생성
        Connection connection = null;

        //  Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        /*
            String memberEmailType = "email' or 1 = 1";
            변경될 수 있는 값들 email, kakao, facebook
         */

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 3. statement 객체 생성
            //  statement = connection.createStatement();
//
//            String idValue = "kdy1227";
//            String passwordValue = "5678";

            String sql = " update test_member " +
                    " set " +
                    " password = ? " +
                    " WHERE id = ? ";


            preparedStatement = connection.prepareStatement(sql); // 쿼리문 먼저 실행
            preparedStatement.setString(1, member.getPassword()); // 1번 ? : 수정된 비밀번호값
            preparedStatement.setString(2, member.getId()); // 2번 ? : 사용자 id

            // 변수 = ?, (1, memberEmailValue) => 1번 데이ㅓ
            // preparedStatement.setString(1, meberEmailValue);


            // 4. 쿼리문 실행
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {

            // 6. close
            try {
                if ( rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    /**
     *  회원탈퇴 함수
     */
    public void withDraw(Member member) {

        //db 연결
        /*
            1. ip(domain)
            2. port
            3.계정
            4. 패스워드
            5. 인스턴스
         */

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "root";
        String dbPassword = "1234";

        /*
            1. 드라이버 로드
            2. 커넥션 객체 생성
            3. 스테이트먼트 객체 생성
            4. 쿼리 실행
            5. 결과 수행
            6. 객체 연결 해제 (close) = 자원 낭비 안 하려고
         */

        // 1. 드라이버 로드 (동일)
        try { // 예외 발생 검사
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) { // 발생될 것 같은 예외  (클래스가 없을 때)
            e.printStackTrace(); // 어떤 에러인지 처리해주는 거 = 에러메세지 출력
        }

        // 2. 커넥션 객체 생성
        Connection connection = null;

        //  Statement statement = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        /*
            String memberEmailType = "email' or 1 = 1";
            변경될 수 있는 값들 email, kakao, facebook
         */

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // db 연결

            // 3. statement 객체 생성
            //  statement = connection.createStatement();

            // String idValue = "tlqkf";

            String sql = " DELETE FROM test_member WHERE id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getId());

            // 변수 = ?, (1, memberEmailValue) => 1번 데이ㅓ
            // preparedStatement.setString(1, meberEmailValue);


            // 4. 쿼리문 실행
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println(" 삭제 성공 "); // 삭제되면 1, 실패하면 0이나옴
            } else {
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException e) {
            e.printStackTrace();


        } finally {

            // 6. close
            try {
                if ( rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }




}
