create table cytaty
(
    id_cytaty       bigint auto_increment primary key,
    cytat           varchar(250) not null,
    autor           varchar(50) not null
);

create table expenses
(
    id_expenses     bigint auto_increment primary key,
    name            varchar(100) not null,
    category        varchar(30) not null
);