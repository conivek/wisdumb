/*
 * (C) Copyright Premiere Global Services 2021 - All Rights Reserved
 * 
 * This source code and documentation is copyrighted and owned by Premiere
 * Global Services.
 * 
 * Permission to use, copy, modify, and distribute this software and its
 * documentation for ANY purposes commercial or non-commercial must be obtained
 * via licensing arrangements with Premiere Global Services.
 */
package conivek.wisdumb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * WisDumb externalized configuration properties.
 */
@Component("wisdumbConfigProps")
@Configuration
@ConfigurationProperties(prefix = "wisdumb")
@Data
public class WisdumbConfigProps {
  private String pathToEnlightenment;
  private String keyToWisdom;
}
