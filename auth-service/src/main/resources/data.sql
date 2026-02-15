-- =========================================
-- CLEAN RESET USERS TABLE (DEV SAFE)
-- =========================================

-- Drop table and sequence if they exist
DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS users_id_seq CASCADE;

-- =========================================
-- CREATE TABLE WITH AUTO-INCREMENT ID
-- =========================================

CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

-- =========================================
-- INSERT DEFAULT ADMIN USER
-- Password = password123 (BCrypt encoded)
-- =========================================

INSERT INTO users (email, password, role)
VALUES (
           'testuser@test.com',
           '$2b$12$7hoRZfJrRKD2nIm2vHLs7OBETy.LWenXXMLKf99W8M4PUwO6KB7fu',
           'ADMIN'
       );

-- =========================================
-- VERIFY
-- =========================================

SELECT * FROM users;
