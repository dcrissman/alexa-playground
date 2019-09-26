package com.tabbycatapps.alexa.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.ask.Skill;
import com.amazon.ask.builder.SkillConfiguration;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.handler.GenericRequestHandler;
import com.amazon.ask.request.handler.adapter.impl.BaseHandlerAdapter;
import com.amazon.ask.servlet.SkillServlet;

@Configuration
public class Config {

    @Bean
    public ServletRegistrationBean<SkillServlet> skillServletRegistrationBean(
            List<GenericRequestHandler<HandlerInput, Optional<Response>>> handlerAdapters) {
        return new ServletRegistrationBean<>(new SkillServlet(new Skill(
                SkillConfiguration.builder()
                .withHandlerAdapters(handlerAdapters.stream()
                                .map(handler -> new BaseHandlerAdapter<>((Class<RequestHandler>) handler.getClass()))
                        .collect(Collectors.toList()))
                .build())));
    }

}
