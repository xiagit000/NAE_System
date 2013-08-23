package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "receiverNotification")
@PrimaryKeyJoinColumn(name = "id")
public class ReceiverNotification extends Notification implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private User receiver;

	private boolean consult;

	public boolean isConsult() {
		return consult;
	}

	public void setConsult(boolean consult) {
		this.consult = consult;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

}
