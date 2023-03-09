package org.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myActuatorEndpoint")
public class MyCustomEndpoints {

    @ReadOperation
    public String getMyActuatorEndpoint(){
        return "This is my actuator endpoint";
    }
}
