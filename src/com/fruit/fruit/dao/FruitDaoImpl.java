package com.fruit.fruit.dao;

import org.springframework.stereotype.Repository;

import com.fruit.entity.Fruit;
import com.fruit.framework.BaseDao;
import com.fruit.framework.Page;

@Repository
public class FruitDaoImpl extends BaseDao<Fruit, Integer> {

	// 增加产品
	public void saveFruit(Fruit f) {
		try {
			this.save(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查找水果列表
	public Page<Fruit> findFruit(int pageNum, int pageSize, Object[] params) {
		String hql;
		if (params != null && params.length > 0) {
			hql = "from Fruit f where f.name like ?";
			
			params[0] = "%" + params[0] + "%";
		} else {
			hql = "from Fruit";
		}
		try {
			Page<Fruit> page = new Page<Fruit>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page = this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//根据主键得到某一个水果对象
	public Fruit getFruit(Integer number){
		
		try {
			Fruit f = this.get(number);
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//更新某个产品
	public void updateFruit(Fruit f){
		try {
			this.update(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//根据产品的id删除某产品
	public void deleteFruit(Integer fruitNumber){
		try {
			this.delete(fruitNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
