package com.boventech.gplearn.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "senderNotification")
@PrimaryKeyJoinColumn(name = "id")
public class SenderNotification extends Notification implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "senderNotification_user", joinColumns = { @JoinColumn(name = "senderNotification_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
	private Set<User> receivers;

	public Set<User> getReceivers() {
		return receivers;
	}

	public void setReceivers(Set<User> receivers) {
		this.receivers = receivers;
	}
}
