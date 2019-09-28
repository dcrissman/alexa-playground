package com.tabbycatapps.alexa.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.ask.builder.CustomSkillBuilder;
import com.amazon.ask.servlet.SkillServlet;

@Configuration
public class Config {

    @Bean
    public ServletRegistrationBean<SkillServlet> skillServletRegistrationBean() {
        return new ServletRegistrationBean<>(new SkillServlet(new CustomSkillBuilder()
                .addRequestHandlers(
                        new NextQuestionHandler()
                )
                .build()));
    }

}
