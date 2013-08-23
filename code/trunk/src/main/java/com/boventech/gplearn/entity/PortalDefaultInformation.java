package com.boventech.gplearn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="portaldefaultinformation")
public class PortalDefaultInformation implements Serializable {

	private static final long serialVersionUID = -5631478908218083448L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,length=2500)
	private String title;
	
	@Column(nullable=false,length=10000)
	private String content;
	
	@Column(length=2000)
	private String imagePath;

	@Enumerated(EnumType.STRING)
	private PortalDefaultType proNoticeType;
	
	private Long clickCount=0L;

	@Column(length=255)
	private String publicPerson;
	
	private Date publishDate;
	

	@ManyToOne
	@JoinColumn(name="navigation_id")
	private Navigation navigation;
	
	private String navigationParentId;
	
	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public PortalDefaultType getProNoticeType() {
		return proNoticeType;
	}

	public void setProNoticeType(PortalDefaultType proNoticeType) {
		this.proNoticeType = proNoticeType;
	}

	public Long getClickCount() {
		return clickCount;
	}

	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}

	public String getPublicPerson() {
		return publicPerson;
	}

	public void setPublicPerson(String publicPerson) {
		this.publicPerson = publicPerson;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getNavigationParentId() {
		return navigationParentId;
	}

	public void setNavigationParentId(String navigationParentId) {
		this.navigationParentId = navigationParentId;
	}
	
	
}
