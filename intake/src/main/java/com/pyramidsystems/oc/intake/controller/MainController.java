package com.pyramidsystems.oc.intake.controller;

import com.pyramidsystems.oc.intake.jpa.entity.RequestLog;
import com.pyramidsystems.oc.intake.jpa.repo.RequestLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by suhas on 11/18/2018.
 */
@Controller
@RequestMapping(path="/intake")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RequestLogRepository requestLogRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewReqeuest(@RequestParam String request){
        RequestLog log = new RequestLog();
        log.setText(request);
        log = requestLogRepository.save(log);
        LOG.info("Added new request {}", log.getIdentifier());
        return log.getIdentifier();
    }

}
