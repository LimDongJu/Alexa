package com.amazon.ask.conti.handlers;

import java.util.Optional;

import com.amazon.ask.conti.model.Constants;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class OnHonkIntentHandler implements RequestHandler{

	@Override
	public boolean canHandle(HandlerInput input) {
		// TODO Auto-generated method stub
		return input.matches(Predicates.intentName("OnHonkIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder()
				.withSpeech(Constants.HORN_MESSAGE)
				.withReprompt(Constants.HORN_HELP_MESSAGE)
				//.withSimpleCard("HelloWorld", speechText)
				.build();
	}
}
