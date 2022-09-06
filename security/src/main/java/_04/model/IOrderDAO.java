package _04.model;

import java.util.List;

public interface IOrderDAO {

	int insert(String orderId, double amount);

	List<OrderBean> getAllBeans();

	int deleteBean();

	int getKey();

	void setKey(int key);

	int delete(int key);

}