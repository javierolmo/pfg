package com.javi.uned.pfgcomposergenetic.config.musescore;

import com.javi.uned.pfgcomposergenetic.adapters.musescore.MusescoreController;
import com.javi.uned.pfgcomposergenetic.domain.ports.MusescorePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MusescorePort musescorePort() {
        return new MusescoreController();
    }
}
