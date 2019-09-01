package com.coolio.mailman.service;

import com.coolio.mailman.bo.CoolioMail;
import com.coolio.mailman.bo.CoolioMailResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aseem Savio
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CoolioEmailService.class)
@TestPropertySource("Classpath:/CoolioEmailServiceTest.properties")
public class CoolioEmailServiceTest {


    @Autowired
    CoolioEmailService coolioEmailService;

    private CoolioMail gimmeCoolioMail() {
        CoolioMail coolioMail = new CoolioMail();
        coolioMail.setName("Aseem");
        coolioMail.setFromAddress(coolioEmailService.getEmailId());
        coolioMail.setToAddress("aseemsavio@gmail.com");
        coolioMail.setSubject("my subject");
        return coolioMail;
    }

    @Test
    public void sendPostCreatedEmailTest(){
        CoolioMail coolioMail = gimmeCoolioMail();
        Map<String, Object> model = new HashMap<>();
        model.put("name", coolioMail.getName());

        System.out.println(coolioMail.getName() + coolioMail.getFromAddress() + coolioEmailService.getEmailId() + coolioEmailService.getPassword());
        CoolioMailResponse coolioMailResponse = coolioEmailService.sendPostCreatedEmail(coolioMail, model);
        Assert.assertEquals(coolioMailResponse.getMessage(), "Post Creation Email to: savio@gmail.com SUCCESSFUL");
        Assert.assertTrue(coolioMailResponse.isStatus());
    }
}
