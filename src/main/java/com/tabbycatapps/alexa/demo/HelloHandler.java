package com.tabbycatapps.alexa.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

@Component
public class HelloHandler implements RequestHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloHandler.class);

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("Hello"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        LOGGER.info("here: " + input.getRequestEnvelopeJson().toString());
        return input.getResponseBuilder()
                .withSpeech("hello")
                .build();
    }

}
