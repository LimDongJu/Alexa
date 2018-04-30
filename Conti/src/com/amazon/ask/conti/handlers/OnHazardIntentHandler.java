package com.amazon.ask.conti.handlers;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class OnHazardIntentHandler implements RequestHandler{

	@Override
	public boolean canHandle(HandlerInput input) {
		// TODO Auto-generated method stub
		//return input.matches(Predicates.requestType());
		return false;
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		// TODO Auto-generated method stub
		return null;
	}

}
