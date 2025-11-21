package com.java.virtusa.dao;

import com.java.virtusa.model.Agent;
import java.util.List;
import java.util.Optional;

public interface AgentDao {
    boolean insert(Agent agent) throws Exception;
    Optional<Agent> findById(String agentId) throws Exception;
    List<Agent> findAll() throws Exception;
    List<Agent> findByNameLike(String namePattern) throws Exception;
}
