package com.coolio.mailman.bo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aseem Savio
 */

public class CoolioMailTest {

    private CoolioMail gimmePopulatedConstructor() {
        return new CoolioMail("Aseem", "aseem@gmail.com", "savio@gmail.com", "my subject");
    }

    private CoolioMail gimmeEmptyConstructor() {
        return new CoolioMail();
    }

    private CoolioMail gimmeSettedCoolioMail() {
        CoolioMail coolioMail = new CoolioMail();
        coolioMail.setName("Aseem");
        coolioMail.setFromAddress("aseem@gmail.com");
        coolioMail.setToAddress("savio@gmail.com");
        coolioMail.setSubject("my subject");
        return coolioMail;
    }

    @Test
    public void testConstructors() {
        Assert.assertNotNull(gimmePopulatedConstructor());
        Assert.assertNotNull(gimmeEmptyConstructor());
    }

    @Test
    public void testGettersSetters() {
        CoolioMail coolioMail = new CoolioMail();
        coolioMail = gimmeSettedCoolioMail();
        Assert.assertEquals(coolioMail.getName(), "Aseem");
        Assert.assertEquals(coolioMail.getFromAddress(), "aseem@gmail.com");
        Assert.assertEquals(coolioMail.getToAddress(), "savio@gmail.com");
        Assert.assertEquals(coolioMail.getSubject(), "my subject");
    }


}
