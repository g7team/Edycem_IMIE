CREATE TABLE contract_type (
   name VARCHAR(255),
   size ENUM('external', 'internal')
);

CREATE TABLE technical_type (
   name VARCHAR(255),
   size ENUM('current', 'noncurrent')
);

CREATE TABLE priority_status (
   name VARCHAR(255),
   size ENUM('urgent', 'normal', 'low')
);

CREATE TABLE avancement_status (
   name VARCHAR(255),
   size ENUM('on_standby', 'in_progress', 'done')
);

CREATE TABLE project (
  id int(4) PRIMARY KEY,
  society varchar(255),
  user_id int(4),
  name varchar(255)
);

CREATE TABLE project_partner (
  id int(4) PRIMARY KEY,
  project_id int(4),
  partner_id int(4)
);

CREATE TABLE information_section (
  id int(4) PRIMARY KEY,
  year year,
  priorite varchar(255),
  project varchar(255),
  site varchar(255),
  deadline varchar(255),
  objectives varchar(255),
  chaire boolean,
  confidentiality_contract boolean,
  license boolean,
  patent boolean,
  project_id int(4)
);

CREATE TABLE financial_section (
  id int(4) PRIMARY KEY,
  etude boolean,
  office_name varchar(255),
  roi float(4),
  example varchar(255),
  project_id int(4)
);

CREATE TABLE partner (
  id int(4) PRIMARY KEY,
  name varchar(255),
  financial_search boolean,
  object_of_partenariat varchar(255)
);

CREATE TABLE insurance_section (
  id int(4) PRIMARY KEY,
  society_name varchar(255),
  normalisation varchar(255),
  isvalidate boolean,
  technical boolean,
  project_id int(4)
);

CREATE TABLE activity (
  id int(4) PRIMARY KEY,
  name varchar(255),
  start_date datetime,
  end_date datetime,
  responsable varchar(255),
  progress avancement_status,
  priority priority_status
);

CREATE TABLE task (
  id int(4) PRIMARY KEY,
  name varchar(255),
  start_date datetime,
  end_date datetime,
  progress avancement_status,
  activity_id int(4)
);

CREATE TABLE confidentiality_section (
  id int(4) PRIMARY KEY,
  contrat_name varchar(255),
  name_society_carrier_of_project varchar(255),
  name_carrier_of_project varchar(255),
  patent_name varchar(255),
  contrat contract_type,
  project_id int(4)
);

CREATE TABLE contract_section (
  id int(4) PRIMARY KEY,
  license_name varchar(255),
  society_name varchar(255),
  product_deal varchar(255),
  distrib_deal varchar(255),
  project_id int(4)
);

CREATE TABLE invention_section (
  id int(4) PRIMARY KEY,
  patent_name varchar(255),
  inventor_name varchar(255),
  inpi varchar(255),
  patent_right varchar(255),
  project_id int(4)
);

CREATE TABLE codir_validation (
  id int(4) PRIMARY KEY,
  isFavorable boolean,
  holding_validation varchar(255),
  project_id int(4)
);

CREATE TABLE diffusion_section (
  id int(4) PRIMARY KEY,
  project_id int(4)
);

CREATE TABLE time_spent (
  id int(4) PRIMARY KEY,
  project_id int(4),
  task_id int(4),
  user_id int(4),
  hours double,
  entry_date datetime,
  description varchar(255)
);

CREATE TABLE user (
  id int(4) PRIMARY KEY,
  name varchar(255),
  surname varchar(255),
  mail varchar(255),
  password varchar(255)
);

ALTER TABLE project ADD FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE project_partner ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE project_partner ADD FOREIGN KEY (partner_id) REFERENCES partner (id);

ALTER TABLE information_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE financial_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE insurance_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE task ADD FOREIGN KEY (activity_id) REFERENCES activity (id);

ALTER TABLE confidentiality_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE contract_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE patent_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE codir_validation ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE diffusion_section ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE time_spent ADD FOREIGN KEY (project_id) REFERENCES project (id);

ALTER TABLE time_spent ADD FOREIGN KEY (task_id) REFERENCES task (id);

ALTER TABLE time_spent ADD FOREIGN KEY (user_id) REFERENCES users (id);