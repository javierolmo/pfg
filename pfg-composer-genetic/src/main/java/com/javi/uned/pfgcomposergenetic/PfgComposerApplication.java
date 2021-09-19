package com.javi.uned.pfgcomposergenetic;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PfgComposerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PfgComposerApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}

}
