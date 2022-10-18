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
public class JPAQueryTest04 {

	@Autowired
	MemoRepository memoRepository;
	
//	@Test
//	public void testCode01() {
//		List<Memo> list = memoRepository.getListDesc();
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void testCode02() {
//		List<Memo> list = memoRepository.getListDesc2(50L);
//	
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}

//	@Test
//	public void testCode03() {
//		List<Memo> list = memoRepository.getListLike("12");
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void testCode04() {
//		int result = memoRepository.updateMemo("변경할값", 100L);
//	
//		System.out.println("업데이트수행결과:" + result);
//	}
	
//	@Test
//	public void testCode05() {
//		
//		Memo memo = Memo.builder().mno(101L)
//								  .writer("객체파라미터변경")
//								  .text("객체파라미터사용")
//								  .build();
//		
//		int result = memoRepository.updateMemo(memo);
//		System.out.println("업데이트수행결과:" + result);
//	}
	
//	@Test
//	public void testCode06() {
//		
//		PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno"));
//		long num = 100L;
//		
//		Page<Memo> result = memoRepository.getListJPQL(num, pageable);
//	
//		for(Memo m : result.getContent()) {
//			System.out.println(m.toString());
//		}
//		System.out.println("전체게시글수:" + result.getTotalElements());
//		System.out.println("페이지개수:" + result.getTotalPages());
//	}
	
	@Test
	public void testCode07() {
		
		Memo m = memoRepository.getNative(100L);
		System.out.println(m.toString());
		
	}
	
}
