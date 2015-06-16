package com.einar.supervision.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The Class LivingResource.
 */
@Entity
public class LivingSession {

	/** The id. */
	@Id
	private String id;

	/** The create time. */
	private long createTime;

	/** The finished time. */
	private long finishedTime;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the creates the time.
	 *
	 * @return the creates the time
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the creates the time.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * Gets the finished time.
	 *
	 * @return the finished time
	 */
	public long getFinishedTime() {
		return finishedTime;
	}

	/**
	 * Sets the finished time.
	 *
	 * @param finishedTime the new finished time
	 */
	public void setFinishedTime(long finishedTime) {
		this.finishedTime = finishedTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		Date start = new Date(getCreateTime());
		if (finishedTime > 0) {
			Date end = new Date(getFinishedTime());
			return String.format("LivingSession[id=%s, open=%s, close='%s']", getId(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(start),
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(end));

		} else {
			return String.format("LivingSession[id=%s, open=%s, not closed]", getId(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(start));

		}

	}

}
