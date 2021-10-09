package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ServerOverrideDecision database table.
 * 
 */
@Entity
@Table(name = "ServerOverrideDecisions")
@NamedQuery(name = "ServerOverrideDecision.findAll", query = "SELECT a FROM ServerOverrideDecision a")
public class ServerOverrideDecision implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serverOverrideDecisionID;

    private int serverID;

    private int assetTypeConsistencyCheckID;

    public ServerOverrideDecision() {
    }

    public int getServerOverrideDecisionID() {
	return serverOverrideDecisionID;
    }

    public void setServerOverrideDecisionID(int serverOverrideDecisionID) {
	this.serverOverrideDecisionID = serverOverrideDecisionID;
    }

    public int getServerID() {
	return serverID;
    }

    public void setServerID(int serverID) {
	this.serverID = serverID;
    }

    public int getAssetTypeConsistencyCheckID() {
	return assetTypeConsistencyCheckID;
    }

    public void setAssetTypeConsistencyCheckID(int assetTypeConsistencyCheckID) {
	this.assetTypeConsistencyCheckID = assetTypeConsistencyCheckID;
    }

}