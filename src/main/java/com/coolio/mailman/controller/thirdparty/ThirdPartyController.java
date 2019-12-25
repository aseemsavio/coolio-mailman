package com.coolio.mailman.controller.thirdparty;

import com.coolio.mailman.bo.CoolioMailResponse;
import com.coolio.mailman.bo.thirdparty.NewMessageAlert;
import com.coolio.mailman.service.CoolioEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ThirdPartyController {

    @Autowired
    CoolioEmailService coolioEmailService;

    @PostMapping("/thirdParty/sendNewMessageAlert")
    public CoolioMailResponse sendAlertEmailForNewMessageForAseemSite(@RequestBody NewMessageAlert mail) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", mail.getFirstName());
        if(!coolioEmailService.isNullOrEmpty(mail.getEmail()))
            model.put("mail", mail.getEmail());
        else
            model.put("mail", "NA");
        if(!coolioEmailService.isNullOrEmpty(mail.getPhone()))
            model.put("phone", mail.getPhone());
        else
            model.put("phone", "NA");
        model.put("message", mail.getMessage());
        model.put("creationts", mail.getCreatedTSindia());
        model.put("messageid", mail.getMessageID());
        model.put("clientip", mail.getClientIP());

        return coolioEmailService.sendAlertEmailForNewMessageForAseemSite(mail, model);
    }


}
