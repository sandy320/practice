package com.wbchao;

import org.junit.Test;

import java.sql.DriverManager;

public class JdbcTest {

    /* jdbc:mysql://localhost:3306/库名?useSSL=false&serverTimezone=UTC
     * useSSL=false在最新版的sql需要验证,然而并没有,需要设定
     * serverTimezone=UTC一个时区的设定
     */
    private static String url = "jdbc:mysql://s105:3306/big9_hive?useSSL=false&serverTimezone=UTC";
    /*注意driver改了,多了 .cj */
    private static String driver = "com.mysql.cj.jdbc.Driver";
    /*用户名和密码*/
    private static String username = "root";
    private static String password = "Sandy1234`";

    @Test
    public void testJdbc() throws Exception {
        //反射的一个过时方法,不过比较简单,不要介意,以后也是用连接池来做的
        Class.forName(driver).newInstance();
        System.out.println(DriverManager.getConnection(url, username, password));
    }
}
