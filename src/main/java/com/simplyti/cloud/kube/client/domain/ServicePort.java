package com.simplyti.cloud.kube.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServicePort {
	
	private final String name;
	private final Integer port;
	private final Protocol protocol;
	private final Object targetPort;
	
	
	public static ServicePort port(int port) {
		return new ServicePort(null, port, null, null);
	}
	
	public static ServicePort port(int port,String name) {
		return new ServicePort(name, port, null, null);
	}
	
	public static ServicePort port(int port,String name,Protocol protocol) {
		return new ServicePort(name, port, protocol, null);
	}

	public static ServicePort toTarget(int port, int targetPort) {
		return new ServicePort(null, port, null, targetPort);
	}

}
