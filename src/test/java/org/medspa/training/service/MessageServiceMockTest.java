package org.medspa.training.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.ApplicationBootstrap;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class MessageServiceMockTest {
    @Autowired
    MessageService messageService;
    @Autowired
    private AmazonSQS sqs;
    @Mock
    private GetQueueUrlResult getQueueUrlResult;

    @Test
    public void sendMessageTest_happyPath() throws IOException{
        when(sqs.getQueueUrl(anyString())).thenReturn(getQueueUrlResult);

        messageService.sendMessage("QueueTesting", 5);

        verify(sqs,times(1)).sendMessage(any(SendMessageRequest.class));
    }



}
