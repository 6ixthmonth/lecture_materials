-- 게시판 테이블 삭제
DROP TABLE notice_board;
DROP TABLE free_board;

-- 공지사항 테이블 생성
CREATE TABLE notice_board (
	  num NUMBER PRIMARY KEY	
	, title VARCHAR2(200) NOT NULL
	, content VARCHAR2(1000)
	, id VARCHAR2(20) REFERENCES scit_user(id)
	, written_date DATE DEFAULT SYSDATE
	, hits NUMBER DEFAULT 0
);

-- 자유게시판 테이블 생성
CREATE TABLE free_board (
	  num NUMBER PRIMARY KEY	
	, title VARCHAR2(200) NOT NULL
	, content VARCHAR2(1000)
	, id VARCHAR2(20) REFERENCES scit_user(id)
	, written_date DATE DEFAULT SYSDATE
	, hits NUMBER DEFAULT 0
);

-- 게시판 시퀀스 삭제
DROP SEQUENCE notice_board_seq;
DROP SEQUENCE free_board_seq;

-- 게시판 시퀀스 생성
CREATE SEQUENCE notice_board_seq;
CREATE SEQUENCE free_board_seq;

-- 기본 값(공지사항) 데이터 입력
INSERT INTO
	notice_board
VALUES (
	  notice_board_seq.NEXTVAL
	, 'SCIT 공지사항입니다.'
	, '공부 열심히 하세요.'
	, 'ADMIN'
	, SYSDATE
	, DEFAULT
);

INSERT INTO
	free_board
VALUES (
	  free_board_seq.NEXTVAL
	, '1emd'
	, 'zz'
	, 'ADMIN'
	, SYSDATE
	, DEFAULT
);

COMMIT;