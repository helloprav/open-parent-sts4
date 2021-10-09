package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dispositionmethods database table.
 * 
 */
@Entity
@Table(name="DispositionMethods")
@NamedQuery(name="DispositionMethod.findAll", query="SELECT d FROM DispositionMethod d")
public class DispositionMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dispositionMethodId;

	private int methodId;

	private String methodName;

	private String methodType;

	//bi-directional many-to-one association to Assetdisposition
	@ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="AssetDispositionsId")
	private AssetDisposition assetdisposition;

	public DispositionMethod() {
	}

	public int getDispositionMethodId() {
		return this.dispositionMethodId;
	}

	public void setDispositionMethodId(int dispositionMethodId) {
		this.dispositionMethodId = dispositionMethodId;
	}

	public int getMethodId() {
		return this.methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodType() {
		return this.methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public AssetDisposition getAssetDisposition() {
		return this.assetdisposition;
	}

	public void setAssetDisposition(AssetDisposition assetDisposition) {
		this.assetdisposition = assetDisposition;
	}


}