package org.sashaworms.pvt.service;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private static DepartmentService departmentService;
    public static final Logger LOGGER = Logger.getLogger(UserService.class);

    private DepartmentService() {
    }

    public static DepartmentService getDepartmentService() {
        if (departmentService == null) {
            departmentService = new DepartmentService();
        }
        return departmentService;
    }

    public List<Department> getDepartments() {
        List<Department> result = new ArrayList<Department>();
        try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_DEPARTMENTS);
            while (rs.next()) {
                result.add(mapRawToDepartment(rs));
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return result;
    }

    public Department getDepartment(String deptName) {
        Department department = new Department();
        try (Connection conn = DBUtils.getConnetion(); PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_DEPT)) {
            stmt.setString(1, deptName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                department = mapRawToDepartment(rs);
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return department;
    }

    private Department mapRawToDepartment(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String dName = rs.getString(2);
        Department department = new Department(id, dName);
        return department;
    }

    public void deleteDepartment(Integer number) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_DEPT_BY_ID)) {
            stmt.setInt(1, number);
            stmt.execute();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public void addDepartment(Department department) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEPT, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, department.getDepName());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.next();
            LOGGER.info("Department created with id: " + generatedKeys.getLong(1));
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public void editDepartment(int i, String depName) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_DEPT)) {
            stmt.setString(1, depName);
            stmt.setInt(2, i);
            stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

}
