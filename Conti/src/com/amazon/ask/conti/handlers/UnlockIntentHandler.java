package com.amazon.ask.conti.handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazon.ask.conti.model.Constants;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class UnlockIntentHandler implements RequestHandler {

	private static String coGrade;
	@Override
	public boolean canHandle(HandlerInput input) {
		// TODO Auto-generated method stub
		return input.matches(Predicates.intentName("UnlockIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String ClientId = "client_id"; // 아이디
		String ClientSecret = "client_secret"; // 패스워드

		String url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=종로구&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey=ASdKuVjkdysrEL8dzvNt42La%2FIK4CMBpvstNs8dpPBmiQbMve3j1ArFm%2BlbpHvLP4xRjX6aZqAcz3JPw7O8V5w%3D%3D&ver=1.3&_returnType=json";

		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestProperty("Content-Type", "application/json");
			// conn.setDoOutput(true); //post방식으로 할것인지.
			conn.setRequestMethod("GET");
			System.out.println("Response code: " + conn.getResponseCode());
			/*
			 * conn.setRequestProperty("X-*****-Client-Id", ClientId); // header 에 값 셋팅
			 * conn.setRequestProperty("X-*****-Client-Secret", ClientSecret); // header 에 값
			 * 셋팅
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			// BufferedReader 변수명 = new BufferedReader(new FileReader("파일명.확장자"))
			// BufferedReader 변수명 = new BufferedReader(new InputStreamReader(System.in))

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString()); // 결과, json결과를 parser하여 처리

			inputLine = response.toString();

			JSONParser parser = new JSONParser();
			Object object = parser.parse(inputLine);
			JSONObject jsonObject = (JSONObject) object;
			
			JSONArray array = (JSONArray) jsonObject.get("list");
			JSONObject result = (JSONObject) array.get(0);
			coGrade = (String) result.get("coGrade");
			System.out.println("result : " + coGrade);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input.getResponseBuilder().withSpeech(Constants.UNLOCK_MESSAGE + coGrade)
				.withReprompt(Constants.UNLOCK_HELP_MESSAGE)
				// .withSimpleCard("HelloWorld", speechText)
				.build();
	}

	public static void main(String[] args) {

/*		String ClientId = "client_id"; // 아이디
		String ClientSecret = "client_secret"; // 패스워드

		String url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=종로구&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey=ASdKuVjkdysrEL8dzvNt42La%2FIK4CMBpvstNs8dpPBmiQbMve3j1ArFm%2BlbpHvLP4xRjX6aZqAcz3JPw7O8V5w%3D%3D&ver=1.3&_returnType=json";

		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			conn.setRequestProperty("Content-Type", "application/json");
			// conn.setDoOutput(true); //post방식으로 할것인지.
			conn.setRequestMethod("GET");
			System.out.println("Response code: " + conn.getResponseCode());
			
			 * conn.setRequestProperty("X-*****-Client-Id", ClientId); // header 에 값 셋팅
			 * conn.setRequestProperty("X-*****-Client-Secret", ClientSecret); // header 에 값
			 * 셋팅
			 
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			// BufferedReader 변수명 = new BufferedReader(new FileReader("파일명.확장자"))
			// BufferedReader 변수명 = new BufferedReader(new InputStreamReader(System.in))

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString()); // 결과, json결과를 parser하여 처리

			inputLine = response.toString();

			JSONParser parser = new JSONParser();
			Object object = parser.parse(inputLine);
			JSONObject jsonObject = (JSONObject) object;
			
			JSONArray array = (JSONArray) jsonObject.get("list");
			JSONObject result = (JSONObject) array.get(0);
			coGrade = (String) result.get("coGrade");
			System.out.println("result : " + coGrade);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
}

/*
 * String url = "http://www.google.com/search?q=mkyong";
 * 
 * URL obj = new URL(url); HttpURLConnection con = (HttpURLConnection)
 * obj.openConnection();
 * 
 * // optional default is GET con.setRequestMethod("GET");
 * 
 * //add request header 헤더를 만들어주는것. con.setRequestProperty("User-Agent",
 * "Chrome/version"); con.setRequestProperty("Accept-Charset", "UTF-8");
 * con.setRequestProperty("Content-Type", "text/plain; charset=utf-8"); int
 * responseCode = con.getResponseCode();
 * System.out.println("\nSending 'GET' request to URL : " + url);
 * System.out.println("Response Code : " + responseCode);
 * 
 * BufferedReader in = new BufferedReader( new
 * InputStreamReader(con.getInputStream())); String inputLine; StringBuffer
 * response = new StringBuffer();
 * 
 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
 * in.close();
 * 
 * //print result System.out.println(response.toString());
 */