CREATE TABLE teacher (
                         id BIGSERIAL PRIMARY KEY,
                         first_name TEXT NOT NULL,
                         last_name TEXT NOT NULL
);
CREATE INDEX teacher_id_idx ON teacher (id);