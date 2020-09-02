CREATE TABLE races (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	created_at DATETIME DEFAULT NOW(),
	updated_at DATETIME DEFAULT NOW()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE ages (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	from_months INTEGER NOT NULL,
	to_months INTEGER DEFAULT -1,
	created_at DATETIME DEFAULT NOW(),
	updated_at DATETIME DEFAULT NOW()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE buyers (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	phone_number VARCHAR(15) NOT NULL UNIQUE,
	phone_number_crypt VARCHAR(150) NOT NULL,
	farm_name VARCHAR(100),
	enable BOOL DEFAUlT TRUE,
	gta_full_name VARCHAR(300),
	gta_cpf_cnpj VARCHAR(30) UNIQUE,
	gta_address VARCHAR(150),
	gta_neighborhood VARCHAR(50),
	gta_zip BIGINT,
	gta_county VARCHAR(50),
	gta_phone_number VARCHAR(15),
	gta_state_inscrition VARCHAR(20) UNIQUE,
	created_at DATETIME DEFAULT NOW(),
	updated_at DATETIME DEFAULT NOW()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE auctions (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(300),	
	created_at DATETIME DEFAULT NOW(),
	updated_at DATETIME DEFAULT NOW()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE batches (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	auction_id BIGINT,
	race_id BIGINT,
	age_id BIGINT,
	sex INT NOT NULL,
	quantity INT NOT NULL,
	initial_offer BIGINT NOT NULL,
	target_offer BIGINT,
	video_link VARCHAR(500) NOT NULL,
	payment_deadline INT,
	is_receiving_bids BOOL,
	winning_bid BIGINT,
	created_at DATETIME DEFAULT NOW(),
	updated_at DATETIME DEFAULT NOW()	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE buyers_profiles (
   buyer_id BIGINT NOT NULL,
    profiles_id BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    
CREATE TABLE profiles (
   	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	role VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE bids (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	batch_id BIGINT,
	buyer_id BIGINT,
	bid_value BIGINT NOT NULL,
	created_at DATETIME DEFAULT NOW(),
	updated_at DATETIME DEFAULT NOW(),
	FOREIGN KEY (batch_id) REFERENCES batches(id) ON DELETE CASCADE,
	FOREIGN KEY (buyer_id) REFERENCES buyers(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE batches ADD FOREIGN KEY (auction_id) REFERENCES auctions(id);
ALTER TABLE batches ADD FOREIGN KEY (race_id) REFERENCES races(id);
ALTER TABLE batches ADD FOREIGN KEY (age_id) REFERENCES ages(id);
ALTER TABLE batches ADD FOREIGN KEY (winning_bid) REFERENCES bids(id);

ALTER TABLE buyers_profiles ADD FOREIGN KEY (profiles_id) REFERENCES profiles(id) ON DELETE CASCADE;
ALTER TABLE buyers_profiles ADD FOREIGN KEY (buyer_id) REFERENCES buyers(id) ON DELETE CASCADE ;


INSERT INTO races (name) values ('Nelorado');
INSERT INTO races (name) values ('Cruzado');
INSERT INTO races (name) values ('Nelore');
INSERT INTO races (name) values ('Cruzamento Industrial');
INSERT INTO races (name) values ('Holandês');
INSERT INTO races (name) values ('Guzerá');

INSERT INTO ages (from_months,to_months) values (0,12);
INSERT INTO ages (from_months,to_months) values (13,24);
INSERT INTO ages (from_months,to_months) values (25,36);
INSERT INTO ages (from_months,to_months) values (36,-1);

INSERT INTO auction_api.buyers (name,phone_number,phone_number_crypt,farm_name,enable,gta_full_name,gta_cpf_cnpj,gta_address,gta_neighborhood,gta_zip,gta_county,gta_phone_number,gta_state_inscrition,created_at,updated_at) VALUES 
('Jader Barcelos','+5543839681719','$2y$10$8j9ubrpRwSi9GNa4o.l5veB9/zCTFuwFWOAEzthmIa2O4qVU6hsnC','Instância Barcelos',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2020-05-19 19:25:45.000','2020-05-19 19:25:45.000');

INSERT INTO auction_api.profiles (role) VALUES ('ROLE_BUYER'),('ROLE_ADMIN');

INSERT INTO auction_api.buyers_profiles (buyer_id,profiles_id) VALUES (1,2);
INSERT INTO auction_api.buyers_profiles (buyer_id,profiles_id) VALUES (1,1);

