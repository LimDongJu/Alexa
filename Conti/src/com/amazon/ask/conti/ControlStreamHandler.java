package com.amazon.ask.conti;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.conti.handlers.CancelandStopIntentHandler;
import com.amazon.ask.conti.handlers.HelpIntentHandler;
import com.amazon.ask.conti.handlers.LaunchRequestHandler;
import com.amazon.ask.conti.handlers.LockIntentHandler;
import com.amazon.ask.conti.handlers.OnHazardIntentHandler;
import com.amazon.ask.conti.handlers.OnHonkIntentHandler;
import com.amazon.ask.conti.handlers.SessionEndedRequestHandler;
import com.amazon.ask.conti.handlers.UnlockIntentHandler;

public class ControlStreamHandler extends SkillStreamHandler {

	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(new CancelandStopIntentHandler()
						, new HelpIntentHandler()
						, new LaunchRequestHandler()
						, new LockIntentHandler()
						, new OnHazardIntentHandler()
						, new OnHonkIntentHandler()						
						, new SessionEndedRequestHandler()
						, new UnlockIntentHandler())
				.build();
	}
	//sds
	public ControlStreamHandler() {
		super(getSkill());
	}
}
