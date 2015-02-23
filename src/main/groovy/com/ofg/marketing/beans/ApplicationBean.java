package com.ofg.marketing.beans;

public class ApplicationBean {

	private PersonBean person;

	private DecisionType decision;

	public PersonBean getPerson() {
		return person;
	}

	public void setPerson(PersonBean person) {
		this.person = person;
	}

	public DecisionType getDecision() {
		return decision;
	}

	public void setDecision(DecisionType decision) {
		this.decision = decision;
	}
}

