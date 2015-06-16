package com.einar.supervision.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * The Class LivingResourcePk.
 */
@Embeddable
public class LivingResourcePk implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8075374182941159111L;

	/** The id. */
	private long id;

	/** The date. */
	private long date;

	/**
	 * Instantiates a new living resource pk.
	 */
	public LivingResourcePk() {
		super();
	}

	/**
	 * Instantiates a new living resource pk.
	 * 
	 * @param id
	 *            the id
	 */
	public LivingResourcePk(long id) {
		super();
		this.id = id;
		this.date = System.currentTimeMillis();
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(long date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int) id + (int) date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LivingResourcePk) {
			LivingResourcePk id = (LivingResourcePk) obj;
			return id.id == this.id && id.date == this.date;
		}

		return false;
	}

}
