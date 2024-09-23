-- Insert roles
INSERT INTO roles (name) VALUES
('Event Administrator'),
('System Administrator'),
('Attendee');

select * from roles r ;

-- Insert companies (fictitious Colombian companies)
INSERT INTO companies (name, contact_email, phone) VALUES
('Eventos Innovadores S.A.S.', 'contacto@eventosinnovadores.com', '301-123-4567'),
('Soluciones Creativas Ltda.', 'info@solucionescreativas.com', '302-765-4321'),
('Eventos y Congresos Colombia', 'atencion@eventosycongresos.com', '303-987-6543');

select * from companies c 

-- Insert users
INSERT INTO users (username, password, email, company_id, role_id) VALUES
('johndoe', 'password123', 'johndoe@example.com', 1, 1),
('janedoe', 'password123', 'janedoe@example.com', 2, 3),
('adminuser', 'adminpass', 'admin@example.com', 1, 2);

select * from users u ;

-- Insert locations (Tunja, Colombia)
INSERT INTO locations (name, address, latitude, longitude) VALUES
('Auditorio Metropolitano de Tunja', 'Calle 19 # 10 - 15, Tunja, Boyacá', 5.5401, -73.3673),
('Parque Principal de Tunja', 'Cra. 10 # 18-30, Tunja, Boyacá', 5.5469, -73.3670),
('Centro Comercial Unicentro Tunja', 'Av. A 3-40, Tunja, Boyacá', 5.5413, -73.3710),
('Plaza de Bolívar', 'Cra. 10, Tunja, Boyacá', 5.5474, -73.3678),
('Universidad de Boyacá', 'Km 1 Vía Tunja - Bogotá, Tunja, Boyacá', 5.5231, -73.3671);

select * from locations l ;
-- Insert events
INSERT INTO events (name, date, location_id, description) VALUES
('Tech Conference 2023', '2023-11-10 09:00:00', 1, 'Annual tech conference featuring industry leaders.'),
('Creative Workshop', '2023-11-15 14:00:00', 2, 'Hands-on workshop for creative professionals.');

select * from events e ;
-- Insert event control
INSERT INTO event_control (event_id, company_id) VALUES
(1, 1),
(2, 2);

select * from event_control ec ;

-- Insert event attendees
INSERT INTO event_attendees (event_id, user_id, attended) VALUES
(1, 1, TRUE),
(1, 2, FALSE),
(2, 3, TRUE);

select * from event_attendees ea ;

--Restart tables for database event_management
TRUNCATE TABLE event_attendees CASCADE;
TRUNCATE TABLE event_control CASCADE;
TRUNCATE TABLE events CASCADE;
TRUNCATE TABLE users CASCADE;
TRUNCATE TABLE companies CASCADE;
TRUNCATE TABLE roles CASCADE;
TRUNCATE TABLE locations CASCADE;
--Restar Sequences por table ids
ALTER SEQUENCE roles_id_seq RESTART WITH 1;
ALTER SEQUENCE companies_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE events_id_seq RESTART WITH 1;
ALTER SEQUENCE event_control_id_seq RESTART WITH 1;
ALTER SEQUENCE locations_id_seq RESTART WITH 1;
ALTER SEQUENCE event_attendees_id_seq RESTART WITH 1;
