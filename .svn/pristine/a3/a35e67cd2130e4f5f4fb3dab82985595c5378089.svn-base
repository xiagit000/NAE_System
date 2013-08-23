package com.boventech.gplearn.listener;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.entity.LearnLevel;
import com.boventech.gplearn.entity.LearnSpeacialty;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.entity.User.UserType;
import com.boventech.gplearn.exception.UserInfoSendCASFaildException;
import com.boventech.gplearn.service.LearnLevelService;
import com.boventech.gplearn.service.LearnSpeacialtyService;
import com.boventech.gplearn.service.UserService;

@Service
@Transactional
@Scope("singleton")
public class ApplicationInitiallizer  implements ApplicationListener<ContextRefreshedEvent> {

	private static final String DEFAULT_SYSTEM_LOGINNAME="zjyfxladministrator";
	
	private static final String DEFAULT_SYSTEM_PASSWORD="123456";
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationInitiallizer.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LearnLevelService learnLevelService;
	
	@Autowired
	private LearnSpeacialtyService learnSpeacialtyService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		createDefaultSystemUser();
		createDefaultlearnLevel();
		createDefaultlearnSpeacialty();
	}

	private void createDefaultlearnSpeacialty() {
		InputStream is = ApplicationInitiallizer.class.getClassLoader().getResourceAsStream("defaultLearnSpeacialty.xml");
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = domfac.newDocumentBuilder();
			Document doc = builder.parse(is);
			Element element = doc.getDocumentElement();
			NodeList learnSpeacialtyList = element.getElementsByTagName("LearnSpeacialty");
			if(null!=learnSpeacialtyList){
				for(int i =0;i<learnSpeacialtyList.getLength();i++){
					Node node = learnSpeacialtyList.item(i);
					if(node != null && node.getNodeType() == Node.ELEMENT_NODE){
						String learnSpeacialtyName=node.getAttributes().getNamedItem("name").getNodeValue();
						saveLearnSpeacialty(learnSpeacialtyName);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void createDefaultlearnLevel() {
		InputStream is = ApplicationInitiallizer.class.getClassLoader().getResourceAsStream("defaultLearnLevel.xml");
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = domfac.newDocumentBuilder();
			Document doc  = builder.parse(is);
			Element element = doc.getDocumentElement();
			NodeList learnLevelList=element.getChildNodes();
			if(null!=learnLevelList){
				for(int i =0;i<learnLevelList.getLength();i++){
					Node node = learnLevelList.item(i);
					if(node != null && node.getNodeType() == Node.ELEMENT_NODE){
						String learnLevelName=node.getAttributes().getNamedItem("name").getNodeValue();
						saveLearnLevel(learnLevelName);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createDefaultSystemUser() {
		if(!userService.checkEntityExsitByLoginName(DEFAULT_SYSTEM_LOGINNAME)){
			User user = new User();
			user.setActive(true);
			user.setLoginName(DEFAULT_SYSTEM_LOGINNAME);
			user.setPassword(new BASE64Encoder().encode(DEFAULT_SYSTEM_PASSWORD.getBytes()));
			user.setRealName("admin");
			user.setUserType(UserType.System_Administrator);
			try {
				userService.saveUser(user);
			} catch (UserInfoSendCASFaildException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
	private void saveLearnLevel(String learnLevelName){
		if(!learnLevelService.checkExsit(learnLevelName)){
			LearnLevel learnLevel = new LearnLevel();
			learnLevel.setActive(true);
			learnLevel.setName(learnLevelName);
			learnLevelService.save(learnLevel);
		}
	}
	
	private void saveLearnSpeacialty(String learnSpeacialtyName){
		if(!learnSpeacialtyService.checkExsit(learnSpeacialtyName)){
			LearnSpeacialty learnSpeacialty = new LearnSpeacialty();
			learnSpeacialty.setActive(true);
			learnSpeacialty.setName(learnSpeacialtyName);
			learnSpeacialtyService.save(learnSpeacialty);
		}
	}

}
