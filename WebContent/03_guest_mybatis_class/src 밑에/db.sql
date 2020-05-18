/*
 * 1. 테이블 명 : comment_tab
 * 
 * 번호		comment_no		number(19)		PK
 * 사용자		user_id			varchar2(20)	
 * 내용		comment_content	varchar2(500)
 * 날짜		reg_date		date
 * 
 * 2. 시퀀스 만들기
 * 
 * 시퀀스명 : seq_comment
 * 
 * 3.레코드 2-3개 입력+커밋하기
 */

CREATE TABLE comment_tab(
    comment_no		number(19),
 	user_id			varchar2(20),	
 	comment_content	varchar2(500),
 	reg_date		date,
    CONSTRAINT pk_comment_no PRIMARY KEY (comment_no)
    );
    
        
CREATE SEQUENCE seq_comment
	MINVALUE 0
    INCREMENT BY 1;