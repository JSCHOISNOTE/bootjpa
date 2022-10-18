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
public class JPAQueryTest03 {

	@Autowired
	MemoRepository memoRepository;
	// 쿼리 메서드 - 메서드의 이름을 보고 jpa가 sql문을 실행시킴
	// 반드시 document 확인해야함
//	@Test
//	public void testCode01() {
//		List<Memo> list = memoRepository.findByMnoBetween(10L,50L);
//	
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void TestCOde02() {
//		List<Memo> list = memoRepository.findByTextOrderByMnoDesc("sample1");
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void testCode03() {
//		
//		List<Memo> list = memoRepository.findByTextIn(Arrays.asList(new String[] {"sample1","sample2"}));
//	
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void testCode04() {
//		
//		List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(10L,20L);
//	
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
//	@Test
//	public void testCode05() {
//		
//		List<Memo> list = memoRepository.findByTextLikeOrWriterLike("%12%", "%13%");
//		
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
	@Test
	public void testCode06() {
		
		PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		
		Page<Memo> page = memoRepository.findByMnoBetween(10L, 50L, pageable);
	
		for(Memo m : page.getContent()) {
			System.out.println(m.toString());
		}
	}
}
