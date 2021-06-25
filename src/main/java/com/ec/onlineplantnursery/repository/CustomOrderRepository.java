package com.ec.onlineplantnursery.repository;

import java.util.List;
import com.ec.onlineplantnursery.entity.Planter;
public interface CustomOrderRepository {

	public List<Planter> getPlanterByOrderId(int orderId);


}
