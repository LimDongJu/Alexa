package com.amazon.ask.conti.handlers;

import java.util.Optional;

import com.amazon.ask.conti.model.Constants;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class HelpIntentHandler implements RequestHandler{

	 @Override
     public boolean canHandle(HandlerInput input) {
         return input.matches(Predicates.intentName("AMAZON.HelpIntent"));
     }

     @Override
     public Optional<Response> handle(HandlerInput input) {
         String speechText = Constants.HELP_MESSAGE;
         return input.getResponseBuilder()
                 .withSpeech(Constants.HELP_MESSAGE)            
                 .withReprompt(Constants.HELP_MESSAGE)
                 .build();
     }
}
