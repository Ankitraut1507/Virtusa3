package com.java.virtusa.dao;

import com.java.virtusa.model.Agent;
import com.java.virtusa.model.Gender;
import com.java.virtusa.util.ConnectionHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgentDaoImpl implements AgentDao {

    private static final String INSERT_SQL =
            "INSERT INTO Agent (AgentID, Name, City, GENDER, MaritalStatus, Premium) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_SQL =
            "SELECT * FROM Agent WHERE AgentID = ?";
    private static final String FIND_ALL_SQL =
            "SELECT * FROM Agent";
    private static final String FIND_BY_NAME_LIKE_SQL =
            "SELECT * FROM Agent WHERE Name LIKE ?";

    @Override
    public boolean insert(Agent agent) throws Exception {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            ps.setString(1, agent.getAgentID());
            ps.setString(2, agent.getName());
            ps.setString(3, agent.getCity());
            ps.setString(4, agent.getGender() == null ? null : agent.getGender().name());
            ps.setInt(5, agent.getMaritalStatus());
            ps.setBigDecimal(6, agent.getPremium());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public Optional<Agent> findById(String agentId) throws Exception {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_ID_SQL)) {
            ps.setString(1, agentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Agent> findAll() throws Exception {
        List<Agent> list = new ArrayList<>();
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    @Override
    public List<Agent> findByNameLike(String namePattern) throws Exception {
        List<Agent> list = new ArrayList<>();
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_NAME_LIKE_SQL)) {
            ps.setString(1, "%" + namePattern + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    private Agent mapRow(ResultSet rs) throws SQLException {
        Agent a = new Agent();
        a.setAgentID(rs.getString("AgentID"));
        a.setName(rs.getString("Name"));
        a.setCity(rs.getString("City"));
        String genderVal = rs.getString("GENDER");
        a.setGender(Gender.fromString(genderVal));
        a.setMaritalStatus(rs.getInt("MaritalStatus"));
        a.setPremium(rs.getBigDecimal("Premium"));
        return a;
    }
}
