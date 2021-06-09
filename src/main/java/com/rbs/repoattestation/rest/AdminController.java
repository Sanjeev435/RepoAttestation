package com.rbs.repoattestation.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbs.repoattestation.dto.AdminDto;
import com.rbs.repoattestation.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/attestation/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("login")
	public String login() {
		return "/adminLogin.html";
	}
	
	@GetMapping("unauthorized")
	public String unauthorized() {
		return "/unAuthorizedAdminAccess.html";
	}

	@GetMapping("check")
	public String checkForAdmin(@PathParam("loginId") String loginId, @PathParam("password") String password) {
		log.info(password);
		if (adminService.getAdminUser(loginId).isPresent()) {
			log.info("User found with Admin rights : " + loginId);
			return "/admin.html";
		} else {
			log.info("User not found for Admin rights : " + loginId);
			return "/unAuthorizedAdminAccess.html";
		}

	}
	
	@ResponseBody
	@GetMapping("view")
	public List<AdminDto> getAttestedData(@PathParam("loginId") String loginId) {
		if (adminService.getAdminUser(loginId).isPresent()) {
			return adminService.getAllAttestations();
		} else {
			log.info("User validation unseccessful | Data can't be retrived : " + loginId);
			return null;
		}

	}

}
