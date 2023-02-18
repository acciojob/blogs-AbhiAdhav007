package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog

        Blog originalBlog=blogRepository2.findById(blogId).get();

        Image newImage=new Image();
        newImage.setDescription(description);
        newImage.setDimension(description);


        List<Image>updateImage=originalBlog.getBlogImages();
        updateImage.add(newImage);
        originalBlog.setBlogImages(updateImage);

        newImage.setBlog(originalBlog);
        blogRepository2.save(originalBlog);

        return newImage;

    }

    public void deleteImage(Integer id){
        Image image=imageRepository2.findById(id).get();

        List<Image>images=image.getBlog().getBlogImages();
        for(Image image1:images){
            if(image1.equals(image)){
                images.remove(image);
            }
        }

        imageRepository2.delete(image);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`


        Image image=imageRepository2.findById(id).get();

        String imagesize=image.getDimension();
        String []imagearr=imagesize.split("X");
        int ima1=Integer.parseInt(imagearr[0]);
        int ima2=Integer.parseInt(imagearr[1]);

        String []screenarr=screenDimensions.split("X");

        int scr1=Integer.parseInt(screenarr[0]);
        int scr2=Integer.parseInt(screenarr[1]);


        int scrmul=scr1*scr2;
        int imamul=ima1*ima2;
        return scrmul/imamul;



    }
}