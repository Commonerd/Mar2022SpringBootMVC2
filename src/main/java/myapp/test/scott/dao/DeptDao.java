package myapp.test.scott.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myapp.test.scott.dto.Dept;

@Mapper
public interface DeptDao {

	/* 추상메서드니까 퍼블릭은 생략가능 */
	/*리턴타입 deptAll (파라미터);*/
	List<Dept> deptAll (); //select => 레코드 1개만 가져옴 : resultType그대로 작성하면 됨
	Dept deptOne(int no); // 레코드가 여러개(n개 이상) : List<resultType> 리절트타입을 제네릭으로 감싸서 리스트로 묶는다.
	int maxNo();
	int addDept(Dept d);//insert, update, delete => 리턴타입이 int가 됨. 
	//연결된 매퍼파일에서 아이디가 deptAll이라는 sql문을 실행시킨다. 
	int deleteDept(int deptno);
	int updateDept(Dept dept);
}
