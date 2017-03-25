package com.fruit.fruit.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruit.entity.Fruit;
import com.fruit.framework.Page;
import com.fruit.fruit.dao.FruitDaoImpl;

@Service
@Transactional(readOnly = false)
public class FruitServiceImpl {
	
	@Resource
	private FruitDaoImpl fruitDaoImpl;
	
	public void addFruit(Fruit f){
		this.fruitDaoImpl.saveFruit(f);
	}
	
	@Transactional(readOnly=true)
	public Page<Fruit>listFruit(int pageNum,int pageSize,Object[]params){
		return this.fruitDaoImpl.findFruit(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public Fruit getFruit(Integer fruitNumber){
		return this.fruitDaoImpl.getFruit(fruitNumber);
	}
	
	//修改商品信息
	public void editFruit(Fruit f){
		Fruit fr = this.fruitDaoImpl.getFruit(f.getNumber());
		fr.setName(f.getName());
		fr.setColor(f.getColor());
		fr.setNature(f.getNature());
		fr.setPrice(f.getPrice());
		fr.setPlace(f.getPlace());
		fr.setStock(f.getStock());
		fr.setTime(f.getTime());
		this.fruitDaoImpl.updateFruit(fr);
	}
	
	//删除商品信息
	public void dropFruit(Integer fruitNumber){
		this.fruitDaoImpl.deleteFruit(fruitNumber);
	}
}
