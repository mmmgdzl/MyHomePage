package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * �ϴ�ͷ��
     */
    Result updateHeadImage(MultipartFile headImage, Integer aid);
}
