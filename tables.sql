
CREATE TABLE PotholeReport (
  ReportID INT(10) NOT NULL,
  StreetLoc VARCHAR(10) NOT NULL,
  Address VARCHAR(10) NOT NULL,
  RepType VARCHAR(10) NOT NULL,
  Size INT(2) NOT NULL,
  PRIMARY KEY ( ReportID )
);

CREATE TABLE WorkOrder (
  ReportID INT(10),
  StreetLoc VARCHAR(10),
  Address VARCHAR(10),
  RepType VARCHAR(10),
  Size INT(2),
  RepPriority INT(10) NOT NULL,
  EstRepairTime INT(10) NOT NULL,
  RepairStatus VARCHAR(10) NOT NULL,
  FOREIGN KEY ( ReportID ) REFERENCES PotholeReport( ReportID ),
  FOREIGN KEY ( StreetLoc ) REFERENCES PotholeReport( StreetLoc ),
  FOREIGN KEY ( Address ) REFERENCES PotholeReport( Address ),
  FOREIGN KEY ( RepType ) REFERENCES PotholeReport( RepType ),
  FOREIGN KEY ( Size ) REFERENCES PotholeReport( Size ),
);
