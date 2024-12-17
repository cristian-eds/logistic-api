CREATE TABLE DELIVERY (
	id SERIAL PRIMARY KEY,
	client_id INTEGER NOT NULL,
	tax NUMERIC(10,2) NOT NULL,
	status VARCHAR(20) NOT NULL,
	order_date TIMESTAMP NOT NULL,
	completion_date TIMESTAMP,
	
	addressee_name VARCHAR(60) NOT NULL,
	addressee_street VARCHAR(255) NOT NULL,
	addressee_number VARCHAR(30) NOT NULL,
	addressee_additional_information VARCHAR(60) NOT NULL,
	addressee_district VARCHAR(30) NOT NULL,

	FOREIGN KEY (client_id) REFERENCES client(id)
		
);