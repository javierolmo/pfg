package com.javi.uned.pfgcomposer.config.musescore;

import com.javi.uned.pfgcomposer.adapters.musescore.MusescoreController;
import com.javi.uned.pfgcomposer.domain.ports.MusescorePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MusescorePort musescorePort() {
        return new MusescoreController();
    }
}
