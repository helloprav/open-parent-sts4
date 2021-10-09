package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the networkdevicetypes database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="NetworkDeviceTypes")
@NamedQuery(name="NetworkDeviceType.findAll", query="SELECT n FROM NetworkDeviceType n")
public class NetworkDeviceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int networkDeviceTypeID;

	private String networkDeviceTypeName;

	//bi-directional many-to-one association to NetworkDevice
	@OneToMany(mappedBy="networkdevicetype")
	private List<NetworkDevice> networkdevices;

	public NetworkDeviceType() {
	}

	public int getNetworkDeviceTypeID() {
		return this.networkDeviceTypeID;
	}

	public void setNetworkDeviceTypeID(int networkDeviceTypeID) {
		this.networkDeviceTypeID = networkDeviceTypeID;
	}

	public String getNetworkDeviceTypeName() {
		return this.networkDeviceTypeName;
	}

	public void setNetworkDeviceTypeName(String networkDeviceTypeName) {
		this.networkDeviceTypeName = networkDeviceTypeName;
	}

	public List<NetworkDevice> getNetworkdevices() {
		return this.networkdevices;
	}

	public void setNetworkdevices(List<NetworkDevice> networkdevices) {
		this.networkdevices = networkdevices;
	}

	public NetworkDevice addNetworkdevice(NetworkDevice networkdevice) {
		getNetworkdevices().add(networkdevice);
		networkdevice.setNetworkdevicetype(this);

		return networkdevice;
	}

	public NetworkDevice removeNetworkdevice(NetworkDevice networkdevice) {
		getNetworkdevices().remove(networkdevice);
		networkdevice.setNetworkdevicetype(null);

		return networkdevice;
	}

}