
CREATE TABLE song(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) DEFAULT NULL,
  fileType VARCHAR(50) DEFAULT NULL,
   byteData VARBINARY(25005)
);


  