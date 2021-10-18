begin transaction;

alter sequence seq_user_id restart with 1000;

end transaction;