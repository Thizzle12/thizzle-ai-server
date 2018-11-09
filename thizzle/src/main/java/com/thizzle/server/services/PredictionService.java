package com.thizzle.server.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.thizzle.server.dto.requests.PredictNumberRq;

@Service
public class PredictionService {
	
	public void transformToImgMatrix(PredictNumberRq predictNumberRq) {
		int[][] image = new int[predictNumberRq.getCanvasHeight()][predictNumberRq.getCanvasWidth()];
		for (int i = 0; i < predictNumberRq.getCanvasHeight(); i++) {
			for (int j = 0; j < predictNumberRq.getCanvasWidth(); j++) {
				image[j][i] = 255;
			}
		}
		for (int i = 0; i < predictNumberRq.getxPositions().size(); i++) {
			image[predictNumberRq.getxPositions().get(i)][predictNumberRq.getyPositions().get(i)] = 0;
		}
		
		
		for (int i = 0; i < predictNumberRq.getCanvasHeight(); i++) {
			for (int j = 0; j < predictNumberRq.getCanvasWidth(); j++) {
				if(image[j][i] == 255) {
					System.out.print(" ");
				}else {
					System.out.print("#");
				}
			}
			System.out.println("");
		}
	}
	
	private void sendPost() throws Exception {

		String url = "http://localhost:8043";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "application.json");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}

}
