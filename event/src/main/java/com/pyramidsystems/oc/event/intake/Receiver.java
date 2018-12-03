package com.pyramidsystems.oc.event.intake;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component public class Receiver {
    @JmsListener(destination="events", containerFactory = "myFactory")
    public void receiveEvent(String eventData)
    {

    }
}
