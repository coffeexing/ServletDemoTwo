package com.dao;
import com.bean.User;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    public Collection<User> getAllUsers() {
        Connection connection = DBUtil.getConn();        
        Statement statement = null;
        Map<String, User> userMap = new HashMap<String, User>();
        ArrayList<Object> list=new ArrayList<Object>();
        list.add("abc");list.add(1);
        /*HashMap<Object,Object> m=new HashMap<Object,Object>();
        Map m2=new HashMap();
        m2.replace(m, m2);*/
        String sql = "select * from users";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String friendsStr = rs.getString("friends");
                String[] friends = friendsStr.split(",");
                User user = new User(name, phone);
                user.setFriends(Arrays.asList(friends));
                userMap.put(name, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(connection, statement, null, null);
        return userMap.values();
    }

    public User getUser(String userId) {
        Connection connection = DBUtil.getConn();
        String sql = "select * from users where name=\"" + userId + "\"";
        User user = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String friendsStr = rs.getString("friends");
                String[] friends = friendsStr.split(",");

                user = new User(name, phone);
                user.setFriends(Arrays.asList(friends));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.close(connection, statement, null, null);
        return user;
    }

    public Boolean addUser(User user) {
        Connection connection = DBUtil.getConn();

        StringBuffer sb = new StringBuffer("");
        for (String str : user.getFriends()) {
            sb.append(str + ",");
        }
        String friends = sb.toString().substring(0, sb.toString().length() - 1);

        String sql = "insert into users values (\'" + user.getName() + "\',\'"
                + user.getPhone() + "\',\'" + friends + "\')";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.close(connection, statement, null, null);
        return false;
    }

    public Boolean delUser(String name) {
        Connection connection = DBUtil.getConn();
        Statement statement = null;

        String sql = "delete from users where name=\"" + name + "\"";

        try {
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.close(connection, statement, null, null);
        return false;
    }
}
