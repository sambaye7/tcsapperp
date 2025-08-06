package com.tcs.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.app.dao.UserDao;
import com.tcs.app.model.Persons;
import com.tcs.app.util.DBConnectUtil;

@Repository
public class UserDaoImpl implements UserDao {
    // Improved: Use List<Persons> for multiple results
    @Override
    public List<Persons> getPersonsByLastName(String lastName) {
        List<Persons> personsList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM persons WHERE last_name = ?";
        try (Connection conn = DBConnectUtil.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, lastName);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Persons persons = new Persons();
                    persons.setPersonId(rs.getInt("person_id"));
                    persons.setFirstName(rs.getString("first_name"));
                    persons.setLastName(rs.getString("last_name"));
                    persons.setAge(rs.getInt("age"));
                    personsList.add(persons);
                }
            }
        } catch (SQLException e) {
            // Use proper logging in production
            System.err.println("SQLException : " + e.getMessage());
        }
        return personsList;
    }

    @Override
    public String addUser(Persons persons) {
        String message = "";
        String sqlQuery = "INSERT INTO persons (first_name, last_name, age) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectUtil.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, persons.getFirstName());
            stmt.setString(2, persons.getLastName());
            stmt.setInt(3, persons.getAge());
            int row = stmt.executeUpdate();
            if (row > 0) {
                message = "Person details saved successfully.";
            } else {
                message = "Person details unable to save.";
            }
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return message;
    }

    @Override
    public Integer getPersonById(Integer personId) {
        Integer personDBId = null;
        String sqlQuery = "SELECT person_id FROM persons WHERE person_id = ?";
        try (Connection conn = DBConnectUtil.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, personId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    personDBId = rs.getInt("person_id");
                }
            }
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return personDBId;
    }

    @Override
    public String updatePersonById(Persons persons) {
        String message = "";
        String sqlQuery = "UPDATE persons SET last_name = ?, first_name = ?, age = ? WHERE person_id = ?";
        try (Connection conn = DBConnectUtil.getDBConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, persons.getLastName());
            stmt.setString(2, persons.getFirstName());
            stmt.setInt(3, persons.getAge());
            stmt.setInt(4, persons.getPersonId());
            int row = stmt.executeUpdate();
            if (row > 0) {
                message = "Person details updated successfully.";
            } else {
                message = "Person details unable to update.";
            }
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return message;
    }
}