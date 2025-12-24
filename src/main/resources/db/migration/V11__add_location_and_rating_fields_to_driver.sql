ALTER TABLE driver
    ADD COLUMN last_known_location_id BIGINT NULL,
    ADD COLUMN home_id BIGINT NULL,
    ADD COLUMN active_city VARCHAR(255),
    ADD COLUMN rating DOUBLE NOT NULL DEFAULT 0.00;

-- Foreign key for last known location
ALTER TABLE driver
    ADD CONSTRAINT fk_driver_last_known_location
    FOREIGN KEY (last_known_location_id)
    REFERENCES exact_location(id);

-- Foreign key for home location
ALTER TABLE driver
    ADD CONSTRAINT fk_driver_home_location
    FOREIGN KEY (home_id)
    REFERENCES exact_location(id);

-- Rating constraints (MySQL 8+)
ALTER TABLE driver
    ADD CONSTRAINT chk_driver_rating
    CHECK (rating >= 0.00 AND rating <= 5.00);
