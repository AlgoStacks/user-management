CREATE TABLE user_management
(
    user_id     INTEGER,
    name        VARCHAR,

    PRIMARY KEY(user_id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE user_management To as_app
