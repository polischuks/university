CREATE TABLE student (
                         id BIGSERIAL PRIMARY KEY,
                         first_name TEXT NOT NULL,
                         last_name TEXT NOT NULL
);
CREATE INDEX student_id_idx ON student (id);