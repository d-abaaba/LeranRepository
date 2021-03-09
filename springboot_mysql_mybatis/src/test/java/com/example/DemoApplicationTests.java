package com.example;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private StudentDao studentDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void myTest() {
		Student st = studentDao.queryById(1);
		Assertions.assertEquals(st.getId(),1);
		Assertions.assertEquals(st.getName(),"zhangsan");
		Assertions.assertEquals(st.getAge(),10);

		List<Student> stList = studentDao.queryAllByLimit(1, 2);
		st = stList.get(0);
		Assertions.assertEquals(st.getId(),2);
		Assertions.assertEquals(st.getName(),"lisi");
		Assertions.assertEquals(st.getAge(),11);

		st.setId(3);
		st.setName("zhaoliu");
		st.setAge(12);
		int re = studentDao.insert(st);
		Assertions.assertEquals(re, 1);

		st.setAge(21);
		re = 0;
		re = studentDao.update(st);
		Assertions.assertEquals(re, 1);
		st = studentDao.queryById(3);
		Assertions.assertEquals(st.getAge(),21);

		re = 0;
		re = studentDao.deleteById(3);
		Assertions.assertEquals(re, 1);

		st = null;
		st = studentDao.queryById(3);
		Assertions.assertNull(st);
	}


}
