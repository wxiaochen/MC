package com.fruit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.fruit.entity.Logininfo;
import com.fruit.entity.Power;

public class PackUpMenuServiceImpl {

	
	/**
	 * 
	 * @param 登陆人的信息（包括：loginName、password）
	 * @return 一个存储用户菜单的map
	 */
	public static HashMap<Power, List> packUpMenu(Logininfo li) {
		
		// 获取所有的权限
		Set<Power> powers = li.getRole().getPowers();

		// 用map来存储菜单
		HashMap<Power, List> menus = new HashMap<Power, List>();

		// 先将所有的一级菜单放到map的key中
		Iterator<Power> oneMenus = powers.iterator();
		while (oneMenus.hasNext()) {
			Power temp = oneMenus.next();
			if (temp.getParentId() == null || temp.getParentId().equals("")) {
				List<Power> list = new ArrayList<Power>(0);
				menus.put(temp, list);
			}
		}

		// 遍历所有权限，如果该权限的父级权限已经在menus中存储，则将其插入到响应的二级菜单中
		Iterator<Power> allPower = powers.iterator();
		while (allPower.hasNext()) {
			Power temp = allPower.next();

			Set<Power> keys = menus.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				Power po = (Power) iterator.next();
				if (temp.getParentId().equals(po.getPowerId())) {
					menus.get(po).add(temp);
				}
			}
		}

		// 删除没有二级菜单的一级菜单
		Iterator<Entry<Power, List>> it = menus.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Power, List> entry = it.next();
			Power key = entry.getKey();
			if (menus.get(key).size() == 0) {
				it.remove();
			}
		}
		
		return menus;
		
	}

}
