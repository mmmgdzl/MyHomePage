package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;

public interface AdminService {
	
	/**
	 * ¹ÜÀíÔ±µÇÂ¼
	 */
	Result adminLogin(String account, String password);
	
}
