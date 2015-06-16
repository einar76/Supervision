package com.einar.supervision.bean;

import java.text.SimpleDateFormat;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * The Class LivingResource.
 */
@Entity
public class LivingResource {

	/** The key. */
	@EmbeddedId
	private LivingResourcePk key;

	/** The execution. */
	private long execution;

	/** The etat. */
	private boolean etat;

	/** The commentaire. */
	private String commentaire;

	/** The name. */
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Instantiates a new living resource.
	 */
	public LivingResource() {
		super();
	}

	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public LivingResourcePk getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the new key
	 */
	public void setKey(LivingResourcePk key) {
		this.key = key;
	}

	/**
	 * Gets the execution.
	 * 
	 * @return the execution
	 */
	public long getExecution() {
		return execution;
	}

	/**
	 * Sets the execution.
	 * 
	 * @param execution
	 *            the new execution
	 */
	public void setExecution(long execution) {
		this.execution = execution;
	}

	/**
	 * Checks if is etat.
	 * 
	 * @return true, if is etat
	 */
	public boolean isEtat() {
		return etat;
	}

	/**
	 * Sets the etat.
	 * 
	 * @param etat
	 *            the new etat
	 */
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	/**
	 * Gets the commentaire.
	 * 
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Sets the commentaire.
	 * 
	 * @param commentaire
	 *            the new commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("LivingResource[id=%d, date=%s, etat='%b', execution='%d']", getKey().getId(), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(getKey().getDate()), etat, execution);
	}

}
