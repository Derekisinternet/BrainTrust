CREATE TABLE if not exists eeg_reading (
  reading_id bigint auto_increment primary key,
  session_id bigint,
  time_stamp varchar(255),
  signal int(3),
  attention int(6),
  meditation int(6),
  delta int(6),
  theta int(6),
  low_alpha int(6),
  high_alpha int(6),
  low_beta int(6),
  high_beta int(6),
  low_gamma int(6),
  high_gamma int(6),
  PRIMARY KEY (reading_id)
);

create sequence if not exists eeg_reading_seq;

CREATE TABLE if not exists sessions (
  session_id bigint auto_increment primary key,
  PRIMARY KEY (session_id)
);

create sequence if not exists session_seq;