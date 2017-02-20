--for testing purposes
--DELETE FROM eeg_reading;
insert into eeg_reading (session_id, reading_id, time_stamp, signal, attention, meditation, delta, theta, low_alpha, high_alpha, low_beta, high_beta, low_gamma, high_gamma)
    VALUES (11111, eeg_reading_seq.nextval, '14:39:16:506', 200, 0, 0,
    250915, 46133, 115063, 27640, 34445,69014,41634, 99462);

--DELETE FROM sessions;
insert into sessions (session_id)
  VALUES(session_seq.nextval);