package com.pyramidsystems.oc.intake.controller;

import com.pyramidsystems.oc.intake.events.producer.MessageSender;
import com.pyramidsystems.oc.intake.jpa.entity.RequestLog;
import com.pyramidsystems.oc.intake.jpa.repo.RequestLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by suhas on 11/18/2018.
 */
@Controller
@RequestMapping(path="/intake")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private RequestLogRepository requestLogRepository;

    @GetMapping(path="/health")
    public @ResponseBody String checkHealth()
    {
        return "Ok";
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewReqeuest(@RequestParam String request){
        RequestLog log = new RequestLog();
        log.setText(request);
        log = requestLogRepository.save(log);

        messageSender.send(request);
        LOG.info("Added new request {}", log.getIdentifier());
        return log.getIdentifier();
    }

    @CrossOrigin(origins = "*")
    @GetMapping (path = "/dashboard")
    public @ResponseBody  List<String[]> getDashboard(){
        List<String[]> retVal = new ArrayList<>();

        List<Object[]> data = requestLogRepository.getCount();

        for (Object[] row:data){
            String[] ticker = {(String) row[0], row[1].toString()};
            retVal.add(ticker);
        }

        return retVal;
    }

    @MessageMapping("/addTicker")
    @SendTo("/topic/tickers")
    public String addTicker(String ticker){
        RequestLog log = new RequestLog();
        log.setText(ticker);
        log = requestLogRepository.save(log);

        messageSender.send(ticker);
        LOG.info("Added new request {}", log.getIdentifier());
        return ticker;

    }

}
