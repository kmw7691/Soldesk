create schema `kwak` default character set
utf8mb4 default collate utf8mb4_general_ci;

use kwak;


-- 유저테이블
CREATE TABLE kwak.users (
    id INT NOT NULL AUTO_INCREMENT, -- 고유 식별자
    name VARCHAR(20) NOT NULL, -- 이름
    age INT UNSIGNED NOT NULL, -- 나이
    married TINYINT NOT NULL, -- 결혼 여부
    comment TEXT, -- 자기소개
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 데이터 생성 날짜
    PRIMARY KEY (id), -- PK
    UNIQUE INDEX name_unique (name ASC) -- 고유값 설정
) ENGINE = InnoDB COMMENT = '사용자정보';
