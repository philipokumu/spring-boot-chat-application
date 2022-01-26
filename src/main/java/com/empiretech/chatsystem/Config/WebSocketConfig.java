package com.empiretech.chatsystem.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
* Article explanation: https://www.pixeltrice.com/build-spring-boot-chat-application-from-scratch/
* Video explanation: https://www.youtube.com/watch?v=IwYmskBswPg&t=2s
*/
@Configuration
@EnableWebSocketMessageBroker // Enables web socker server
/*
* WebSocketMessageBrokerConfigurer has methods for estaablishing 2 way connection between server and client
*/
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /*
    * STOMP identifies the endpoint where only messages of a certain channel should be shared in that channel
    */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
