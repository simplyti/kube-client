package com.simplyti.cloud.kube.client.services;

import java.util.Collection;

import com.jsoniter.spi.TypeLiteral;
import com.simplyti.cloud.kube.client.AbstractUpdater;
import com.simplyti.cloud.kube.client.InternalClient;
import com.simplyti.cloud.kube.client.JsonPatch;
import com.simplyti.cloud.kube.client.ResourceSupplier;
import com.simplyti.cloud.kube.client.domain.Service;
import com.simplyti.cloud.kube.client.domain.ServicePort;

public class ServiceUpdater extends AbstractUpdater<Service,ServiceUpdater> implements ServiceCreationBuilder<ServiceUpdater>{

	public ServiceUpdater(InternalClient client,String api,
			String namespace, String name, String resourceName, TypeLiteral<Service> resourceClass,
			ResourceSupplier<Service, ?,?> supplier) {
		super(client, api, namespace, name, resourceName, resourceClass,supplier);
	}

	public ServicePortCreationBuilder<ServiceUpdater> addPort() {
		return new ServicePortCreationBuilder<>(this);
	}
	
	public ServiceUpdater setServicePort(Collection<ServicePort> servicePorts) {
		return setServicePorts(servicePorts);
	}

	public ServiceUpdater setServicePorts(Collection<ServicePort> servicePorts) {
		this.addPatch(JsonPatch.replace("/spec/ports",servicePorts));
		return this;
	}

	public ServiceUpdater addServicePort(ServicePort servicePort) {
		this.addPatch(JsonPatch.add("/spec/ports/-",servicePort));
		return this;
	}

}
