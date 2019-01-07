package db;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(String code) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean add(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}