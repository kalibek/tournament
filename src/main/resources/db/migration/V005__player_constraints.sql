alter table group_players
    add constraint unique_player unique (group_id, player_id);
