package com.thizzle.server.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thizzle.server.ai.dataobjects.Gender;
import com.thizzle.server.ai.dataobjects.User;
import com.thizzle.server.ai.dataobjects.UserRepository;
import com.thizzle.server.configuration.DatabaseConfiguration;
import com.thizzle.server.dto.requests.LoginRq;
import com.thizzle.server.dto.requests.UserInfoRq;
import com.thizzle.server.dto.responses.LoginRs;
import com.thizzle.server.dto.responses.UserRs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private DatabaseConfiguration dbConf;
	
	@Autowired
	private UserRepository userRepo;
	
	public UserRs getUser() {
		
		return createUser();
	}
	
	private UserRs createUser() {
		UserRs newUser = new UserRs(10293, "Theis Friis", "thefir@hotmail.dk", "testOfPassword123!", Gender.MALE);
		return newUser;
	}
	
	
	public UserRs getUserViaId(String id) {
		
		return new UserRs(10294, "Theis Friis2", "thefir2@hotmail.dk", "testOfPassword123!", Gender.MALE);
	}
	
	public String createUser(UserInfoRq userInfoRq) {
		log.info("Testing of database saving");
		
		userRepo.save(new User(userInfoRq.getId(), userInfoRq.getUserName(), userInfoRq.getPassword(), userInfoRq.getEmail(), userInfoRq.getGender(), userInfoRq.getYob()));
		
		return "Ok";
	}
	
	public String createUserFile(UserInfoRq userInfoRq) {
		byte[] decodedBytes = Base64.getDecoder().decode(userInfoRq.getEmail());
		String decodedString = new String(decodedBytes);
		
		log.info("Write user to dbfile: " + dbConf.getFiledb());
		
		log.info("User with id: {}, email: {}, gender: {}", userInfoRq.getId(), decodedString, userInfoRq.getGender());
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(dbConf.getFiledb());
			bw = new BufferedWriter(fw);
			bw.write("email:" + decodedString + ", id:" + userInfoRq.getId() + ", password:" + userInfoRq.getPassword() + ", username:" + userInfoRq.getUserName() + ", gender:" + userInfoRq.getGender() + ", yob:" + userInfoRq.getYob());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return "OK";
		
	}
	
	public LoginRs getLoginInfo(LoginRq loginRq) {
		LoginRs response = null;
		FileReader in = null;
		try {
			in = new FileReader(dbConf.getFiledb());
			BufferedReader br = new BufferedReader(in);
			String dbLine = br.readLine();
		    while (dbLine != null) {
		    	
		        log.info(dbLine);
		        if(dbLine.split(", password:")[1].split(",")[0].equals(loginRq.getPassword()) &&
		        		dbLine.split(", username:")[1].split(",")[0].equals(loginRq.getUsername())) {
		        	log.info("User Exists");
		        	response = new LoginRs(UUID.fromString(dbLine.split(", id:")[1].split(",")[0]), dbLine.split(", username:")[1].split(",")[0]);
		        }
		        dbLine = br.readLine();
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		log.info("Logging in as user: {}", response.getUsername());
		
		return response;
	}

}
