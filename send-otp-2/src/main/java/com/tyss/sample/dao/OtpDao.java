package com.tyss.sample.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.sample.dto.Users;
import com.tyss.sample.utility.Utility;

@Repository
public class OtpDao implements DaoInf {

	@Autowired
	Utility utility;
	public StringBuffer register(Users user) {
		EntityManager manager=utility.dbConnector();
		manager.getTransaction().begin();
		Query query = manager.createQuery("select U from Users U where U.id=:id");
		query.setParameter("id", user.getId());
		if(query.getResultList().isEmpty()) {
			manager.persist(user);
			manager.getTransaction().commit();
			String apikey="LTP8ph2fcKK6HQyHmFYDNXnZrVCzo5w3gxTQKTPZWY0tFozO1Ri324lNwLXo";
			String message=otpGenerate();
			try {
				message=URLEncoder.encode(message, "UTF-8");
			}catch(Exception e) {
				e.printStackTrace();
			}
			StringBuffer response=send(message, user.getNumber(),apikey);
			return response;
		}
		return null;

	}

	private String otpGenerate() {
		Random rand=new Random();
		String otp="Hi, This is your One Time Password "+rand.nextInt()+" This will expire within 10 minutes";
		return otp;

	}

	public static StringBuffer send(String message, String number, String apikey) {
		StringBuffer response=new StringBuffer();
		String senderId="TXTIND";
		String route="v3";
		String url="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+senderId+"&message="+message+"&route="+route+"&numbers="+number;
		try {
			URL myurl=new URL(url);
			HttpURLConnection connection=(HttpURLConnection) myurl.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			connection.setRequestProperty("cache-control", "no-cache");
			int responseCode=connection.getResponseCode();
			String r=connection.getResponseMessage();
			System.out.println(r);
			System.out.println(responseCode);

			BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while(true) {
				String line=br.readLine();
				if(line==null)
					break;
				response.append(line);
			}

			System.out.println(response);

		}catch(Exception e) {
			e.printStackTrace();
		}

		return response;

	}

}


Gitlab account :  TY_sushma