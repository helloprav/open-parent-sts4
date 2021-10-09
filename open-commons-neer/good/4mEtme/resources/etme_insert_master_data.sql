-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`Functions`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Functions`;

INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('CREATE_EDIT_SYSTEM_ACCESS_GROUP');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_SYSTEM_ACCESS_GROUP');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DELETE_SYSTEM_ACCESS_GROUP');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('CREATE_EDIT_USER');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_USER');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DELETE_USER');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('CREATE_EDIT_BUSINESS_ACTIVITY_ROLE');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_BUSINESS_ACTIVITY_ROLE');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DELETE_BUSINESS_ACTIVITY_ROLE');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_ASSET_WIDGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_DISCOVERY_WIDGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_MIGRATION_STATUS_WIDGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_TASK_STATUS_WIDGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('ASSET_DATA_BULK_UPLOAD');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_ASSET_MANAGEMENT');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('CREATE_EDIT_ASSET_MANAGEMENT');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('CREATE_EDIT_MIGRATION_STANDARDS');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('READ_ASSET_REPORT');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('CREATE_EDIT_MIGRATION_PLANNER');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_APP_DISCOVERY_WIDGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_APPINST_DISCOVERY_WIDGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DISPLAY_SERVER_DISCOVERY_WIGET');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_TASK_MANAGER');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_TASK_LEAD');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('GET_UPDATE_TASK_ENGINEER');
INSERT INTO `StartupMigrationEngine`.`Functions` (`FunctionName`) VALUES ('DATA_ADMIN');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`Groups`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Groups`;

INSERT INTO `StartupMigrationEngine`.`Groups` (`GroupName`, `CanEditApplications`, `CanEditServers`, `CanEditNetworks`, `UserAdmin`) VALUES ('Super Admin Group', 0, 0, 0, 1);
INSERT INTO `StartupMigrationEngine`.`Groups` (`GroupName`, `CanEditApplications`, `CanEditServers`, `CanEditNetworks`, `UserAdmin`) VALUES ('Migration Expert Group', 0, 0, 0, 0);
INSERT INTO `StartupMigrationEngine`.`Groups` (`GroupName`, `CanEditApplications`, `CanEditServers`, `CanEditNetworks`, `UserAdmin`) VALUES ('Migration Manager Group', 0, 0, 0, 0);
INSERT INTO `StartupMigrationEngine`.`Groups` (`GroupName`, `CanEditApplications`, `CanEditServers`, `CanEditNetworks`, `UserAdmin`) VALUES ('Migration Engineer Group', 0, 0, 0, 0);
INSERT INTO `StartupMigrationEngine`.`Groups` (`GroupName`, `CanEditApplications`, `CanEditServers`, `CanEditNetworks`, `UserAdmin`) VALUES ('Migration Move Group Leads', 0, 0, 0, 0);
INSERT INTO `StartupMigrationEngine`.`Groups` (`GroupName`, `CanEditApplications`, `CanEditServers`, `CanEditNetworks`, `UserAdmin`) VALUES ('Data Admin Group', 0, 0, 0, 0);
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`Users`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Users`;

INSERT INTO `StartupMigrationEngine`.`Users` (`UserName`, `FirstName`, `LastName`, `Password`, `EMail`, `GlobalAdmin`, `IsCustomer`, `Status`) VALUES ('superadmin', 'Super', 'Admin', 'b5ce773611a3cb22f8e2fb020f77d9c805e984de', 'superadmin@email.com', 1, 0, 'ACTIVE');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`UserGroups`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`UserGroups`;

INSERT INTO `StartupMigrationEngine`.`UserGroups` (`UserID`, `GroupID`) VALUES ('1', '1');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`Roles`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Roles`;

INSERT INTO `StartupMigrationEngine`.`Roles` (`RoleName`,`Description`) VALUES ('MoveGroupLead','Move Group Leads');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`AssetTypes`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`AssetTypes`;

INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`AssetTemplateFileName`,`QuestionnaireFileName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Application','Application','Application Discovery Template.xlsx','Application Questionnaire Template.xlsx',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`AssetTemplateFileName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Server','Server','Server Discovery Template.xlsx',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`AssetTemplateFileName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('StorageService','Storage Devices','Storage Devices Discovery Template.xlsx',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`AssetTemplateFileName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('NetworkDevice','Network Devices','Network Devices Discovery Template.xlsx',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('ApplicationComponent','Application Component',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('ApplicationInstance','Application Instance',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('ApplicationComponentInstance','Application Component Instance',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('BusinessService', 'Business Service',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('PhysicalServer','Physical Server',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('OtherHardware','Other Hardware',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('PaaS','Platform as a Service',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetTypes`(`AssetType`,`AssetTypeName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('VmFarm','VM Farm',1,1);
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`DataSources`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`DataSources`;

INSERT INTO `StartupMigrationEngine`.`DataSources`(`DataSourceName`,`PriorityOrderNum`) VALUES('Manual Update',1);
INSERT INTO `StartupMigrationEngine`.`DataSources`(`DataSourceName`,`PriorityOrderNum`) VALUES('Questionnaire Upload',2);
INSERT INTO `StartupMigrationEngine`.`DataSources`(`DataSourceName`,`PriorityOrderNum`) VALUES('Network Discovery',3);
INSERT INTO `StartupMigrationEngine`.`DataSources`(`DataSourceName`,`PriorityOrderNum`) VALUES('CMDB',4);
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`DiscoveryState`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`DiscoveryState`;

