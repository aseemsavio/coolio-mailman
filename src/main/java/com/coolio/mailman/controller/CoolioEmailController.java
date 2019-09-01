package com.coolio.mailman.controller;

import com.coolio.mailman.bo.CoolioMail;
import com.coolio.mailman.bo.CoolioMailResponse;
import com.coolio.mailman.service.CoolioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aseem Savio
 * <p>
 * Controller class for Coolio Email Services.
 */

@RestController
public class CoolioEmailController {

    @Autowired
    CoolioEmailService coolioEmailService;

    @PostMapping("/sendPostCreationEmail")
    public CoolioMailResponse sendPostCreationEmail(@RequestBody CoolioMail mail) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", mail.getName());
        return coolioEmailService.sendPostCreatedEmail(mail, model);

    }

}
