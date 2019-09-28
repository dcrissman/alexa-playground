package com.tabbycatapps.alexa.demo;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.ui.PlainTextOutputSpeech;

@Component
public class NextQuestionHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return Optional.of(Response.builder()
                .withOutputSpeech(PlainTextOutputSpeech.builder()
                        .withText("hello")
                        .build())
                .build());
    }

}
