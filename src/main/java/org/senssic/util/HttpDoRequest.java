package org.senssic.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;

/**
 * @Description: TODO(工具httpclient)
 * @author qiss
 * @date 2015年1月26日 下午4:21:22
 * @throws
 */

public class HttpDoRequest {
	private static HttpClient httpClient = new HttpClient();
	private static HttpMethod pmethod = null;
	private static HttpDoRequest hRequest = new HttpDoRequest();
	private HttpDoRequest() {
	}
	public static HttpDoRequest gethDoRequest() {
		Protocol myhttps = new Protocol("https", new ProlSocketFactory(), 443);
		Protocol.registerProtocol("https", myhttps);
		return hRequest;
	}

	public String RequestPost(String url, List<NameValuePair> pList) {
		PostMethod pmethod = getPostMethod(url);
		return Request(url, pList, pmethod);
	}

	public HttpMethod getReqRs() {
		if (pmethod != null) {
			return pmethod;
		} else {
			throw new NullPointerException("the httpmethod has not execue!");
		}

	}

	public String RequestGet(String url) {
		GetMethod pmethod = getGetMethod(url);
		return Request(url, null, pmethod);
	}

	private String Request(String url, List<NameValuePair> pList,
			HttpMethod pmethod) {
		if (pmethod instanceof PostMethod) {
			if (null != pList && pList.size() > 0) {
				((PostMethod) pmethod).setRequestBody(pList
						.toArray(new NameValuePair[pList.size()]));
			}
		}
		String value = "";
		try {
			httpClient.executeMethod(pmethod);
			// Avoid warning： Using getResponseBodyAsStream instead is
			// recommended.
			InputStream resStream = pmethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					resStream));
			StringBuilder resBuffer = new StringBuilder();
			String resTemp = "";
			while ((resTemp = br.readLine()) != null) {
				resBuffer.append(resTemp);
			}
			value = resBuffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public File RequestPostFile(String url, String filePath) {
		PostMethod pmethod = getPostMethod(url);
		try {
			httpClient.executeMethod(pmethod);
			InputStream in = pmethod.getResponseBodyAsStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			File file = new File(filePath);
			FileOutputStream fs = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = bis.read(buf);
			if (len == -1 || len == 0) {
				file.delete();
				file = null;
			}
			while (len != -1) {
				fs.write(buf, 0, len);
				len = bis.read(buf);
			}
			fs.flush();
			fs.close();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private PostMethod getPostMethod(String url) {
		pmethod = new PostMethod(url);
		return (PostMethod) useParam(pmethod);
	}

	private GetMethod getGetMethod(String url) {
		pmethod = new GetMethod(url);
		return (GetMethod) useParam(pmethod);
	}

	private HttpMethod useParam(HttpMethod pmethod) {
		pmethod.addRequestHeader("Connection", "keep-alive");
		pmethod.addRequestHeader("Cache-Control", "max-age=0");
		pmethod.addRequestHeader("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		pmethod.addRequestHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		pmethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"utf-8");
		return pmethod;
	}

}