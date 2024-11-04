# INSERT INITIAL DATA
INSERT INTO tb_team (name, state, photo_url)
VALUES ('Flamengo', 'RJ', 'https://upload.wikimedia.org/wikipedia/commons/9/93/Flamengo-RJ_%28BRA%29.png'),
       ('Palmeiras', 'SP', 'https://upload.wikimedia.org/wikipedia/commons/1/10/Palmeiras_logo.svg'),
       ('Grêmio', 'RS',
        'https://lh3.ggpht.com/-QD9kMw474CY/Y27VyMQTh6I/AAAAAAAAGgI/sNIjHFsp5rUsVXL2o2dWSFTDox6aGX1IgCNcBGAsYHQ/s700/gremio.png'),
       ('Corinthians', 'SP', 'https://logodetimes.com/times/corinthians/logo-do-corinthians-4096.png'),
       ('Cruzeiro', 'MG', 'https://upload.wikimedia.org/wikipedia/commons/b/bc/Logo_Cruzeiro_1996.png'),
       ('Bahia', 'BA', 'https://logodownload.org/wp-content/uploads/2017/02/bahia-ec-logo-01.png'),
       ('Botafogo', 'RJ',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Botafogo_de_Futebol_e_Regatas_logo.svg/1816px-Botafogo_de_Futebol_e_Regatas_logo.svg.png'),
       ('Internacional', 'RS',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Escudo_do_Sport_Club_Internacional.svg/2048px-Escudo_do_Sport_Club_Internacional.svg.png'),
       ('São Paulo', 'SP',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Brasao_do_Sao_Paulo_Futebol_Clube.svg/2054px-Brasao_do_Sao_Paulo_Futebol_Clube.svg.png'),
       ('Sport', 'PE', 'https://logodownload.org/wp-content/uploads/2017/02/sport-recife-logo-escudo-1.png');

# INSERT INTO tb_match
INSERT INTO tb_match (date, team_one_id, score_team_one, team_two_id, score_team_two, team_supported_id)
VALUES ('2023-01-01 00:00:00', 1, 2, 2, 1, 1),
       ('2023-01-02 00:00:00', 3, 1, 4, 0, 4),
       ('2023-01-03 00:00:00', 5, 3, 6, 2, 5),
       ('2023-01-04 00:00:00', 7, 0, 8, 1, 8),
       ('2023-01-05 00:00:00', 9, 2, 10, 2, 10),
       ('2023-01-06 00:00:00', 2, 1, 1, 1, 2),
       ('2023-01-07 00:00:00', 4, 0, 3, 3, 3),
       ('2023-01-08 00:00:00', 6, 1, 5, 0, 6),
       ('2023-01-09 00:00:00', 8, 2, 7, 2, 7),
       ('2023-01-10 00:00:00', 10, 3, 9, 1, 9);