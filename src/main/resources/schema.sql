CREATE TABLE Domains (
                         domain_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         program VARCHAR(255) NOT NULL,
                         batch INT NOT NULL,
                         capacity INT NOT NULL,
                         qualification VARCHAR(255) NOT NULL
);

CREATE TABLE Students (
                          student_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          domain_id BIGINT,
                          FOREIGN KEY (domain_id) REFERENCES Domains(domain_id)
);

CREATE TABLE Employees (
                           employee_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) UNIQUE NOT NULL,
                           password VARCHAR(255) NOT NULL
);
