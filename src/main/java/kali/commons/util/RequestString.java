package kali.commons.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

@Component
public class RequestString {
	public String getRequestBody(InputStream inputStream) throws Exception{
		StringBuilder requestBody = new StringBuilder();

		// request inputstream that is in byte format now we have to convert bytes to string json
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		while((line=bufferedReader.readLine())!=null){
			requestBody.append(line);
		}
		inputStream.close();
		return requestBody.toString();
	}

}
