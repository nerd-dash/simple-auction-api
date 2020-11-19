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




