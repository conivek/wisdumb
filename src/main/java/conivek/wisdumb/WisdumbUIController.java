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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the WisDumb UI.
 */
@Controller
public class WisdumbUIController {
  @Autowired
  public WisdumbConfigProps configProps;

  @GetMapping("#{@wisdumbConfigProps.pathToEnlightenment}")
  public String enlightenment(Model model) {
    model.addAttribute(configProps.getKeyToWisdom(),
        "Wise enlightenment coming soon...");
    return configProps.getPathToEnlightenment();
  }
}
