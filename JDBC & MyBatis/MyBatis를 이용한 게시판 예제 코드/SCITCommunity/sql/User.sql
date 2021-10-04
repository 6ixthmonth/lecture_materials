-- 사용자 테이블 삭제
DROP TABLE scit_user;

-- 사용자 테이블 생성
CREATE TABLE scit_user (
	  num NUMBER PRIMARY KEY	
	, name VARCHAR2(30) NOT NULL
	, id VARCHAR2(20) UNIQUE
	, pw VARCHAR2(30) NOT NULL
);

-- 회원 번호 시퀀스 삭제
DROP SEQUENCE user_seq;

-- 회원 번호 시퀀스 생성
CREATE SEQUENCE user_seq;

-- 기본 값(관리자) 데이터 입력
INSERT INTO
	scit_user
VALUES (
	  user_seq.NEXTVAL
	, '관리자'
	, 'ADMIN'
	, '0000'
);

COMMIT;