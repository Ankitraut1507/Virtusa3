package com.java.virtusa.main;

import com.java.virtusa.dao.AgentDao;
import com.java.virtusa.dao.AgentDaoImpl;
import com.java.virtusa.model.Agent;

import java.util.List;
import java.util.Scanner;

public class AgentSearchMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name or part of name to search: ");
        String pattern = sc.nextLine();
        AgentDao dao = new AgentDaoImpl();
        List<Agent> found = dao.findByNameLike(pattern);
        if (found.isEmpty()) {
            System.out.println("No agents found.");
        } else {
            found.forEach(System.out::println);
        }
        sc.close();
    }
}
