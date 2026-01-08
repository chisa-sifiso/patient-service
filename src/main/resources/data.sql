DROP TABLE IF EXISTS patient;

CREATE TABLE patient (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         address VARCHAR(255) NOT NULL,
                         date_of_birth DATE NOT NULL,
                         register_date DATE NOT NULL
);

INSERT INTO patient (name, email, address, date_of_birth, register_date)
VALUES
    ('Sifiso Msiza', 'sifiso.msiza@gmail.com', 'Polokwane, Limpopo', '1999-05-14', '2026-01-01'),
    ('Thabo Nkosi', 'thabo.nkosi@gmail.com', 'Pretoria, Gauteng', '1997-11-02', '2026-01-01'),
    ('Lerato Mokoena', 'lerato.mokoena@gmail.com', 'Soweto, Johannesburg', '2001-03-21', '2026-01-01'),
    ('Ayanda Zulu', 'ayanda.zulu@gmail.com', 'Durban, KwaZulu-Natal', '1998-07-09', '2026-01-01'),
    ('Kagiso Molefe', 'kagiso.molefe@gmail.com', 'Mahikeng, North West', '1996-12-30', '2026-01-01'),
    ('Naledi Phiri', 'naledi.phiri@gmail.com', 'Gaborone Road, Limpopo', '2000-01-18', '2026-01-01'),
    ('Tshepo Dlamini', 'tshepo.dlamini@gmail.com', 'Mbombela, Mpumalanga', '1995-09-25', '2026-01-01'),
    ('Refilwe Khumalo', 'refilwe.khumalo@gmail.com', 'Pietermaritzburg, KZN', '2002-04-11', '2026-01-01'),
    ('Musa Nene', 'musa.nene@gmail.com', 'Richards Bay, KZN', '1999-08-03', '2026-01-01'),
    ('Zanele Sithole', 'zanele.sithole@gmail.com', 'Newcastle, KZN', '2001-06-27', '2026-01-01'),
    ('Karabo Morake', 'karabo.morake@gmail.com', 'Midrand, Gauteng', '1998-10-15', '2026-01-01'),
    ('Neo Pheko', 'neo.pheko@gmail.com', 'Centurion, Gauteng', '1997-02-08', '2026-01-01'),
    ('Bongani Mthembu', 'bongani.mthembu@gmail.com', 'Ulundi, KZN', '1994-11-19', '2026-01-01'),
    ('Precious Sebola', 'precious.sebola@gmail.com', 'Tzaneen, Limpopo', '2000-05-05', '2026-01-01'),
    ('Lucky Ramabulana', 'lucky.ramabulana@gmail.com', 'Thohoyandou, Limpopo', '1996-03-13', '2026-01-01');
