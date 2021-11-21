package lesson10;

import java.awt.*;
import java.sql.*;
import java.util.Random;

public class JdbcApbb {

    private static Connection connection;
    private static Statement statement; //занимаеется отправкой запросов в бд
    private static final Random random = new Random();

    public static void main(String[] args) {
        try {
            connect();
            createTable();
            long start = System.currentTimeMillis();
            insertStudents();
            System.out.println("insert stmt " + (System.currentTimeMillis() - start) + "ms");
            start = System.currentTimeMillis();
            insertOneStudent("Charlie", "34A");
            System.out.println("insert batch " + (System.currentTimeMillis() - start) + "ms");
            readData();
            dropTable();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db"); //подключаемся к бд
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //close smth else
    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists students\n" +
                "(\n" +
                "    id         integer primary key autoincrement not null,\n" +
                "    name       text                              not null,\n" +
                "    group_name text,\n" +
                "    score      integer\n" +
                ");");
    }

    private static void insertStudents() throws SQLException {
        for (int i = 0; i < 10; i++) {
            statement.executeUpdate("insert into students (name, group_name, score)\n" +
                    "values ('Bob" + i + "', '22', 5);");
        }
    }

    private static void insertStudentBatch() {
        try (PreparedStatement ps = connection.prepareStatement("insert into students (name, group_name, score)\n" +
                "values (?, '22', 5);")) {
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "Jack " + i);
                ps.setString(2, "group " + (10 - i));
                ps.setInt(3, random.nextInt(6));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void insertOneStudent(String name, String group) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("insert into students (name, group_name, score)\n" +
                "values (?, ?, 5);");) {
            ps.setString(1, name);
            ps.setString(2, group);
            ps.execute();
//        statement.executeUpdate("insert into students (name, group_name, score)\n" +
//                "values ('" + name + "', '22', 5);");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static void readData() {
        try (ResultSet rs = statement.executeQuery("select * from students")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") +
                        " " + rs.getString(3) + " " + rs.getInt("score"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void dropTable() throws SQLException {
        statement.executeUpdate("drop table students");
    }

}