
drop table if exists session;

create table session(
    code varchar(10) primary key,
    name varchar(100) not null,
    location varchar(100) not null,
    date date not null,
    start time not null,
    end time not null
);

insert into session values
('WPS302', 'Improper payment identification using analytics and ML', 'Caesars Forum, Alliance 312, Level 1', '2022-11-28', '11:30', '12:30'),
('MFG202', 'Building a digital twin of an industrial machine', 'Mandalay Bay, South Pacific D, Level 1 North', '2022-11-28', '14:30', '15:30');