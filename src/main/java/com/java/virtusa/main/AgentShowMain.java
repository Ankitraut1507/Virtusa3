package com.java.virtusa.main;

import com.java.virtusa.dao.AgentDao;
import com.java.virtusa.dao.AgentDaoImpl;
import com.java.virtusa.model.Agent;

import java.util.List;

public class AgentShowMain {
    public static void main(String[] args) throws Exception {
        AgentDao dao = new AgentDaoImpl();
        List<Agent> agents = dao.findAll();
        System.out.println("All agents:");
        agents.forEach(System.out::println);
    }
}
