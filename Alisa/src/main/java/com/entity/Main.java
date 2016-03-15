package com.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		//Заповнюємо табличку з розмірами
		//Увага  - заповнено тільки жіночі розміра
			/*
			Size xxs = new Size();
			xxs.setSizeName("XXS");
			xxs.setUkrSize("40");
			em.persist(xxs);
			
			Size xs = new Size();
			xs.setSizeName("XS");
			xs.setUkrSize("42");
			em.persist(xs);
			
			Size s = new Size();
			s.setSizeName("S");
			s.setUkrSize("44");
			em.persist(s);
			
			Size m = new Size();
			m.setSizeName("M");
			m.setUkrSize("46");
			em.persist(m);
			
			Size l = new Size();
			l.setSizeName("L");
			l.setUkrSize("48");
			em.persist(l);
			
			Size xl1 = new Size();
			xl1.setSizeName("L/XL");
			xl1.setUkrSize("50");
			em.persist(xl1);
			
			Size xl2 = new Size();
			xl2.setSizeName("XL");
			xl2.setUkrSize("52");
			em.persist(xl2);
			
			Size xxl1 = new Size();
			xxl1.setSizeName("XXL");
			xxl1.setUkrSize("54");
			em.persist(xxl1);
			
			Size xxl2 = new Size();
			xxl2.setSizeName("XXL");
			xxl2.setUkrSize("56");
			em.persist(xxl2);
			
			Size xxxl = new Size();
			xxxl.setSizeName("XXXL");
			xxxl.setUkrSize("58");
			em.persist(xxxl);
		
		//Таблиця виробників (Перелік країн )
		
			Producer ukraine = new Producer();
			ukraine.setProducerName("Україна");
			em.persist(ukraine);
			
			Producer chaina = new Producer();
			chaina.setProducerName("Китай");
			em.persist(chaina);
		
		//Категорії виробів
		
			CategoryProduct man = new CategoryProduct();
			man.setNameCategory("Чоловічий одяг");
			em.persist(man);
			
			CategoryProduct woman = new CategoryProduct();
			woman.setNameCategory("Жіночий одяг");
			em.persist(woman);
			
			CategoryProduct child = new CategoryProduct();
			child.setNameCategory("Дитячий одяг");
			em.persist(child);
			
			CategoryProduct accessories = new CategoryProduct();
			accessories.setNameCategory("Аксесуари");
			em.persist(accessories);
		
		//Таблиця під-категорії 
		//Жіноча лінійка
		
			pidCategory dress  = new pidCategory();
			dress.setNamePidkategory("Плаття");
			dress.setCategoryProduct(em.find(CategoryProduct.class, 2));
			em.persist(dress);
			
			pidCategory shirt  = new pidCategory();
			shirt.setNamePidkategory("Сорочки");
			shirt.setCategoryProduct(em.find(CategoryProduct.class, 2));
			em.persist(shirt);
			
			pidCategory tshirt  = new pidCategory();
			tshirt.setNamePidkategory("Футболки");
			tshirt.setCategoryProduct(em.find(CategoryProduct.class, 2));
			em.persist(tshirt);
			
			pidCategory sport  = new pidCategory();
			sport.setNamePidkategory("Спортивний");
			sport.setCategoryProduct(em.find(CategoryProduct.class, 2));
			em.persist(sport);
			
			pidCategory suit  = new pidCategory();
			suit.setNamePidkategory("Костюми");
			suit.setCategoryProduct(em.find(CategoryProduct.class, 2));
			em.persist(suit);
			
			pidCategory skirt  = new pidCategory();
			skirt.setNamePidkategory("Спідниці");
			skirt.setCategoryProduct(em.find(CategoryProduct.class, 2));
		em.persist(skirt);
		
		//Таблиця користувачів
		
			User osalamaxa = new User();
			osalamaxa.setLogin("osalamaxa");
			osalamaxa.setPassword("test");
			em.persist(osalamaxa);
			
			User vshpelyk = new User();
			vshpelyk.setLogin("vshpelyk");
			vshpelyk.setPassword("test");
			em.persist(vshpelyk);
		
		//Замовлення
		
				UserOrder n001 = new UserOrder();
				n001.setUser(em.find(User.class, 1));
				em.persist(n001);
		
		//Таблиця товарів
		
		Product wd001 = new Product();
		wd001.setProductName("Плаття");
		wd001.setPidCategory(em.find(pidCategory.class, 1));
		wd001.setArticul("WD001");
		wd001.setPrice(230);
		wd001.setProducer(em.find(Producer.class, 1));
		wd001.setSize(em.find(Size.class, 3));
		wd001.setOrder(em.find(UserOrder.class, 1));
		em.persist(wd001);
		
		Product wd002 = new Product();
		wd002.setProductName("Плаття");
		wd002.setPidCategory(em.find(pidCategory.class, 1));
		wd002.setArticul("WD002");
		wd002.setPrice(200);
		wd002.setProducer(em.find(Producer.class, 1));
		wd002.setSize(em.find(Size.class, 4));
		em.persist(wd002);
		
		Product wd003 = new Product();
		wd003.setProductName("Плаття");
		wd003.setPidCategory(em.find(pidCategory.class, 1));
		wd003.setArticul("WD003");
		wd003.setPrice(360);
		wd003.setProducer(em.find(Producer.class, 1));
		wd003.setSize(em.find(Size.class, 3));
		em.persist(wd003);

		//em.remove(em.find(Size.class, 12));
		
		//Селекти
		//Витягуємо всі об'єкти з таблиці Size
		List<Size> list = em.createQuery("select s from Size s").
				getResultList();
		for (Size size : list) {
			System.out.println(size.getSizeName());
		}
//		
		List<Product> products = em.createQuery("select s from Product s").
				getResultList();
		for (Product product : products) {
			System.out.println(product.getId());
			System.out.println(product.getProductName());
			System.out.println(product.getPrice());
			System.out.println(product.getSize().getSizeName());
		}
		
		//Select з використання where
		List<Product> pr = em.createQuery("select p from Product p where " +
				"p.productName = :productName").setParameter("productName", "Test").getResultList();
		for (Product product : pr) {
			System.out.println(product.getId());
			System.out.println(product.getProductName());
			System.out.println(product.getPrice());
			System.out.println(product.getSize().getSizeName());
		}
		//Select (шукаємо значення Size по назві продукту)
		List<Size> ss = em.createQuery("select s from Size s join s.product p where " +
				"p.productName = :productName").setParameter("productName", "Test").getResultList();
		for (Size size : ss) {
			System.out.println(size.getSizeName());
			
		}
		//Select через дві таблиці
		List<User> users = em.createQuery("select u from User u join u.orders o join " +
				"o.products p where "+
				"p.productName = :productName").setParameter("productName", "Test").getResultList();
		for (User user : users) {
			System.out.println(user.getLogin());
			
		}
*/
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}