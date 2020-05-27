package com.dilanka.ws.soap_demo.endpoint;

import com.dilanka.types.helloworld.Greeting;
import com.dilanka.types.helloworld.ObjectFactory;
import com.dilanka.types.helloworld.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class HelloWorldEP {
    private final static String NAMESPACE = "http://dilanka.com/types/helloworld";
    private final static ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @PayloadRoot(namespace = NAMESPACE, localPart = "person")
    @ResponsePayload
    public Greeting sayHello(@RequestPayload Person person) {
        String response = "Hello ".concat(person.getFirstName()).concat(" ").concat(person.getLastName());
        log.info(response);
        Greeting greeting = OBJECT_FACTORY.createGreeting();
        greeting.setGreeting(response);
        return greeting;
    }
}
