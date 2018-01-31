CREATE TABLE social(
  socialId INT(10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  logoUrl VARCHAR(256) NOT NULL,
  socialUrl VARCHAR(256) NOT NULL,
  CONSTRAINT social_pk PRIMARY KEY (socialId)
);

INSERT INTO social (name,logoUrl,socialUrl) 
VALUES('Google Plus','gplus.png','https://plus.google.com');
