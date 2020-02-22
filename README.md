# smartParkingAPI
Rest API for handling requests and responses related to smart parking.


Postgres details to be made locally :

User : default postgres user
Database : smartparkingapi
Tables :

1. Parkinglot 

   Column   |         Type          | Collation | Nullable | Default 
   ------------+-----------------------+-----------+----------+---------
   id         | character varying(6)  |           | not null | 
   floor_no   | character varying(6)  |           |          | 
   status     | boolean               |           |          | 
   vehicle_no | character varying(10) |           |          | 
   duration   | integer               |           |          | 
   
   Indexes:
   "parkinglot_pkey" PRIMARY KEY, btree (id)

2. Vehicles

   Column   |         Type          | Collation | Nullable | Default 
   ------------+-----------------------+-----------+----------+---------
   vehicle_no | character varying(10) |           |          | 
   lot_name   | character varying(5)  |           |          | 
   mallid     | character varying(6)  |           |          | 
   duration   | integer               |           |          | 
