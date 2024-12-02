package hoangg.dev.data.dao;

import java.util.List;

import hoangg.dev.data.impl.CategoryImpl;
import hoangg.dev.data.impl.OrderImpl;
import hoangg.dev.data.impl.OrderItemImpl;
import hoangg.dev.data.impl.ProductImpl;
import hoangg.dev.data.impl.UserImpl;
import hoangg.dev.data.model.Category;

public class Database extends DatabaseDao {

    @Override
    public ProductDao getProductDao() {
        // TODO Auto-generated method stub
        return new ProductImpl();
    }

    @Override
    public CategoryDao getCategoryDao() {
        // TODO Auto-generated method stub
        return new CategoryImpl() {
			
			@Override
			public List<Category> hotCategory() {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }

    @Override
    public OrderItemDao getOrderItemDao() {
        // TODO Auto-generated method stub
        return new OrderItemImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        // TODO Auto-generated method stub
        return new OrderImpl();
    }

    @Override
    public UserDao getUserDao() {
        // TODO Auto-generated method stub
        return new UserImpl();
    }

}