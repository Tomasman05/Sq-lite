create table if NOT EXISTS megnevezesek(
    mid INT PRIMARY KEY AUTOINCREMENT,
    megnevezes varchar(30)
);
create table if NOT EXISTS csucsok(
    mid INT PRIMARY KEY AUTOINCREMENT,
    x INT,
    y int 
);
create table if NOT EXISTS csucsok(
    sorszam INT PRIMARY KEY AUTOINCREMENT,
    mid int,
    csid int,
    FOREIGN KEY(csid) REFERENCES csucsok(csid),
    FOREIGN KEY(mid) REFERENCES megnevezesek(csid),
);
