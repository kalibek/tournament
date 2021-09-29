create table users
(
    id            bigserial primary key,
    login         varchar   not null,
    password_hash varchar   not null,
    player_id     bigint,
    created       timestamp not null default current_timestamp,
    updated       timestamp not null default current_timestamp
);
