-- 혹시 같은 이름을 사용하는 테이블이 있는 경우를 대비해서 미리 drop 시도.
drop table mybatis_member;

-- 회원 테이블 생성 쿼리.
create table mybatis_member (
	  member_no			number 			primary key			-- 회원 번호 (PK)
	, member_name		varchar2(20)	not null			-- 회원 이름
	, member_age		number			not null			-- 회원 나이
	, member_phone		varchar2(20)						-- 회원 전화번호
	, member_address	varchar2(200)						-- 회원 주소
	, member_indate		date			default sysdate		-- 회원 등록일
);

-- 혹시 같은 이름을 사용하는 시퀀스가 있는 경우를 대비해서 미리 drop 시도.
drop sequence member_seq;

-- 회원 번호에 사용할 시퀀스 생성 쿼리.
create sequence member_seq;

-- 초기 데이터 입력.
insert into mybatis_member (
	  member_no
	, member_name
	, member_age
	, member_phone
	, member_address
) values ( 
	  member_seq.nextval
	, '홍길동'
	, 25
	, '010-1234-5678'
	, '코엑스 4층 ICT 교육센터'
);

commit;