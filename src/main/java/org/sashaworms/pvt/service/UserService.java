package org.sashaworms.pvt.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class UserService {
    private static UserService userService;
    public static final Logger LOGGER = Logger.getLogger(UserService.class);

    private UserService() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUsers() {
        List<User> result = new ArrayList<User>();
        try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_USERS);
            while (rs.next()) {
                User user = mapRawToUser(rs);
                result.add(user);
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong GETUSERS", e);
        }
        return result;
    }

    public User getUser(Integer id) {
        User user = new User();
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_USER)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = mapRawToUser(rs);
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong GETUSER", e);
        }
        return user;
    }

    private User mapRawToUser(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String fName = rs.getString(2);
        String lName = rs.getString(3);
        Date date = rs.getTimestamp(4);
        Boolean male = rs.getBoolean(5);
        String depName = rs.getString(9);
        Department department = new Department();
        if (depName != null && depName.length()>0){
            department.setDepName(depName);
            department.setDepId(rs.getInt(8));
        }
        Integer sal = rs.getInt(7);
        User user = new User(id, fName, lName, date, male, department, sal);
        return user;
    }


    public void deleteUser(Integer number) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_USER_BY_ID)) {
            stmt.setInt(1, number);
            stmt.execute();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }


    public void addUser(User user) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setTimestamp(3,
                    Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(user.getBirthdate())));
            stmt.setBoolean(4, user.isMale());
            stmt.setInt(5, user.getDepartment().getDepId());
            stmt.setInt(6, user.getSalary());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.next();
            LOGGER.info("User created with id: " + generatedKeys.getLong(1));
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public void editUser(int i, String firstName, String lastName, Date fromString, boolean male, Department dept, Integer salary) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_USER)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setTimestamp(3,
                    Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(fromString)));
            stmt.setBoolean(4, male);
            stmt.setInt(5, dept.getDepId());
            stmt.setInt(6, salary);
            stmt.setInt(7, i);
            stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }
}

