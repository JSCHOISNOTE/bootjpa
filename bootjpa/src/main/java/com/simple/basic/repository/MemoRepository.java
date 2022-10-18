package com.simple.basic.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.simple.basic.entity.Memo;

// JPA인터페이스를 상속받는걸로 자동으로 빈등록이 일어납니다
// <엔티티명, 엔티티의 ID타입>
public interface MemoRepository extends JpaRepository<Memo, Long> {

	// 쿼리메서드
	// select * from Memo where mno between ? and ?
	List<Memo> findByMnoBetween(Long start, Long end);
	
	// select * from Memo where text = ? order by mno desc
	List<Memo> findByTextOrderByMnoDesc(String text);
	
	// select * from Memo where text in('sample1', 'sample2', 'sample3')
	List<Memo> findByTextIn(List<Object> list);
	
	// select * from Memo where mno between ? and ? order by mno desc
	List<Memo> findByMnoBetweenOrderByMnoDesc(Long start, Long end);
	
	// select * from Memo where text like '%12%' or writer like '%13%'
	List<Memo> findByTextLikeOrWriterLike(String text, String writer);
	
	// 쿼리메서드와 PageRequest의 조합
	// 매개변수로 Page 인터페이스타입을 전달, 반환은 Page<Memo>로 받는다
	Page<Memo> findByMnoBetween(Long start, Long end, Pageable page);
	
	// JPQL - sql과 유사하나 엔티티를 사용해서 작성
	@Query("select m from Memo m order by m.mno desc")
	List<Memo> getListDesc();
	
	// JPQL 파라미터 전달 @Param(이름), :이름
	@Query("select m from Memo m where m.mno > :num order by m.mno desc")
	List<Memo> getListDesc2(@Param("num")Long num);
	
	//  
	@Query("select m from Memo m where m.writer like %:search%")
	List<Memo> getListLike(@Param("search")String writer);
	
	// JPQL - insert, update는 @Transactional, @Modifying을 붙입니다
	@Transactional
	@Modifying
	@Query("update Memo m set m.writer = :a where m.mno = :b")
	int updateMemo(@Param("a") String a, @Param("b") Long b);
	
	// JPQL 객체파라미터 전달 :#{#변수명.필드명}
	@Transactional
	@Modifying
	@Query("update Memo m set m.writer = :#{#a.writer}, m.text = :#{#a.text} where m.mno = :#{#a.mno}")
	int updateMemo(@Param("a") Memo memo);
	
	// JPQL의 페이지결합
	@Query("select m from Memo m where m.mno > :a")
	Page<Memo> getListJPQL(@Param("a") Long a, Pageable pageable);
	
	// 네이티브쿼리
	// native속성을 true
	@Query(value = "select * from tbl_memo where mno = ?", nativeQuery = true)
	Memo getNative(Long mno);
}
