package com.simple.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.simple.basic.entity.Memo;
import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPAPageableTest02 {

	@Autowired
	MemoRepository memoRepository;
	
	// 기본정렬 
//	@Test
//	public void testCode01() {
//		
//		// sort클래스는 정렬에 사용
//		Sort order = Sort.by("mno").descending();
//		
//		List<Memo> list = memoRepository.findAll(order); // sort클래스가 매개변수로 
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
	// 정렬조건 and
//	@Test
//	public void testCode02() {
//		
//		Sort order01 = Sort.by("writer").descending();
//		Sort order02 = Sort.by("text").ascending();
//		
//		Sort sort = order01.and(order02);
//	
//		List<Memo> list = memoRepository.findAll(sort);
//	
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
	// 페이지 클래스
	@Test
	public void testCode03() {
		
//		PageRequest pageable = PageRequest.of(0, 10); // 페이지번호, 데이터개수
//		
//		Page<Memo> result= memoRepository.findAll(pageable);
//	
//		for(Memo m : result.getContent()) {
//			System.out.println(m.toString());
//		}
		
		PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
	
		Page<Memo> result = memoRepository.findAll(pageable); // pageRequest를 넣으면 Page타입읍로 반환
		for(Memo m : result.getContent()) {
			System.out.println(m.toString());
		}
	
		System.out.println("총 페이지수:" + result.getTotalPages());
		System.out.println("총 데이터의 수 :" + result.getTotalElements());
		System.out.println("현재 페이지의 수:" + result.getNumber());
		System.out.println("데이터의 존재여부:" + result.hasContent() );
		System.out.println("시작페이지" + result.isFirst());
		System.out.println("마지막페이지" + result.isLast());
		System.out.println("데이터의 개수" + result.getSize());
	}
}
