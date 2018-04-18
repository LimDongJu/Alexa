package com.amazon.ask.conti;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.conti.handlers.CancelandStopIntentHandler;
import com.amazon.ask.conti.handlers.UnlockIntentHandler;
import com.amazon.ask.conti.handlers.HelpIntentHandler;
import com.amazon.ask.conti.handlers.SessionEndedRequestHandler;
import com.amazon.ask.conti.handlers.LaunchRequestHandler;

public class ControlStreamHandler extends SkillStreamHandler {

	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(new CancelandStopIntentHandler()
						, new UnlockIntentHandler()
						, new HelpIntentHandler()
						, new LaunchRequestHandler()
						, new SessionEndedRequestHandler())
				.build();
	}
	//sds
	public ControlStreamHandler() {
		super(getSkill());
	}
}
