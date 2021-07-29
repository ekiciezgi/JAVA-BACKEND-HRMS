package kodlamaio.hrms.core.utilities.image;


import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageCloudinaryManager implements ImageService{

	Cloudinary cloudinary;
	public ImageCloudinaryManager() 
	{
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "drtniio0r",
				"api_key", "291971955751141",
				"api_secret", "29cADVk0cg6IPuEcFbzC_6jsWbU"));
	}
	

	@Override
	public DataResult<Map> upload(MultipartFile multipartFile)  {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

	@Override
	public Map delete(String id) throws IOException {
		Map result= cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return result;
	}
	
	 private File convertToFile(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream stream = new FileOutputStream(file);
	        stream.write(multipartFile.getBytes());
	        stream.close();

	        return file;
	    }

}
