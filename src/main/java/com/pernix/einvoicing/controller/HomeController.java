package com.pernix.einvoicing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pernix.einvoicing.service.hacienda.oauth2.OAuth2Service;

@RestController
public class HomeController {

    @Autowired
    OAuth2Service HaciendaOAuth2Service;

    @RequestMapping("/")
    public String index() {
      if(StringUtils.isEmpty(HaciendaOAuth2Service.getAccessToken()))
          return "ERROR";
      return "SUCCESSFULLY TOKEN ACCESS." + " PERNIX E-INVOICE JAVA SERVER STARTED SUCCESSFULLY.";
    }
}
