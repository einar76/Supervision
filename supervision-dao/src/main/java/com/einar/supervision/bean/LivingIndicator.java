package com.einar.supervision.bean;

import java.text.SimpleDateFormat;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LivingIndicator {

	/** The key. */
	@EmbeddedId
	private LivingResourcePk key;

	private int value;

	private boolean dynamic = false;

	public boolean isDynamic() {
		return dynamic;
	}

	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	public LivingResourcePk getKey() {
		return key;
	}

	public void setKey(LivingResourcePk key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("LivingIndicator[id=%d, date=%s, value='%d']", getKey().getId(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(getKey().getDate()), value);
	}
}
