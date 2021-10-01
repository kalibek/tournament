create table players
(
    id      bigserial primary key,
    name    varchar   not null,
    rating  int       not null default 1200,
    created timestamp not null default current_timestamp,
    updated timestamp not null default current_timestamp
);

create table series
(
    id      bigserial primary key,
    name    varchar   not null,
    created timestamp not null default current_timestamp,
    updated timestamp not null default current_timestamp
);

create table tournaments
(
    id        bigserial primary key,
    name      varchar   not null,
    series_id bigint    not null,
    run_date  timestamp not null,
    status    varchar   not null,
    foreign key (series_id) references series (id) on delete cascade,
    created   timestamp not null default current_timestamp,
    updated   timestamp not null default current_timestamp
);

create table groups
(
    id            bigserial primary key,
    name          varchar   not null,
    tournament_id bigint    not null,
    position      int,
    run_date      timestamp not null,
    status        varchar   not null,
    foreign key (tournament_id) references tournaments (id) on delete cascade,
    created       timestamp not null default current_timestamp,
    updated       timestamp not null default current_timestamp

);

create table group_players
(
    id                bigserial primary key,

    group_id          bigint    not null,
    player_id         bigint    not null,
    starting_position int       not null,
    score             int,
    place             int,
    foreign key (group_id) references groups (id) on delete cascade,
    foreign key (player_id) references players (id) on delete cascade,
    created           timestamp not null default current_timestamp,
    updated           timestamp not null default current_timestamp
);

create table matches
(
    id               bigserial primary key,
    group_id         bigint    not null,
    group_player1_id bigint    not null,
    group_player2_id bigint    not null,
    player1_result   int,
    player2_result   int,
    status           varchar   not null,
    foreign key (group_id) references groups (id) on delete cascade,
    foreign key (group_player1_id) references group_players (id) on delete cascade,
    foreign key (group_player1_id) references group_players (id) on delete cascade,
    created          timestamp not null default current_timestamp,
    updated          timestamp not null default current_timestamp
);

create table Rating
(
    id             bigserial primary key,
    -- below keys are nullable for manual rating changes
    player_id      bigint,
    match_id       bigint,
    tournament_id  bigint,
    current_rating int       not null,
    delta          int       not null,
    foreign key (player_id) references players (id) on delete cascade,
    created        timestamp not null default current_timestamp,
    updated        timestamp not null default current_timestamp
);