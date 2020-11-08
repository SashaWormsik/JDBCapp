package org.sashaworms.pvt.service;

public class SQL {

    public static final String SELECT_ALL_USERS = "SELECT * FROM public.user u JOIN public.dept d ON u.dept_num = d.id order by u.id";
    public static final String SELECT_USER = "SELECT * FROM public.user u JOIN public.dept d ON u.dept_num = d.id WHERE u.id = ?";
    public static final String DELETE_USER_BY_ID = "delete from public.user where id = ?";
    public static final String INSERT_USER = "INSERT INTO public.user "
            + "(first_name, last_name, birthdate,  male, dept_num, salary) VALUES (?,?,?,?,?, ?)";
    public static final String UPDATE_USER = "UPDATE public.user SET first_name = ?, last_name = ?,"
            + "birthdate = ?,  male = ?, dept_num = ?, salary = ? WHERE id = ?";

    public static final String SELECT_ALL_DEPARTMENTS = "select * from public.dept order by id";
    public static final String SELECT_DEPT = "select * from public.dept where dept_name = ?";
    public static final String DELETE_DEPT_BY_ID = "delete from public.dept where id = ?";
    public static final String INSERT_DEPT = "INSERT INTO public.dept "
            + "(dept_name) VALUES (?)";
    public static final String UPDATE_DEPT = "UPDATE public.dept SET dept_name = ? WHERE id = ?";
}