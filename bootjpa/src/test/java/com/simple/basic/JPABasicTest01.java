package com.simple.basic;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.simple.basic.repository.MemoRepository;

@SpringBootTest
public class JPABasicTest01 {

	@Autowired
	MemoRepository memoRepository;
	
//	@Test
//	public void testCode01() {
//		System.out.println(memoRepository.getClass().getName());
//		
//	}
	
	// insert 작업
//	@Test
//	public void testCode02() {
//		
//		for(int i = 1; i<= 300; i++) {
//			Memo memo = Memo.builder()
//							.writer("admin" + i)
//							.text("sample" + i)
//							.build();	
//			memoRepository.save(memo);
//		}
//	}
	
	// select 작업 - find메서드로 시작 
//	@Test
//	public void testCode03() {
//		// 101번 조회
//		Optional<Memo> result = memoRepository.findById(101L);
//		
//		if(result.isPresent()) {
//			Memo memo = result.get();
//			System.out.println(memo.toString()); // 결과 확인
//		} else {
//			System.out.println("결과가 없습니다");
//		}
//	}
	
	// select 작업
//	@Test
//	public void testCode04() {
//		List<Memo> list = memoRepository.findAll();
//		for(Memo m : list) {
//			System.out.println(m.toString());
//		}
//	}
	
	// update작업
//	@Test
//	public void testCode05() {
//		// 101번을 업데이트
//		// 내부적으로 select로 해당번호를 확인하고, 업데이트를 진행합니다.
//		// 해당 객체가 없다면 insert로 진행합니다.
//		Memo memo = Memo.builder().mno(101L)
//					  .writer("업데이트됨!")
//					  .text("업데이트완료!")
//					  .build();
//		
//		Memo result = memoRepository.save(memo);
//		System.out.println("업데이트된 엔티티:" + result);
//	}
	
	// delete작업
	@Test
	public void testCode06() {
		
		memoRepository.deleteById(200L); // 200번삭제
	}
}
