package kong.blog.domain.post.application;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageUploadService {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;


    // Dependency injection
    public ImageUploadService(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public String imageUpload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            amazonS3Client.putObject(bucketName, originalFilename, file.getInputStream(), metadata);
            return amazonS3Client.getUrl(bucketName, originalFilename).toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return amazonS3Client.getUrl(bucketName, originalFilename).toString();
    }

    public List<String> imagesUpload(List<MultipartFile> files) {
        List<String> imageList = new ArrayList<>();
        for (MultipartFile file : files) {
            imageList.add(imageUpload(file));
        }
        return imageList;
    }
}


