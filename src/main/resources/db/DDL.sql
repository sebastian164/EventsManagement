-- Table for roles
-- This table stores different user roles in the system (e.g., event administrators, system administrators).
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Table for companies
-- This table stores information about companies that can manage events.
CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255),
    phone VARCHAR(50)
);

-- Table for users
-- This table stores user information, including their associated company and role.
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    company_id INT,
    role_id INT,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE SET NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE SET NULL
);

-- Table for events
-- This table stores details about events, including name, date, location, and description.
CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date TIMESTAMP NOT NULL,
    location_id INT,
    description TEXT,
    FOREIGN KEY (location_id) REFERENCES locations(id) ON DELETE CASCADE
);

-- Table for event control
-- This table manages the association between events and the companies that control them.
CREATE TABLE event_control (
    id SERIAL PRIMARY KEY,
    event_id INT,
    company_id INT,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
);

-- Table for locations
-- This table stores information about event locations, including name, address, and geographical coordinates.
CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6)
);

-- Table for event attendees
-- This table stores information about users who attend events, 
-- including their attendance status. Each record links a user to an event 
-- and indicates whether they attended the event or not.
CREATE TABLE event_attendees (
    id SERIAL PRIMARY KEY,
    event_id INT,
    user_id INT,
    attended BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
