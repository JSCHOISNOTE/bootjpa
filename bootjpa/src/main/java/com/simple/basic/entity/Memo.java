package com.simple.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //jpa가 엔티티로 관리한다는 의미
@Table(name = "TBL_MEMO") //테이블명
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Memo {
	
	//동일한 테이블이 있다면 자동생성하지 않는다.
	//mysql auto_increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long mno;
	//컬럼의 null여부, 길이
	@Column(nullable = false, length = 200)
	//컬럼을 직접 지정하는방법
	private String writer;
	@Column(columnDefinition = "varchar(200) default 'y' ")
	private String text;
	
}
