/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.gplearn.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.boventech.gplearn.entity.City;

public class GetCitiesFromXml {

    public List<City> getCities(String path) throws Exception {

        FileInputStream inputStream = new FileInputStream(new File(path));

        List<City> list = new ArrayList<City>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        Element element = document.getDocumentElement();

        NodeList cityNodes = element.getElementsByTagName("province");
        for (int i = 0; i < cityNodes.getLength(); i++) {
            Element cityElement = (Element) cityNodes.item(i);
            City province = new City();
            province.setName(cityElement.getAttribute("name"));
            province.setElCode(cityElement.getAttribute("code"));
            String cities = cityElement.getAttribute("cities");
            String[] names = cities.split(" ");
            for (int j = 0; j < names.length; j++) {
                City city = new City();
                city.setName(names[j]);
                city.setElCode(String.valueOf(province.getElCode() + "-" + j));
                list.add(city);
            }
            list.add(province);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        GetCitiesFromXml oj = new GetCitiesFromXml();
        oj.getCities("src/main/resources/city.xml");
    }

}
