package com.ec.onlineplantnursery.service;

import java.util.Comparator;

import com.ec.onlineplantnursery.entity.Seed;

public class ProductLowToHighCost implements Comparator<Seed> {

	@Override
	public int compare(Seed s1, Seed s2) {
		return (int) (s1.getSeedsCost() - s2.getSeedsCost());
	}
}
