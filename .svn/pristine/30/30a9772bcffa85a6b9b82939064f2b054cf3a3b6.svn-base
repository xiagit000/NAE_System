package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 学科 模型
 * 
 *
 */
@Entity
@Table(name="discipline")
public class Discipline implements Serializable{

	private static final long serialVersionUID = 1238718201657679759L;
	
	/**
	 * 培训范围
	 * GP 国培
	 * Non_GP 非国培
	 *
	 */
	public enum LearnRange{
		GP,Non_GP
	}
	
	
	/**
	 * 编号
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * 培训层次
	 */
	@ManyToOne
	@JoinColumn(name="learnlevel_id")
	private LearnLevel learnLevel;
	
	/**
	 * 培训专业
	 */
	@ManyToOne
	@JoinColumn(name="learnspeacialty_id")
	private LearnSpeacialty learnSpeacialty;
	
	/**
	 * 学科代码
	 */
	private String code;
	
	/**
	 * 培训范围
	 */
	@Enumerated(EnumType.STRING)
	private LearnRange learnRange;
	
	@ManyToOne
	@JoinColumn(name="personincharge_id")
	private User personInCharge;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LearnLevel getLearnLevel() {
		return learnLevel;
	}

	public void setLearnLevel(LearnLevel learnLevel) {
		this.learnLevel = learnLevel;
	}

	public LearnSpeacialty getLearnSpeacialty() {
		return learnSpeacialty;
	}

	public void setLearnSpeacialty(LearnSpeacialty learnSpeacialty) {
		this.learnSpeacialty = learnSpeacialty;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LearnRange getLearnRange() {
		return learnRange;
	}

	public void setLearnRange(LearnRange learnRange) {
		this.learnRange = learnRange;
	}

	public User getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(User personInCharge) {
		this.personInCharge = personInCharge;
	}

	
	
	
}
