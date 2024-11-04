DROP DATABASE IF EXISTS match_diary;
CREATE DATABASE match_diary;
USE match_diary;

# CREATE TABLE TEAM
CREATE TABLE tb_team
(
    id        INTEGER PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(100)  NOT NULL,
    state     VARCHAR(2)    NOT NULL CHECK (state IN
                                            ('AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS',
                                             'MG',
                                             'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RD', 'RR', 'SC', 'SP',
                                             'SE',
                                             'TO')),
    photo_url VARCHAR(1024) NOT NULL,
    UNIQUE (name, state)
);

# CREATE TABLE MATCH
CREATE TABLE tb_match
(
    id             INTEGER PRIMARY KEY AUTO_INCREMENT,
    date           DATETIME NOT NULL,
    team_one_id    INTEGER  NOT NULL REFERENCES tb_team (id) ON UPDATE CASCADE ON DELETE NO ACTION,
    score_team_one INTEGER  NOT NULL,
    team_two_id    INTEGER  NOT NULL REFERENCES tb_team (id) ON UPDATE CASCADE ON DELETE NO ACTION,
    score_team_two INTEGER  NOT NULL,
    team_supported INTEGER  NOT NULL REFERENCES tb_team (id) ON UPDATE CASCADE ON DELETE NO ACTION,
    UNIQUE (date, team_one_id, team_two_id)
);