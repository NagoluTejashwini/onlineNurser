package com.ec.onlineplantnursery.service;


	import java.util.Comparator;

import com.ec.onlineplantnursery.entity.Seed;


	public class ProductHighToLowCost implements Comparator<Seed> {

		@Override
		public int compare(Seed s1, Seed s2) {
			// TODO Auto-generated method stub
			return (int) (s2.getCost() - s1.getCost());
		}

	}