INSERT INTO `StartupMigrationEngine`.`DiscoveryState`(`DiscoveryStateName`,`OrderNum`,`FreezeItem`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Discovery Incomplete',1,'N',1,1);
INSERT INTO `StartupMigrationEngine`.`DiscoveryState`(`DiscoveryStateName`,`OrderNum`,`FreezeItem`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Discovery Complete',2,'N',1,1);
INSERT INTO `StartupMigrationEngine`.`DiscoveryState`(`DiscoveryStateName`,`OrderNum`,`FreezeItem`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Discovery Locked Down for Migration',3,'Y',1,1);
INSERT INTO `StartupMigrationEngine`.`DiscoveryState`(`DiscoveryStateName`,`OrderNum`,`FreezeItem`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Discovery Data in Error',4,'N',1,1);
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`MigrationScopes`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`MigrationScopes`;

INSERT INTO `StartupMigrationEngine`.`MigrationScopes`(`MigrationScopeName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('In Scope for Migration','In Scope for Migration',1,1);
INSERT INTO `StartupMigrationEngine`.`MigrationScopes`(`MigrationScopeName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Out of Scope for Migration','Out of Scope for Migration',1,1);
INSERT INTO `StartupMigrationEngine`.`MigrationScopes`(`MigrationScopeName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Created for Link','Created for Link',1,1);
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`Dispositions`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Dispositions`;

INSERT INTO `StartupMigrationEngine`.`Dispositions`(`DispositionName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Local Data Center',1,1);
INSERT INTO `StartupMigrationEngine`.`Dispositions`(`DispositionName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Public Cloud',1,1);
INSERT INTO `StartupMigrationEngine`.`Dispositions`(`DispositionName`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Private Cloud',1,1);
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`NetworkDeviceTypes`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`NetworkDeviceTypes`;

INSERT INTO `StartupMigrationEngine`.`NetworkDeviceTypes`(`NetworkDeviceTypeName`) VALUES('Router');
INSERT INTO `StartupMigrationEngine`.`NetworkDeviceTypes`(`NetworkDeviceTypeName`) VALUES('Switch');
INSERT INTO `StartupMigrationEngine`.`NetworkDeviceTypes`(`NetworkDeviceTypeName`) VALUES('Firewall');
INSERT INTO `StartupMigrationEngine`.`NetworkDeviceTypes`(`NetworkDeviceTypeName`) VALUES('Load Balancer');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`MigrationComplexities`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`MigrationComplexities`;

INSERT INTO `StartupMigrationEngine`.`MigrationComplexities`(`MigrationComplexityName`,`Description`) VALUES('Low','Low Complexity');
INSERT INTO `StartupMigrationEngine`.`MigrationComplexities`(`MigrationComplexityName`,`Description`) VALUES('Medium','Medium Complexity');
INSERT INTO `StartupMigrationEngine`.`MigrationComplexities`(`MigrationComplexityName`,`Description`) VALUES('High','High Complexity');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`SLAs`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`SLAs`;

INSERT INTO `StartupMigrationEngine`.`SLAs`(`SLAName`,`RTOMinutes`,`RPOMinutes`,`AvailabilityPercent`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Gold',60,120,90,1,1);
INSERT INTO `StartupMigrationEngine`.`SLAs`(`SLAName`,`RTOMinutes`,`RPOMinutes`,`AvailabilityPercent`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Silver',120,180,80,1,1);
INSERT INTO `StartupMigrationEngine`.`SLAs`(`SLAName`,`RTOMinutes`,`RPOMinutes`,`AvailabilityPercent`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Bronze',180,240,70,1,1);
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`SupportStatus`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`SupportStatus`;

INSERT INTO `StartupMigrationEngine`.`SupportStatus`(`SupportStatusName`) VALUES ('Active');
INSERT INTO `StartupMigrationEngine`.`SupportStatus`(`SupportStatusName`) VALUES ('Expired');
INSERT INTO `StartupMigrationEngine`.`SupportStatus`(`SupportStatusName`) VALUES ('Internally Supported');
INSERT INTO `StartupMigrationEngine`.`SupportStatus`(`SupportStatusName`) VALUES ('No Support Available');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`Environments`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Environments`;

INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Development','Development region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Production','Production region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Disaster Recovery','Disaster Recovery region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Pre Production','Pre Production region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Reserved for future use','Reserved for future use region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('XPR2','XPR2 region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Test/Production','Test/Production region',1,1);
INSERT INTO `StartupMigrationEngine`.`Environments`(`EnvironmentName`,`Description`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Preproduction-test','Preproduction-test region',1,1);
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`AssetTypeConsistencyChecks`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`AssetTypeConsistencyChecks`;

INSERT INTO `StartupMigrationEngine`.`AssetTypeConsistencyChecks`(`AsssetTypeID`,`ConsistencyCheckSP`,`ConsistencyCheckName`,`ConsistencyCheckgMsg`) VALUES (1,'SP_ServerEnvironmentMix','Mix Environment Check','Asset has a mix of environments(Ex: Production/Non Production).');
INSERT INTO `StartupMigrationEngine`.`AssetTypeConsistencyChecks`(`AsssetTypeID`,`ConsistencyCheckSP`,`ConsistencyCheckName`,`ConsistencyCheckgMsg`) VALUES (2,'SP_ServerEnvironmentMix','Mix Environment Check','Asset has a mix of environments(Ex: Production/Non Production).');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`VMHypervisorTypes`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`VMHypervisorTypes`;

INSERT INTO `StartupMigrationEngine`.`VMHypervisorTypes` (`VMHypervisorTypeName`) VALUES ('Type 1 Bare Metal');
INSERT INTO `StartupMigrationEngine`.`VMHypervisorTypes` (`VMHypervisorTypeName`) VALUES ('Type 2 OS');
commit;

-- -------------------------------------------------------
-- Table `StartupMigrationEngine`.`ServerClusterTypes`
-- -------------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`ServerClusterTypes`;

INSERT INTO `StartupMigrationEngine`.`ServerClusterTypes` (`ServerClusterTypeName`) VALUES ('Load Balancing');
INSERT INTO `StartupMigrationEngine`.`ServerClusterTypes` (`ServerClusterTypeName`) VALUES ('Vertical');
INSERT INTO `StartupMigrationEngine`.`ServerClusterTypes` (`ServerClusterTypeName`) VALUES ('Horizontal');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`AssetCustomFields`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`AssetCustomFields`;

INSERT INTO `StartupMigrationEngine`.`AssetCustomFields`(`AssetTableName`,`EnableCustomField`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Applications','N',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetCustomFields`(`AssetTableName`,`EnableCustomField`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('ApplicationComponents','N',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetCustomFields`(`AssetTableName`,`EnableCustomField`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('Servers','N',1,1);
INSERT INTO `StartupMigrationEngine`.`AssetCustomFields`(`AssetTableName`,`EnableCustomField`,`CreatedByUserID`,`LastUpdatedByUserID`) VALUES('PhysicalServers','N',1,1);
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`OtherHardwareTypes`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`OtherHardwareTypes`;

INSERT INTO `StartupMigrationEngine`.`OtherHardwareTypes`(`OtherHardwareTypeName`) VALUES('Power Unit');
INSERT INTO `StartupMigrationEngine`.`OtherHardwareTypes`(`OtherHardwareTypeName`) VALUES('Cooling Unit');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`SanLunTypes`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`SanLunTypes`;

INSERT INTO `StartupMigrationEngine`.`SanLunTypes`(`SanLunTypeName`) VALUES('Fibre');
INSERT INTO `StartupMigrationEngine`.`SanLunTypes`(`SanLunTypeName`) VALUES('iSCSI');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`StorageTypes`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`StorageTypes`;

INSERT INTO `StartupMigrationEngine`.`StorageTypes`(`StorageTypeName`) VALUES('SAN');
INSERT INTO `StartupMigrationEngine`.`StorageTypes`(`StorageTypeName`) VALUES('NAS');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`Recurrances`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`Recurrances`;

INSERT INTO `StartupMigrationEngine`.`Recurrances`(`RecurranceName`) VALUES ('Daily');
INSERT INTO `StartupMigrationEngine`.`Recurrances`(`RecurranceName`) VALUES ('Weekly');
INSERT INTO `StartupMigrationEngine`.`Recurrances`(`RecurranceName`) VALUES ('Monthly');
INSERT INTO `StartupMigrationEngine`.`Recurrances`(`RecurranceName`) VALUES ('Quarterly');
INSERT INTO `StartupMigrationEngine`.`Recurrances`(`RecurranceName`) VALUES ('Yearly');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`CCInstances`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`CCInstances`;

INSERT INTO `StartupMigrationEngine`.`CCInstances` (`View`, `ReferenceField`, `URL`) VALUES ('GetTargets', 'api/Targets/1', 'http://10.184.43.126:8080/CloudConveyor/');
INSERT INTO `StartupMigrationEngine`.`CCInstances` (`View`, `ReferenceField`, `URL`) VALUES ('GetMigrationMethods', 'api/MigrationMethods/1', 'http://10.184.43.126:8080/CloudConveyor/');
INSERT INTO `StartupMigrationEngine`.`CCInstances` (`View`, `ReferenceField`, `URL`) VALUES ('GetTransformationMethods', 'api/TransformationMethods/1', 'http://10.184.43.126:8080/CloudConveyor/');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`ChangeControlDecisions`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`ChangeControlDecisions`;

INSERT INTO `StartupMigrationEngine`.`ChangeControlDecisions`(`ChangeControlDecisionName`) VALUES ('GO');
INSERT INTO `StartupMigrationEngine`.`ChangeControlDecisions`(`ChangeControlDecisionName`) VALUES ('NO-GO');
INSERT INTO `StartupMigrationEngine`.`ChangeControlDecisions`(`ChangeControlDecisionName`) VALUES ('Decision Pending');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`BusinessCriticality`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`BusinessCriticality`;

INSERT INTO `StartupMigrationEngine`.`BusinessCriticality`(`BusinessCriticalityName`) VALUES ('Low');
INSERT INTO `StartupMigrationEngine`.`BusinessCriticality`(`BusinessCriticalityName`) VALUES ('Medium');
INSERT INTO `StartupMigrationEngine`.`BusinessCriticality`(`BusinessCriticalityName`) VALUES ('High');
commit;

-- -----------------------------------------------------
-- Table `StartupMigrationEngine`.`TaskStatus`
-- -----------------------------------------------------
DELETE FROM `StartupMigrationEngine`.`TaskStatus`;

INSERT INTO `StartupMigrationEngine`.`TaskStatus` (`TaskStatusName`) VALUES ('In Progress');
INSERT INTO `StartupMigrationEngine`.`TaskStatus` (`TaskStatusName`) VALUES ('At Risk');
INSERT INTO `StartupMigrationEngine`.`TaskStatus` (`TaskStatusName`) VALUES ('Complete');
commit;
