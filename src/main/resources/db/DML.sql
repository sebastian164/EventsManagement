-- Insert roles
INSERT INTO roles (name) VALUES
('Administrador'),
('Organizador'),
('Asistente'),
('Patrocinador');

-- Insert companies
INSERT INTO companies (name, contact_email, phone) VALUES
('Empresa A', 'contacto@empresaa.com', '3001234567'),
('Empresa B', 'contacto@empresab.com', '3007654321'),
('Empresa C', 'contacto@empresac.com', '3009876543');

-- Insert images
INSERT INTO images (path, alt_text) VALUES
('/images/event1.jpg', 'Evento 1'),
('/images/event2.jpg', 'Evento 2'),
('/images/event3.jpg', 'Evento 3');

-- Insert users
INSERT INTO users (username, password, email, company_id, role_id, profile_image_id) VALUES
('usuario1', 'hashed_password_1', 'usuario1@mail.com', 1, 1, 1),
('usuario2', 'hashed_password_2', 'usuario2@mail.com', 2, 2, 2),
('usuario3', 'hashed_password_3', 'usuario3@mail.com', 1, 3, 3);

-- Insert locations
INSERT INTO locations (name, address, latitude, longitude) VALUES
('Centro de Eventos Tunja', 'Calle 10 # 5-15, Tunja', 5.5375, -73.3672),
('Parque Principal', 'Carrera 6 # 7-45, Tunja', 5.5461, -73.3678),
('Auditorio Municipal', 'Calle 19 # 10-15, Tunja', 5.5580, -73.3721);

-- Insert events
INSERT INTO events (name, date, location_id, description) VALUES
('Feria de la Cultura', '2024-10-15 10:00:00', 1, 'Un evento cultural que celebra la diversidad de Tunja.'),
('Concierto de Música Andina', '2024-10-20 18:00:00', 2, 'Concierto al aire libre con artistas locales.'),
('Congreso de Innovación', '2024-10-25 09:00:00', 3, 'Un congreso que reúne a líderes en tecnología e innovación.');

-- Insert event_companies
INSERT INTO event_companies (event_id, company_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 3);

-- Insert event_attendees
INSERT INTO event_attendees (event_id, user_id, attended) VALUES
(1, 1, TRUE),
(1, 2, FALSE),
(2, 1, TRUE),
(3, 3, FALSE);

-- Insert event_images
INSERT INTO event_images (event_id, image_id, is_primary) VALUES
(1, 1, TRUE),
(2, 2, TRUE),
(3, 3, TRUE);