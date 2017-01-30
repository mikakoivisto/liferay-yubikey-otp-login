create table JGURU_YubikeyOTPKeyEntry (
	keyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	publicId VARCHAR(75) null,
	name VARCHAR(75) null
);