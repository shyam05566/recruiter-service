package com.softvision.config;

import javax.ws.rs.ApplicationPath;

import com.softvision.controller.CandidateController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            register(CandidateController.class);
        }
    }

