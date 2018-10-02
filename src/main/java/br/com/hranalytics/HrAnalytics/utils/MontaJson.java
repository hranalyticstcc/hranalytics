package br.com.hranalytics.HrAnalytics.utils;

import java.util.List;

public class MontaJson {
	
	public String montaJsonStringBuffer(List<String> tweets){
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"contentItems\":[");
		
		for(int i=0;i<tweets.size();i++) {
			if(i == tweets.size() -1) {
				sb.append("{");
				sb.append("\"content\": \"" + tweets.get(i) + "\"");
				sb.append("}");
			}else {
				sb.append("{");
				sb.append("\"content\": \"" + tweets.get(i) + "\"");
				sb.append("}");
				sb.append(",");
			}
		}
		
		sb.append("]}");
				
		return sb.toString();
	}

}
