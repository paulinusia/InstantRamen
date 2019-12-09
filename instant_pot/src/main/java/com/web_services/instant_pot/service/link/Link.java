package com.web_services.instant_pot.service.link;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.net.InetAddress;

public class Link {
	private static String baseDomain;
	
	private String rel;
	private String uri;
	private String mediaType;
	
	static {
		try {
			System.out.println("HITTING LINK.JAVA");
			baseDomain = InetAddress.getLocalHost().getHostAddress();
		}
		catch (Exception e) {
			baseDomain = "";
			System.out.println("Could not set base domain...");
		}
	}
	
	public Link(String rel, String uri, String mediaType) {		
		this.rel = rel;
		this.uri = this.baseDomain + uri;
		this.mediaType = mediaType;
	}
	
	public Link() {}
	
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public static String getBaseDomain() {
		return baseDomain;
	}

	public static void setBaseDomain(String baseDomain) {
		Link.baseDomain = baseDomain;
	}
		
}
