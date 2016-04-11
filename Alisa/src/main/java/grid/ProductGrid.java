package grid;

import java.util.List;

import com.entity.Product;

public class ProductGrid {
	
	private int totalPages;
	private int currentPage;
	private long totalRecords;
	private List<Product> productData;
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<Product> getProductData() {
		return productData;
	}
	public void setProductData(List<Product> productData) {
		this.productData = productData;
	}
	
	

}
