package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

    Logger LOG = LoggerFactory.getLogger(MsgService.class);

    @ExecutionTimer
    public void printIt() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           System.out.println("exception");
        }
        LOG.info("From MsgService");
    }
}
