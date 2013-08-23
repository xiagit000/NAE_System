package com.boventech.gplearn.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boventech.gplearn.entity.Attachment;
import com.boventech.gplearn.service.AttachmentService;
import com.boventech.gplearn.util.FileSender;

@Controller
@RequestMapping(value="/attachment")
public class AttachmentController extends ApplicationController {

	
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping(value="/{id}/download")
	public void downloadAttachment(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response){
		Attachment attachment = attachmentService.findById(id);
		if(checkEntityEmpty(attachment)){
			try {
				response.sendRedirect("/gplearn/error/404");
			} catch (IOException e) {
			}
		}
		String localFilePath=attachment.getFilePath();
		String fileName = attachment.getFileName();
		new FileSender().downLoad(request, response, localFilePath, fileName);
	}
}
