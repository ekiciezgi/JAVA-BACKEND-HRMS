package kodlamaio.hrms.core.utilities.image;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<Map> upload(MultipartFile multipartFile);
	Map delete(String id) throws IOException;
}
