-- Table for roles (pluralized)
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- Table for companies (correct spelling and pluralized)
CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255),
    phone VARCHAR(50)
);

-- Table for images (pluralized)
CREATE TABLE images (
    id SERIAL PRIMARY KEY,
    path VARCHAR(255) NOT NULL,
    alt_text VARCHAR(255),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for users (pluralized and renamed to avoid reserved keyword)
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,  -- Adjusted size for password hashes
    email VARCHAR(255) UNIQUE NOT NULL,
    company_id INT,
    role_id INT,
    profile_image_id INT,  -- For user profile image
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE SET NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE SET NULL,
    FOREIGN KEY (profile_image_id) REFERENCES images(id) ON DELETE SET NULL
);

-- Table for locations (pluralized)
CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6)
);

-- Table for events (pluralized)
CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date TIMESTAMP NOT NULL,
    location_id INT,
    description TEXT,
    FOREIGN KEY (location_id) REFERENCES locations(id) ON DELETE CASCADE
);

-- Table for event_control (consider renaming for clarity)
CREATE TABLE event_companies (
    id SERIAL PRIMARY KEY,
    event_id INT,
    company_id INT,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
);

-- Table for event_attendees (pluralized)
CREATE TABLE event_attendees (
    id SERIAL PRIMARY KEY,
    event_id INT,
    user_id INT,
    attended BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Table for event_images (pluralized)
CREATE TABLE event_images (
    id SERIAL PRIMARY KEY,
    event_id INT,
    image_id INT,
    is_primary BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    FOREIGN KEY (image_id) REFERENCES images(id) ON DELETE CASCADE
);