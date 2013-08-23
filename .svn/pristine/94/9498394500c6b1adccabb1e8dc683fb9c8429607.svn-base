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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import sun.misc.BASE64Encoder;

import com.boventech.gplearn.entity.Constants;

public class DataPusher {

    private String postUrl = LoadProperties.getProperty(Constants.STUDY_PLATFORM_URL);
    private HttpPost post = null;

    public DataPusher(String url) {
        this.postUrl += url;
        post = new HttpPost(postUrl);
    }

    public boolean push() throws IllegalStateException, IOException {
        DefaultHttpClient defaultClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(postUrl);
        String account = LoadProperties.getProperty(Constants.STUDY_PLATFORM_X_ACCOUNT);
        String secret = LoadProperties.getProperty(Constants.STUDY_PLATFORM_X_SECRET);
        BASE64Encoder encoder = new BASE64Encoder();
        post.setHeader(Constants.STUDY_PLATFORM_X_ACCOUNT, encoder.encode(account.getBytes()));
        post.setHeader(Constants.STUDY_PLATFORM_X_SECRET, encoder.encode(secret.getBytes()));
        HttpResponse response = defaultClient.execute(post);
        String json = translateInputStreamToString(response.getEntity().getContent());
        Integer statusCode = response.getStatusLine().getStatusCode();
        System.out.println("________________________" + json + "___________" + statusCode + "____________");
        post.abort();
        if (statusCode == 200) {
            return true;
        }
        return false;
    }

    public void setData(String key, String value) {
        post.setHeader(key, value);
    }

    private static String translateInputStreamToString(InputStream is) {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
