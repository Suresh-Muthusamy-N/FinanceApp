INSERT INTO users (
    id,
    name,
    email,
    password,
    account_type,
    created_at,
    updated_at,
    mobile_number,
    mobile_verified,
    email_verified,
    is_active,
    last_login
) VALUES (
    gen_random_uuid(),                      -- id (UUID)
    'John Doe',                             -- name
    'john.doe@example.com',                 -- email
    crypt('MySecureP@ssw0rd', gen_salt('bf')), -- password (hashed)
    'ADMIN',                                -- account_type
    '2025-03-15 09:30:00',                  -- created_at
    '2025-03-18 12:45:00',                  -- updated_at
    '1234567890',                           -- mobile_number
    TRUE,                                   -- mobile_verified
    TRUE,                                   -- email_verified
    FALSE,                                  -- is_active
    '2025-03-19 10:00:00'                   -- last_login
);
