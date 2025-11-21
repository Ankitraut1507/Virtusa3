package com.java.virtusa;

import com.java.virtusa.dao.AgentDao;
import com.java.virtusa.dao.AgentDaoImpl;
import com.java.virtusa.model.Agent;
import com.java.virtusa.model.Gender;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        AgentDao dao = new AgentDaoImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Show all  2. Search by name  3. Find by ID  4. Insert sample  5. Exit");
            System.out.print("Choice: ");
            int c = Integer.parseInt(sc.nextLine().trim());
            switch (c) {
                case 1:
                    List<Agent> all = dao.findAll();
                    all.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter name pattern: ");
                    String p = sc.nextLine();
                    dao.findByNameLike(p).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    Optional<Agent> ag = dao.findById(id);
                    System.out.println(ag.orElse(null));
                    break;
                case 4:
                    System.out.print("Enter id,name,city,gender(MALE/FEMALE),marital(0/1),premium: ");
                    String[] parts = sc.nextLine().split(",");
                    Agent a = new Agent(parts[0].trim(), parts[1].trim(), parts[2].trim(),
                            Gender.fromString(parts[3].trim()), Integer.parseInt(parts[4].trim()),
                            new BigDecimal(parts[5].trim()));
                    boolean ok = dao.insert(a);
                    System.out.println(ok ? "Inserted." : "Insert failed.");
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid.");
            }
        }
    }
}
