package APIs.requestReponseXmls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;

public class RequestResponseValidation {

	public static String responseXml = System.getProperty("user.dir") + File.pathSeparator + "src" + File.pathSeparator
			+ "test" + File.pathSeparator + "java" + File.pathSeparator + "APIs" + File.pathSeparator
			+ "requestReponseXmls" + File.pathSeparator + "Response.xml";
	public static String requestXml = System.getProperty("user.dir") + File.pathSeparator + "src" + File.pathSeparator
			+ "test" + File.pathSeparator + "java" + File.pathSeparator + "APIs" + File.pathSeparator
			+ "requestReponseXmls" + File.pathSeparator + "Request.xml";

	private boolean responseValidation() throws Exception {

		File fXmlFile = new File(responseXml);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		String msgRecieved = doc.getElementsByTagName("Message").item(0).getTextContent();
		String responseCode = doc.getElementsByTagName("Code").item(0).getTextContent();

		if (msgRecieved.equalsIgnoreCase("SUCCESS") && responseCode.equalsIgnoreCase("0")) {
			System.out.println("API hit Sucessfully");
		} else {
			throw new Exception(msgRecieved);
		}
		System.out.println(msgRecieved);
		System.out.println(responseCode);
		return true;

	}

	public boolean postRequest() throws Exception {

		File postXmlfile = new File(requestXml);
		String strURL = "http://10.67.181.30:8082/totalmanage/subscriberapi";
		PostMethod post = new PostMethod(strURL);
		try {
			post.setRequestEntity(new InputStreamRequestEntity(new FileInputStream(postXmlfile), postXmlfile.length()));
			post.setRequestHeader("Content-type", "text/xml; charset=ISO-8859-1");
			HttpClient httpclient = new HttpClient();

			int result = httpclient.executeMethod(post);
			System.out.println("Response status code: " + result);
			System.out.println("Response body: ");
			System.out.println(post.getResponseBodyAsString());

			File file = new File(responseXml);
			FileOutputStream fop = new FileOutputStream(file);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = post.getResponseBodyAsString().getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}

		return responseValidation();

	}
}
