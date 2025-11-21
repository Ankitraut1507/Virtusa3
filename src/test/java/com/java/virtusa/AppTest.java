package com.java.virtusa;

import com.java.virtusa.dao.AgentDao;
import com.java.virtusa.dao.AgentDaoImpl;
import com.java.virtusa.model.Agent;
import com.java.virtusa.model.Gender;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.Optional;

public class AppTest {

    @org.testng.annotations.Test
    public void testInsertAndFind() throws Exception {
        AgentDao dao = new AgentDaoImpl();
        String id = "tst-" + System.currentTimeMillis();
        Agent a = new Agent(id, "JUnitUser", "TestCity", Gender.MALE, 0, new BigDecimal("123.45"));
        boolean inserted = dao.insert(a);
        Assertions.assertTrue(inserted);

        Optional<Agent> fetched = dao.findById(id);
        Assertions.assertTrue(fetched.isPresent());
        Assertions.assertEquals("JUnitUser", fetched.get().getName());
    }
}
