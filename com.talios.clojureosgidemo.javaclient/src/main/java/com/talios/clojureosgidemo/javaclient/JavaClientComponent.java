package com.talios.clojureosgidemo.javaclient;

import com.talios.clojureosgidemo.api.EchoService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class JavaClientComponent {

  @Reference private EchoService echoService;

  @Activate
  public void activate() {
    echoService.echo("Hello from Java");
  }
}
